package com.example.view;

import javax.swing.*;

import com.example.view.aluno.CadastroAlunoView;
import com.example.view.professor.CadastroProfessorView;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro e Login de Professores e Alunos");
        JButton professorButton = new JButton("Cadastro Professor");
        JButton alunoButton = new JButton("Cadastro Aluno");
        JButton loginButton = new JButton("Login");

        professorButton.setBounds(100, 100, 200, 40);
        alunoButton.setBounds(100, 150, 200, 40);
        loginButton.setBounds(100, 200, 200, 40);

        frame.add(professorButton);
        frame.add(alunoButton);
        frame.add(loginButton);

        frame.setSize(400, 400);
        frame.setLayout(null);
        
        // método para centralizar a tela independente do tamanho do monitor
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        frame.setLocation((screenWidth - frame.getWidth()) / 2, (screenHeight - frame.getHeight()) / 2);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        professorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastroProfessorView();
            }
        });

        alunoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastroAlunoView();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginView();
            }
        });
    }
}
