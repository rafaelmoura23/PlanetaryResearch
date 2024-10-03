package com.example.view.aluno;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.example.model.Aluno;

public class PaginaInternaAluno extends JFrame{
    public PaginaInternaAluno(Aluno aluno) {
        setTitle("Página Interna do Aluno");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Bem-vindo, Professor " + aluno.getNome());
        welcomeLabel.setBounds(50, 50, 300, 30);
        add(welcomeLabel);

        // Botao para ir para cadastro de pesquisa


        setVisible(true);
    }
}
