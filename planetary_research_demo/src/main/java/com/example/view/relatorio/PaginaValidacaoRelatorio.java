package com.example.view.relatorio;

import com.example.controller.RelatorioController;
import com.example.dao.PesquisaAlunoDAO;
import com.example.model.PesquisaAluno;
import com.example.model.Professor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PaginaValidacaoRelatorio extends JFrame {

    public PaginaValidacaoRelatorio(Professor professor) {
        setTitle("Sistema de Gerenciamento de Pesquisas");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setLocation((screenWidth - this.getWidth()) / 2, (screenHeight - this.getHeight()) / 2);

        JLabel welcomeLabel = new JLabel("Bem-vindo, Professor " + professor.getNome());
        welcomeLabel.setBounds(50, 20, 500, 30);
        add(welcomeLabel);

        PesquisaAlunoDAO pesquisaAlunoDAO = new PesquisaAlunoDAO();

        List<PesquisaAluno> planetasDosAlunos = pesquisaAlunoDAO.listarPlanetasPorProfessor(professor);
        List<PesquisaAluno> planetasReais = pesquisaAlunoDAO.listarPlanetasSemAluno();

        String[] nomesPlanetasDosAlunos = planetasDosAlunos.stream()
                .map(PesquisaAluno::getNomePlaneta)
                .toArray(String[]::new);

        String[] nomesPlanetasReais = planetasReais.stream()
                .map(PesquisaAluno::getNomePlaneta)
                .toArray(String[]::new);

        JLabel labelPlanetasAlunos = new JLabel("Selecione o Planeta do Aluno:");
        labelPlanetasAlunos.setBounds(50, 70, 200, 30);
        add(labelPlanetasAlunos);

        JComboBox<String> comboBoxPlanetasAlunos = new JComboBox<>(nomesPlanetasDosAlunos);
        comboBoxPlanetasAlunos.setBounds(250, 70, 500, 30);
        add(comboBoxPlanetasAlunos);

        JLabel labelPlanetasReais = new JLabel("Selecione o Planeta Real:");
        labelPlanetasReais.setBounds(50, 120, 200, 30);
        add(labelPlanetasReais);

        JComboBox<String> comboBoxPlanetasReais = new JComboBox<>(nomesPlanetasReais);
        comboBoxPlanetasReais.setBounds(250, 120, 500, 30);
        add(comboBoxPlanetasReais);

        JButton gerarRelatorioButton = new JButton("Gerar Relatório");
        gerarRelatorioButton.setBounds(300, 200, 200, 40);
        add(gerarRelatorioButton);

        gerarRelatorioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxPlanetasAlunos.getSelectedIndex() != -1 && comboBoxPlanetasReais.getSelectedIndex() != -1) {
                    String nomePlanetaAluno = (String) comboBoxPlanetasAlunos.getSelectedItem();
                    String nomePlanetaReal = (String) comboBoxPlanetasReais.getSelectedItem();

                    PesquisaAluno planetaAluno = planetasDosAlunos.stream()
                            .filter(p -> p.getNomePlaneta().equals(nomePlanetaAluno))
                            .findFirst()
                            .orElse(null);

                    PesquisaAluno planetaReal = planetasReais.stream()
                            .filter(p -> p.getNomePlaneta().equals(nomePlanetaReal))
                            .findFirst()
                            .orElse(null);

                    if (planetaAluno != null && planetaReal != null) {
                        RelatorioController controller = new RelatorioController();
                        String conteudoRelatorio = controller.gerarRelatorio(planetaAluno, planetaReal);
                        String nomeArquivoOutput = "Relatorio_" + planetaAluno.getNomePlaneta() + ".txt";
                        controller.gerarArquivoTxt(conteudoRelatorio, nomeArquivoOutput);
                        JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso! Confira o arquivo Relatorio_" + nomeArquivoOutput + ".txt");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao obter os dados dos planetas selecionados.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um planeta do aluno e um planeta real.");
                }
            }
        });

        setVisible(true);
    }
}
