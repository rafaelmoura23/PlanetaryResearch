package com.example.view;

import javax.swing.*;

import com.example.controller.LoginController;
import com.example.model.Aluno;
import com.example.model.Professor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField emailField;
    private JPasswordField senhaField;
    private JButton loginProfessorButton, loginAlunoButton;

    public LoginView() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 50, 100, 30);
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(150, 50, 200, 30);
        add(emailField);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(50, 100, 100, 30);
        add(senhaLabel);
        senhaField = new JPasswordField();
        senhaField.setBounds(150, 100, 200, 30);
        add(senhaField);

        loginProfessorButton = new JButton("Login Professor");
        loginProfessorButton.setBounds(50, 150, 150, 40);
        add(loginProfessorButton);

        loginAlunoButton = new JButton("Login Aluno");
        loginAlunoButton.setBounds(210, 150, 150, 40);
        add(loginAlunoButton);

        loginProfessorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController controller = new LoginController();
                Professor professor = controller.loginProfessor(emailField.getText(), new String(senhaField.getPassword()));

                if (professor != null) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido! Bem-vindo Professor " + professor.getNome());
                    // Redirecionar para a tela de professor
                } else {
                    JOptionPane.showMessageDialog(null, "Email ou senha incorretos!");
                }
            }
        });

        loginAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController controller = new LoginController();
                Aluno aluno = controller.loginAluno(emailField.getText(), new String(senhaField.getPassword()));

                if (aluno != null) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido! Bem-vindo Aluno " + aluno.getNome());
                    // Redirecionar para a tela de aluno
                } else {
                    JOptionPane.showMessageDialog(null, "Email ou senha incorretos!");
                }
            }
        });

        setVisible(true);
    }
}
