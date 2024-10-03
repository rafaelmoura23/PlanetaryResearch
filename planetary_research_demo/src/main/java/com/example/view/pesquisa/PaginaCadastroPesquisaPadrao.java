package com.example.view.pesquisa;

import javax.swing.JFrame;
import javax.swing.JLabel;
import com.example.model.Professor;

public class PaginaCadastroPesquisaPadrao extends JFrame{
    public PaginaCadastroPesquisaPadrao(Professor professor) {
        setTitle("Sistema de Gerenciamento de Pesquisas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Bem-vindo, Professor " + professor.getNome());
        welcomeLabel.setBounds(50, 50, 300, 30);
        add(welcomeLabel);

        setVisible(true);
    }
}
