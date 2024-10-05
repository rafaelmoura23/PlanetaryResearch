package com.example.view.professor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.example.model.Professor;
import com.example.view.pesquisa.PaginaCadastroPesquisaAluno;
import com.example.view.relatorio.PaginaValidacaoRelatorio;

public class PaginaInternaProfessor extends JFrame {
    public PaginaInternaProfessor(Professor professor) {
        setTitle("Sistema de Gerenciamento de Pesquisas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        JLabel welcomeLabel = new JLabel("Bem-vindo, Professor " + professor.getNome() + "\n Tipo de Usuário: " + professor.getTipoUsuario());
        welcomeLabel.setBounds(50, 50, 300, 30);
        add(welcomeLabel);

        JButton planetButton = new JButton("Cadastro de Planetas");
        JButton relatorioButton = new JButton("Gerar Relatório");

        planetButton.setBounds(100, 150, 200, 40);
        relatorioButton.setBounds(100, 200, 200, 40);

        add(planetButton);
        add(relatorioButton);

       // botao para ir para cadastro de planetas
       planetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 new PaginaCadastroPesquisaAluno(null, professor);
            }
        });

       // botao para gerar comparação/relatório se é planeta ou não
       // MÉTODO PARA GERAR UMA COMPARAÇÃO E GERAR O RELATÓRIO COM AS INFORMAÇÕES
       relatorioButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            new PaginaValidacaoRelatorio(professor);
        }
       });

        setVisible(true);
    }
}
