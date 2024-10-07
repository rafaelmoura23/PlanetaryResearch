package com.example.controller;

import com.example.dao.ProfessorDAO;
import com.example.model.Professor;

import javax.swing.JOptionPane;
import java.util.regex.Pattern;

public class ProfessorController {

    private ProfessorDAO professorDAO;

    public ProfessorController() {
        this.professorDAO = new ProfessorDAO();
    }

    public boolean cadastrarProfessor(Professor professor) {
        // Validações
        if (professor.getNome() == null || professor.getNome().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O nome não pode ser vazio.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (professor.getEmail() == null || !isValidEmail(professor.getEmail())) {
            JOptionPane.showMessageDialog(null, "Email inválido.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (professor.getTelefone() == null) {
            JOptionPane.showMessageDialog(null, "Número de telefone inválido. Insira apenas números.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (professor.getRegistroFaculdade() == null || professor.getRegistroFaculdade().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O registro da faculdade não pode ser vazio.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (professor.getIdade() == null || !isValidAge(professor.getIdade())) {
            JOptionPane.showMessageDialog(null, "Idade inválida. Deve ser um número positivo.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (professor.getSenha() == null || professor.getSenha().length() < 6) {
            JOptionPane.showMessageDialog(null, "A senha deve ter pelo menos 6 caracteres.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (professor.getAreaDeEstudo() == null || professor.getAreaDeEstudo().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A área de estudo não pode ser vazia.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Se todas as validações forem bem-sucedidas
        professorDAO.cadastrarProfessor(professor);
        JOptionPane.showMessageDialog(null, "Professor cadastrado com Sucesso!");
        return true;
    }

    // Método para validar o formato do email
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // Método para validar a idade (deve ser um número e positivo)
    private boolean isValidAge(String idadeStr) {
        try {
            int idade = Integer.parseInt(idadeStr);
            return idade > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
