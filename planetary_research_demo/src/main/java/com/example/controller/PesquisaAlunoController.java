package com.example.controller;

import com.example.dao.PesquisaAlunoDAO;
import com.example.model.PesquisaAluno;
import com.mongodb.MongoWriteException;

public class PesquisaAlunoController {
    private PesquisaAlunoDAO pesquisaAlunoDAO;

    public PesquisaAlunoController() {
        this.pesquisaAlunoDAO = new PesquisaAlunoDAO();
    }

    public void cadastrarPesquisaAluno(PesquisaAluno pesquisaAluno) {
        // Validações
        if (pesquisaAluno == null) {
            throw new IllegalArgumentException("A pesquisa do aluno não pode ser nula.");
        }
        if (pesquisaAluno.getNomePlaneta() == null || pesquisaAluno.getNomePlaneta().isEmpty()) {
            throw new IllegalArgumentException("O nome do planeta não pode ser vazio.");
        }
        if (pesquisaAluno.getIdAluno() == null || pesquisaAluno.getIdAluno().isEmpty()) {
            throw new IllegalArgumentException("O ID do aluno não pode ser vazio.");
        }
        try {
            pesquisaAlunoDAO.inserirPlaneta(pesquisaAluno);
        } catch (MongoWriteException e) {
            if (e.getError().getCode() == 11000) { // Código para duplicidade
                throw new RuntimeException("Erro: Já existe um planeta com esse nome.");
            } else {
                throw new RuntimeException("Erro ao cadastrar a pesquisa do aluno: " + e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro inesperado ao cadastrar a pesquisa do aluno: " + e.getMessage(), e);
        }
    }

    // Método para atualizar uma pesquisa
    public void atualizarPesquisa(PesquisaAluno pesquisa) throws Exception {
        // Validar o ID da pesquisa
        if (pesquisa.getId() == null || pesquisa.getId().isEmpty()) {
            throw new Exception("Erro: O ID está nulo ou vazio.");
        }
        pesquisaAlunoDAO.atualizarPesquisaPorIdPlaneta(pesquisa.getId(), pesquisa);
    }

    // Método para deletar uma pesquisa
    public void deletarPesquisa(PesquisaAluno pesquisa) throws Exception {
        // Validar o nome do planeta
        if (pesquisa.getNomePlaneta() == null || pesquisa.getNomePlaneta().isEmpty()) {
            throw new Exception("Erro: O nome do planeta está vazio.");
        }

        pesquisaAlunoDAO.deletarPesquisaPorNomePlaneta(pesquisa.getNomePlaneta());
    }
}
