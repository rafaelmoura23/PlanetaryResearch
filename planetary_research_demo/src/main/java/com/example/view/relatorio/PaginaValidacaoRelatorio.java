package com.example.view.relatorio;

import com.example.dao.PesquisaAlunoDAO;
import com.example.model.PesquisaAluno;
import com.example.model.Professor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class PaginaValidacaoRelatorio extends JFrame {
    public PaginaValidacaoRelatorio(Professor professor) {
        setTitle("Sistema de Gerenciamento de Pesquisas");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Bem-vindo, Professor " + professor.getNome());
        welcomeLabel.setBounds(50, 20, 500, 30);
        add(welcomeLabel);

        // Instância do DAO
        PesquisaAlunoDAO pesquisaAlunoDAO = new PesquisaAlunoDAO();

        // Recuperar planetas dos alunos do professor
        List<PesquisaAluno> planetasDosAlunos = pesquisaAlunoDAO.listarPlanetasPorProfessor(professor);

        // Recuperar planetas reais (sem aluno)
        List<PesquisaAluno> planetasReais = pesquisaAlunoDAO.listarPlanetasSemAluno();

        // Arrays para os nomes dos planetas
        String[] nomesPlanetasDosAlunos = planetasDosAlunos.stream()
                .map(PesquisaAluno::getNomePlaneta)
                .toArray(String[]::new);

        String[] nomesPlanetasReais = planetasReais.stream()
                .map(PesquisaAluno::getNomePlaneta)
                .toArray(String[]::new);

        // ComboBox para planetas dos alunos do professor
        JLabel labelPlanetasAlunos = new JLabel("Selecione o Planeta do Aluno:");
        labelPlanetasAlunos.setBounds(50, 70, 200, 30);
        add(labelPlanetasAlunos);

        JComboBox<String> comboBoxPlanetasAlunos = new JComboBox<>(nomesPlanetasDosAlunos);
        comboBoxPlanetasAlunos.setBounds(250, 70, 500, 30);
        add(comboBoxPlanetasAlunos);

        // ComboBox para planetas reais
        JLabel labelPlanetasReais = new JLabel("Selecione o Planeta Real:");
        labelPlanetasReais.setBounds(50, 120, 200, 30);
        add(labelPlanetasReais);

        JComboBox<String> comboBoxPlanetasReais = new JComboBox<>(nomesPlanetasReais);
        comboBoxPlanetasReais.setBounds(250, 120, 500, 30);
        add(comboBoxPlanetasReais);

        // Botão para gerar relatório
        JButton gerarRelatorioButton = new JButton("Gerar Relatório");
        gerarRelatorioButton.setBounds(300, 200, 200, 40);
        add(gerarRelatorioButton);

        gerarRelatorioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificar se ambos os planetas foram selecionados
                if (comboBoxPlanetasAlunos.getSelectedIndex() != -1 && comboBoxPlanetasReais.getSelectedIndex() != -1) {
                    String nomePlanetaAluno = (String) comboBoxPlanetasAlunos.getSelectedItem();
                    String nomePlanetaReal = (String) comboBoxPlanetasReais.getSelectedItem();

                    // Obter os objetos PesquisaAluno correspondentes
                    PesquisaAluno planetaAluno = planetasDosAlunos.stream()
                            .filter(p -> p.getNomePlaneta().equals(nomePlanetaAluno))
                            .findFirst()
                            .orElse(null);

                    PesquisaAluno planetaReal = planetasReais.stream()
                            .filter(p -> p.getNomePlaneta().equals(nomePlanetaReal))
                            .findFirst()
                            .orElse(null);

                    if (planetaAluno != null && planetaReal != null) {
                        // Chamar o método para gerar o relatório
                        gerarRelatorioPDF(planetaAluno, planetaReal);
                        JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");
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

    private void gerarRelatorioPDF(PesquisaAluno planetaAluno, PesquisaAluno planetaReal) {
        // Implementação da lógica de comparação e geração do PDF
        // Lista de campos a serem comparados
        String[] campos = {
            "Distância da Terra",
            "Diâmetro",
            "Massa",
            "Temperatura Média",
            "Número de Luas",
            "Gravidade"
        };

        // Variáveis para armazenar os resultados da comparação
        double similaridadeTotal = 0;
        int totalCamposComparados = campos.length;

        // StringBuilder para montar o conteúdo do relatório
        StringBuilder conteudoRelatorio = new StringBuilder();
        conteudoRelatorio.append("Relatório de Comparação de Planetas\n\n");
        conteudoRelatorio.append("Planeta do Aluno: ").append(planetaAluno.getNomePlaneta()).append("\n");
        conteudoRelatorio.append("Planeta Real: ").append(planetaReal.getNomePlaneta()).append("\n\n");

        // Comparação dos campos numéricos
        // Distância da Terra
        double distanciaAluno = planetaAluno.getDistanciaDaTerra();
        double distanciaReal = planetaReal.getDistanciaDaTerra();
        double similaridadeDistancia = calcularSimilaridade(distanciaAluno, distanciaReal);
        similaridadeTotal += similaridadeDistancia;
        conteudoRelatorio.append("Distância da Terra:\n");
        conteudoRelatorio.append(" - Aluno: ").append(distanciaAluno).append(" anos-luz\n");
        conteudoRelatorio.append(" - Real: ").append(distanciaReal).append(" anos-luz\n");
        conteudoRelatorio.append(" - Similaridade: ").append(String.format("%.2f", similaridadeDistancia * 100)).append("%\n\n");

        // Diâmetro
        double diametroAluno = planetaAluno.getDiametro();
        double diametroReal = planetaReal.getDiametro();
        double similaridadeDiametro = calcularSimilaridade(diametroAluno, diametroReal);
        similaridadeTotal += similaridadeDiametro;
        conteudoRelatorio.append("Diâmetro:\n");
        conteudoRelatorio.append(" - Aluno: ").append(diametroAluno).append("\n");
        conteudoRelatorio.append(" - Real: ").append(diametroReal).append("\n");
        conteudoRelatorio.append(" - Similaridade: ").append(String.format("%.2f", similaridadeDiametro * 100)).append("%\n\n");

        // Massa
        double massaAluno = planetaAluno.getMassa();
        double massaReal = planetaReal.getMassa();
        double similaridadeMassa = calcularSimilaridade(massaAluno, massaReal);
        similaridadeTotal += similaridadeMassa;
        conteudoRelatorio.append("Massa:\n");
        conteudoRelatorio.append(" - Aluno: ").append(massaAluno).append("\n");
        conteudoRelatorio.append(" - Real: ").append(massaReal).append("\n");
        conteudoRelatorio.append(" - Similaridade: ").append(String.format("%.2f", similaridadeMassa * 100)).append("%\n\n");

        // Temperatura Média
        double tempAluno = planetaAluno.getTemperaturaMedia();
        double tempReal = planetaReal.getTemperaturaMedia();
        double similaridadeTemperatura = calcularSimilaridade(tempAluno, tempReal);
        similaridadeTotal += similaridadeTemperatura;
        conteudoRelatorio.append("Temperatura Média:\n");
        conteudoRelatorio.append(" - Aluno: ").append(tempAluno).append(" °C\n");
        conteudoRelatorio.append(" - Real: ").append(tempReal).append(" °C\n");
        conteudoRelatorio.append(" - Similaridade: ").append(String.format("%.2f", similaridadeTemperatura * 100)).append("%\n\n");

        // Número de Luas
        int luasAluno = planetaAluno.getNumeroDeLuas();
        int luasReal = planetaReal.getNumeroDeLuas();
        double similaridadeLuas = calcularSimilaridade(luasAluno, luasReal);
        similaridadeTotal += similaridadeLuas;
        conteudoRelatorio.append("Número de Luas:\n");
        conteudoRelatorio.append(" - Aluno: ").append(luasAluno).append("\n");
        conteudoRelatorio.append(" - Real: ").append(luasReal).append("\n");
        conteudoRelatorio.append(" - Similaridade: ").append(String.format("%.2f", similaridadeLuas * 100)).append("%\n\n");

        // Gravidade
        double gravidadeAluno = Double.parseDouble(planetaAluno.getGravidade());
        double gravidadeReal = Double.parseDouble(planetaReal.getGravidade());
        double similaridadeGravidade = calcularSimilaridade(gravidadeAluno, gravidadeReal);
        similaridadeTotal += similaridadeGravidade;
        conteudoRelatorio.append("Gravidade:\n");
        conteudoRelatorio.append(" - Aluno: ").append(gravidadeAluno).append("\n");
        conteudoRelatorio.append(" - Real: ").append(gravidadeReal).append("\n");
        conteudoRelatorio.append(" - Similaridade: ").append(String.format("%.2f", similaridadeGravidade * 100)).append("%\n\n");

        // Calcular a média de similaridade
        double mediaSimilaridade = (similaridadeTotal / totalCamposComparados) * 100;
        conteudoRelatorio.append("Nível de Proximidade Geral: ").append(String.format("%.2f", mediaSimilaridade)).append("%\n");

        // Chamar o método para gerar o PDF com o conteúdo
        gerarPDF(conteudoRelatorio.toString());
    }

    private double calcularSimilaridade(double valorAluno, double valorReal) {
        // Evitar divisão por zero
        if (valorReal == 0) {
            return valorAluno == 0 ? 1.0 : 0.0;
        }
        double menorValor = Math.min(valorAluno, valorReal);
        double maiorValor = Math.max(valorAluno, valorReal);
        return menorValor / maiorValor;
    }

    private double calcularSimilaridade(int valorAluno, int valorReal) {
        // Converter para double e chamar o método acima
        return calcularSimilaridade((double) valorAluno, (double) valorReal);
    }

    private void gerarPDF(String conteudo) {
        // Nome do arquivo PDF
        String nomeArquivo = "RelatorioComparacaoPlanetas.pdf";

        // Criar o documento
        Document document = new Document();

        try {
            // Criar o writer que escreve no arquivo
            PdfWriter.getInstance(document, new FileOutputStream(nomeArquivo));

            // Abrir o documento
            document.open();

            // Adicionar o conteúdo
            document.add(new Paragraph(conteudo));

            // Fechar o documento
            document.close();

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
