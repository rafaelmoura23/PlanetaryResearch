package com.example.controller;

import com.example.dao.AlunoDAO;
import com.example.dao.ProfessorDAO;
import com.example.model.Aluno;
import com.example.model.Professor;

public class LoginController {
    private ProfessorDAO professorDAO;
    private AlunoDAO alunoDAO;

    public LoginController() {
        this.professorDAO = new ProfessorDAO();
        this.alunoDAO = new AlunoDAO();
    }

    public Professor loginProfessor(String email, String senha) {
        return professorDAO.buscarProfessorPorEmailESenha(email, senha);
    }

    public Aluno loginAluno(String email, String senha) {
        return alunoDAO.buscarAlunoPorEmailESenha(email, senha);
    }
}
