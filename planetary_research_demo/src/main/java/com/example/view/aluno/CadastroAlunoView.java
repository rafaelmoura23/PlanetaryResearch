package com.example.view.aluno;

import javax.swing.*;

import com.example.dao.AlunoDAO;
import com.example.model.Aluno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroAlunoView {
    private JFrame frame;
    private JTextField nomeField;
    private JTextField emailField;
    private JTextField telefoneField;
    private JTextField raField;
    private JTextField nomeFaculdadeField;
    private JTextField senhaField;
    private JTextField cursoField;
    private JTextField orientadorField;
    private JTextField linkedinField;
    private JTextField areaPesquisaField;

    public CadastroAlunoView() {
        frame = new JFrame("Cadastro de Aluno");
        frame.setSize(400, 500);
        frame.setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(20, 20, 150, 25);
        nomeField = new JTextField();
        nomeField.setBounds(150, 20, 200, 25);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 60, 150, 25);
        emailField = new JTextField();
        emailField.setBounds(150, 60, 200, 25);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(20, 100, 150, 25);
        telefoneField = new JTextField();
        telefoneField.setBounds(150, 100, 200, 25);

        JLabel raLabel = new JLabel("RA:");
        raLabel.setBounds(20, 140, 150, 25);
        raField = new JTextField();
        raField.setBounds(150, 140, 200, 25);

        JLabel nomeFaculdadeLabel = new JLabel("Nome da Faculdade:");
        nomeFaculdadeLabel.setBounds(20, 180, 150, 25);
        nomeFaculdadeField = new JTextField();
        nomeFaculdadeField.setBounds(150, 180, 200, 25);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(20, 220, 150, 25);
        senhaField = new JTextField();
        senhaField.setBounds(150, 220, 200, 25);

        JLabel cursoLabel = new JLabel("Curso:");
        cursoLabel.setBounds(20, 260, 150, 25);
        cursoField = new JTextField();
        cursoField.setBounds(150, 260, 200, 25);

        JLabel orientadorLabel = new JLabel("Orientador:");
        orientadorLabel.setBounds(20, 300, 150, 25);
        orientadorField = new JTextField();
        orientadorField.setBounds(150, 300, 200, 25);

        JLabel linkedinLabel = new JLabel("LinkedIn ou GitHub:");
        linkedinLabel.setBounds(20, 340, 150, 25);
        linkedinField = new JTextField();
        linkedinField.setBounds(150, 340, 200, 25);

        JLabel areaPesquisaLabel = new JLabel("Área de Pesquisa:");
        areaPesquisaLabel.setBounds(20, 380, 150, 25);
        areaPesquisaField = new JTextField();
        areaPesquisaField.setBounds(150, 380, 200, 25);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(150, 420, 100, 30);

        frame.add(nomeLabel);
        frame.add(nomeField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(telefoneLabel);
        frame.add(telefoneField);
        frame.add(raLabel);
        frame.add(raField);
        frame.add(nomeFaculdadeLabel);
        frame.add(nomeFaculdadeField);
        frame.add(senhaLabel);
        frame.add(senhaField);
        frame.add(cursoLabel);
        frame.add(cursoField);
        frame.add(orientadorLabel);
        frame.add(orientadorField);
        frame.add(linkedinLabel);
        frame.add(linkedinField);
        frame.add(areaPesquisaLabel);
        frame.add(areaPesquisaField);
        frame.add(cadastrarButton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String email = emailField.getText();
                String telefone = telefoneField.getText();
                String ra = raField.getText();
                String nomeFaculdade = nomeFaculdadeField.getText();
                String senha = senhaField.getText();
                String curso = cursoField.getText();
                String orientador = orientadorField.getText();
                String linkedinGithub = linkedinField.getText();
                String areaPesquisa = areaPesquisaField.getText();


                AlunoDAO alunoDAO = new AlunoDAO();
                alunoDAO.cadastrarAluno(new Aluno(nome, email, telefone, ra, nomeFaculdade, senha, curso, orientador, linkedinGithub, areaPesquisa));
                JOptionPane.showMessageDialog(frame, "Aluno cadastrado com sucesso!");
                frame.dispose(); // Fecha a janela após o cadastro
            }
        });
    }
}

