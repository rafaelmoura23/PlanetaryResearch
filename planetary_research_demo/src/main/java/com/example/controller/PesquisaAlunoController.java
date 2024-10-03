package com.example.controller;

import com.example.dao.PesquisaAlunoDAO;
import com.example.model.PesquisaAluno;

public class PesquisaAlunoController {
    private PesquisaAlunoDAO pesquisaAlunoDAO;

    public PesquisaAlunoController(){
        this.pesquisaAlunoDAO = new PesquisaAlunoDAO();
    }

    public void cadastrarPesquisaAluno(PesquisaAluno pesquisaAluno) {
        pesquisaAlunoDAO.inserirPlaneta(pesquisaAluno);
    }
}
