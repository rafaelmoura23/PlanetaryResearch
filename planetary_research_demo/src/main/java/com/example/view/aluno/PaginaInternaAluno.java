package com.example.view.aluno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.example.model.Aluno;
import com.example.view.pesquisa.PaginaCadastroPesquisaAluno;

public class PaginaInternaAluno extends JFrame{
    public PaginaInternaAluno(Aluno aluno) {
        setTitle("Página Interna do Aluno");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Bem-vindo, Aluno " + aluno.getNome());
        welcomeLabel.setBounds(50, 50, 300, 30);
        add(welcomeLabel);

         JButton planetButton = new JButton("Cadastro de Planetas");

         planetButton.setBounds(100, 150, 200, 40);

         add(planetButton);

        // Botao para ir para cadastro de pesquisa
         planetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PaginaCadastroPesquisaAluno(aluno);
            }
        });


        setVisible(true);
    }
}
