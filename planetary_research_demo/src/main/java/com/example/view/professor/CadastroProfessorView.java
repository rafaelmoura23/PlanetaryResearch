package com.example.view.professor;

import javax.swing.*;
import com.example.dao.ProfessorDAO;
import com.example.model.Professor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CadastroProfessorView {
    private JFrame frame;
    private JTextField nomeField;
    private JTextField emailField;
    private JTextField telefoneField;
    private JTextField registroField;
    private JTextField nomeFaculdadeField;
    private JTextField formacaoField;
    private JTextField idadeField;
    private JPasswordField senhaField;
    private JTextField linkedinField;
    private JTextField areaEstudoField;
    private JTextField raField; // Novo campo para o RA do aluno
    private DefaultListModel<String> raListModel; // Modelo para a lista de RAs
    private JList<String> raList; // Lista de RAs

    public CadastroProfessorView() {
        frame = new JFrame("Cadastro de Professor");
        frame.setSize(400, 600);
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

        JLabel registroLabel = new JLabel("Registro da Faculdade:");
        registroLabel.setBounds(20, 140, 150, 25);
        registroField = new JTextField();
        registroField.setBounds(150, 140, 200, 25);

        JLabel nomeFaculdadeLabel = new JLabel("Nome da Faculdade:");
        nomeFaculdadeLabel.setBounds(20, 180, 150, 25);
        nomeFaculdadeField = new JTextField();
        nomeFaculdadeField.setBounds(150, 180, 200, 25);

        JLabel formacaoLabel = new JLabel("Formação:");
        formacaoLabel.setBounds(20, 220, 150, 25);
        formacaoField = new JTextField();
        formacaoField.setBounds(150, 220, 200, 25);

        JLabel idadeLabel = new JLabel("Idade:");
        idadeLabel.setBounds(20, 260, 150, 25);
        idadeField = new JTextField();
        idadeField.setBounds(150, 260, 200, 25);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(20, 300, 150, 25);
        senhaField = new JPasswordField();
        senhaField.setBounds(150, 300, 200, 25);

        JLabel linkedinLabel = new JLabel("LinkedIn ou GitHub:");
        linkedinLabel.setBounds(20, 340, 150, 25);
        linkedinField = new JTextField();
        linkedinField.setBounds(150, 340, 200, 25);

        JLabel areaEstudoLabel = new JLabel("Área de Estudo:");
        areaEstudoLabel.setBounds(20, 380, 150, 25);
        areaEstudoField = new JTextField();
        areaEstudoField.setBounds(150, 380, 200, 25);

        // Novo campo para adicionar RA dos alunos
        JLabel raLabel = new JLabel("RA do Aluno:");
        raLabel.setBounds(20, 420, 150, 25);
        raField = new JTextField();
        raField.setBounds(150, 420, 200, 25);

        JButton adicionarRAButton = new JButton("Adicionar RA");
        adicionarRAButton.setBounds(150, 450, 150, 30);

        // Lista para exibir os RAs adicionados
        raListModel = new DefaultListModel<>();
        raList = new JList<>(raListModel);
        JScrollPane raListScrollPane = new JScrollPane(raList);
        raListScrollPane.setBounds(150, 490, 200, 100);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(150, 600, 100, 30);

        // Adiciona componentes ao frame
        frame.add(nomeLabel);
        frame.add(nomeField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(telefoneLabel);
        frame.add(telefoneField);
        frame.add(registroLabel);
        frame.add(registroField);
        frame.add(nomeFaculdadeLabel);
        frame.add(nomeFaculdadeField);
        frame.add(formacaoLabel);
        frame.add(formacaoField);
        frame.add(idadeLabel);
        frame.add(idadeField);
        frame.add(senhaLabel);
        frame.add(senhaField);
        frame.add(linkedinLabel);
        frame.add(linkedinField);
        frame.add(areaEstudoLabel);
        frame.add(areaEstudoField);
        frame.add(raLabel);
        frame.add(raField);
        frame.add(adicionarRAButton);
        frame.add(raListScrollPane);
        frame.add(cadastrarButton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ação do botão para adicionar RA
        adicionarRAButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ra = raField.getText();
                if (!ra.isEmpty()) {
                    raListModel.addElement(ra); // Adiciona o RA à lista
                    raField.setText(""); // Limpa o campo RA após a adição
                } else {
                    JOptionPane.showMessageDialog(frame, "RA não pode estar vazio!");
                }
            }
        });

        // Ação do botão para cadastrar o professor
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtém os dados dos campos de texto
                String nome = nomeField.getText();
                String email = emailField.getText();
                String telefone = telefoneField.getText();
                String registroFaculdade = registroField.getText();
                String nomeFaculdade = nomeFaculdadeField.getText();
                String formacao = formacaoField.getText();
                String idade = idadeField.getText();

                String senha = new String(senhaField.getPassword());
                String linkedinOuGithub = linkedinField.getText();
                String areaEstudo = areaEstudoField.getText();
                String tipoUsuario = "professor";

                // Obtém a lista de RAs
                List<String> alunos = new ArrayList<>();
                for (int i = 0; i < raListModel.getSize(); i++) {
                    alunos.add(raListModel.getElementAt(i));
                }

                // Cria o novo professor
                Professor novoProfessor = new Professor(nome, email, telefone, registroFaculdade,
                        nomeFaculdade, formacao, idade, senha,
                        linkedinOuGithub, areaEstudo, alunos, tipoUsuario);

                // Cadastra o professor no DAO
                ProfessorDAO professorDAO = new ProfessorDAO();
                professorDAO.cadastrarProfessor(novoProfessor);
                JOptionPane.showMessageDialog(frame, "Professor cadastrado com sucesso!");
                frame.dispose(); // Fecha a janela após o cadastro
            }
        });
    }
}
