package com.example.controller;

import com.example.dao.AlunoDAO;
import com.example.model.Aluno;

public class AlunoController {

    private AlunoDAO alunoDAO;

    public AlunoController() {
        this.alunoDAO = new AlunoDAO();
    }

    public void cadastrarAluno(Aluno aluno) {
        alunoDAO.cadastrarAluno(aluno);
    }
}