package com.example.controller;

import com.example.dao.ProfessorDAO;
import com.example.model.Professor;

import javax.swing.JOptionPane;
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

        if (professor.getEmail() == null) {
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

        if (professor.getIdade() == null ) {
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
}
