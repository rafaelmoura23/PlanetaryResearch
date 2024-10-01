package com.example.controller;

import com.example.dao.ProfessorDAO;
import com.example.model.Professor;

public class ProfessorController {

    private ProfessorDAO professorDAO;

    public ProfessorController() {
        this.professorDAO = new ProfessorDAO();
    }

    public void cadastrarProfessor(Professor professor) {
        professorDAO.cadastrarProfessor(professor);
    }
}
