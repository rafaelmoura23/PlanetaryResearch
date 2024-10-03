package com.example.controller;

import com.example.dao.AlunoDAO;
import com.example.dao.ProfessorDAO;
import com.example.model.Aluno;
import com.example.model.Professor;

import lombok.Getter;

@Getter
public class LoginController {
    private ProfessorDAO professorDAO;
    private AlunoDAO alunoDAO;
    private String tipoUsuario;

    public LoginController() {
        this.professorDAO = new ProfessorDAO();
        this.alunoDAO = new AlunoDAO();
    }

    public Professor loginProfessor(String email, String senha) {
        Professor professor = professorDAO.buscarProfessorPorEmailESenha(email, senha);
        if (professor != null) {
            tipoUsuario = "professor"; 
        }
        return professor;
    }

    public Aluno loginAluno(String email, String senha) {
        Aluno aluno = alunoDAO.buscarAlunoPorEmailESenha(email, senha);
        if (aluno != null) {
            tipoUsuario = "aluno";
        }
        return aluno;
    }
}
