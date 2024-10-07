package com.example.controller;

import com.example.dao.AlunoDAO;
import com.example.dao.ProfessorDAO;
import com.example.model.Aluno;
import com.example.model.Professor;

import javax.swing.JOptionPane;
import lombok.Getter;

@Getter
public class LoginController {
    private ProfessorDAO professorDAO;
    private AlunoDAO alunoDAO;

    public LoginController() {
        this.professorDAO = new ProfessorDAO();
        this.alunoDAO = new AlunoDAO();
    }

    // Validação do formato de e-mail
    private boolean isEmailValido(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && email.matches(emailRegex);
    }

    public Professor loginProfessor(String email, String senha) {
        try {
            validarLogin(email, senha);
            Professor professor = professorDAO.buscarProfessorPorEmailESenha(email, senha);

            if (professor == null) {
                JOptionPane.showMessageDialog(null, "Credenciais inválidas. Verifique o email e a senha.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
            }
            return professor;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public Aluno loginAluno(String email, String senha) {
        try {
            validarLogin(email, senha);
            Aluno aluno = alunoDAO.buscarAlunoPorEmailESenha(email, senha);

            if (aluno == null) {
                JOptionPane.showMessageDialog(null, "Credenciais inválidas. Verifique o email e a senha.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
            }
            return aluno;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método comum para validar o login
    private void validarLogin(String email, String senha) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo de email não pode estar vazio.");
        }

        if (!isEmailValido(email)) {
            throw new IllegalArgumentException("O formato do email é inválido.");
        }

        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo de senha não pode estar vazio.");
        }
    }
}
