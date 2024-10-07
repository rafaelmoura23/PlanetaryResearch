package com.example.controller;

import com.example.dao.AlunoDAO;
import com.example.model.Aluno;

import javax.swing.JOptionPane;

public class AlunoController {

    private AlunoDAO alunoDAO;

    public AlunoController() {
        this.alunoDAO = new AlunoDAO();
    }

    public void cadastrarAlunoController(Aluno aluno) {
        try {
            validarAluno(aluno);
            alunoDAO.cadastrarAluno(aluno);
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de Validação", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método para validar os dados do aluno
    private void validarAluno(Aluno aluno) {
        if (aluno.getNome() == null || aluno.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O campo nome não pode estar vazio.");
        }

        if (aluno.getEmail() == null || aluno.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("O campo do email está vazio.");
        }

        if (aluno.getSenha() == null || aluno.getSenha().length() < 6) {
            throw new IllegalArgumentException("O campo senha não pode estar vazio e deve ter pelo menos 6 dígitos.");
        }

        if (aluno.getRa() == null || aluno.getRa().trim().isEmpty()) {
            throw new IllegalArgumentException("O campo RA não pode estar vazio.");
        }

        if (aluno.getTelefone() == null || aluno.getTelefone().trim().isEmpty()) {
            throw new IllegalArgumentException("O número de telefone é inválido.");
        }

        if (aluno.getCurso() == null || aluno.getCurso().trim().isEmpty()) {
            throw new IllegalArgumentException("O campo curso não pode estar vazio.");
        }

        if (aluno.getNomeFaculdade() == null || aluno.getNomeFaculdade().trim().isEmpty()) {
            throw new IllegalArgumentException("O campo nome da faculdade não pode estar vazio.");
        }

        if (aluno.getAreaDePesquisa() == null || aluno.getAreaDePesquisa().trim().isEmpty()) {
            throw new IllegalArgumentException("O campo área de pesquisa não pode estar vazio.");
        }

        if (aluno.getOrientador() == null || aluno.getOrientador().trim().isEmpty()) {
            throw new IllegalArgumentException("O campo orientador não pode estar vazio.");
        }

        if (aluno.getTipoUsuario() == null || aluno.getTipoUsuario().trim().isEmpty()) {
            throw new IllegalArgumentException("O campo tipo de usuário não pode estar vazio.");
        }

        if (aluno.getLinkedinGithub() == null || aluno.getLinkedinGithub().trim().isEmpty()) {
            throw new IllegalArgumentException("O campo LinkedIn/GitHub não pode estar vazio.");
        }
    }
}
