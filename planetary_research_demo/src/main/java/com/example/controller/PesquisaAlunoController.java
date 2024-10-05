package com.example.controller;



import com.example.dao.PesquisaAlunoDAO;
import com.example.model.PesquisaAluno;


public class PesquisaAlunoController {
    private PesquisaAlunoDAO pesquisaAlunoDAO;

    public PesquisaAlunoController() {
        this.pesquisaAlunoDAO = new PesquisaAlunoDAO();
    }

    public void cadastrarPesquisaAluno(PesquisaAluno pesquisaAluno) {
            pesquisaAlunoDAO.inserirPlaneta(pesquisaAluno);
    }

    // Método para atualizar uma pesquisa
    public void atualizarPesquisaAluno(String nomePlaneta, PesquisaAluno pesquisaAtualizada) {
        pesquisaAlunoDAO.atualizarPesquisaPorIdPlaneta(nomePlaneta, pesquisaAtualizada);
    }

    // Método para deletar uma pesquisa
    public void deletarPesquisaAluno(String nomePlaneta) {
        pesquisaAlunoDAO.deletarPesquisaPorNomePlaneta(nomePlaneta);
    }
}
