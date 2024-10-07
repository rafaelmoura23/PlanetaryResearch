package com.example.controller;


import com.example.model.PesquisaAluno;
import java.io.FileWriter;
import java.io.IOException;

public class RelatorioController {

    public double calcularSimilaridade(double valorAluno, double valorReal) {
        if (valorReal == 0) {
            return valorAluno == 0 ? 1.0 : 0.0;
        }
        double menorValor = Math.min(valorAluno, valorReal);
        double maiorValor = Math.max(valorAluno, valorReal);
        return menorValor / maiorValor;
    }

    public double calcularSimilaridade(int valorAluno, int valorReal) {
        return calcularSimilaridade((double) valorAluno, (double) valorReal);
    }

    public String gerarRelatorio(PesquisaAluno planetaAluno, PesquisaAluno planetaReal) {
        double similaridadeTotal = 0;
        int totalCamposComparados = 6;
        StringBuilder conteudoRelatorio = new StringBuilder();

        conteudoRelatorio.append("Relatório de Comparação de Planetas\n\n");
        conteudoRelatorio.append("Planeta do Aluno: ").append(planetaAluno.getNomePlaneta()).append("\n");
        conteudoRelatorio.append("Planeta Real: ").append(planetaReal.getNomePlaneta()).append("\n\n");

        // Comparar campos
        similaridadeTotal += adicionarCampoRelatorio(conteudoRelatorio, "Distância da Terra", 
                planetaAluno.getDistanciaDaTerra(), planetaReal.getDistanciaDaTerra());

        similaridadeTotal += adicionarCampoRelatorio(conteudoRelatorio, "Diâmetro", 
                planetaAluno.getDiametro(), planetaReal.getDiametro());

        similaridadeTotal += adicionarCampoRelatorio(conteudoRelatorio, "Massa", 
                planetaAluno.getMassa(), planetaReal.getMassa());

        similaridadeTotal += adicionarCampoRelatorio(conteudoRelatorio, "Temperatura Média", 
                planetaAluno.getTemperaturaMedia(), planetaReal.getTemperaturaMedia());

        similaridadeTotal += adicionarCampoRelatorio(conteudoRelatorio, "Número de Luas", 
                planetaAluno.getNumeroDeLuas(), planetaReal.getNumeroDeLuas());

        similaridadeTotal += adicionarCampoRelatorio(conteudoRelatorio, "Gravidade", 
                Double.parseDouble(planetaAluno.getGravidade()), Double.parseDouble(planetaReal.getGravidade()));

        // média de similaridade
        double mediaSimilaridade = (similaridadeTotal / totalCamposComparados) * 100;
        conteudoRelatorio.append("\nNível de Proximidade Geral: ").append(String.format("%.2f", mediaSimilaridade)).append("%\n");

        //feedback ao final do relatório
        String feedback = gerarFeedback(mediaSimilaridade);
        conteudoRelatorio.append("\nFeedback: ").append(feedback).append("\n");

        return conteudoRelatorio.toString();
    }

    private double adicionarCampoRelatorio(StringBuilder conteudoRelatorio, String nomeCampo, 
                                           double valorAluno, double valorReal) {
        double similaridade = calcularSimilaridade(valorAluno, valorReal);
        conteudoRelatorio.append(nomeCampo).append(":\n");
        conteudoRelatorio.append(" - Aluno: ").append(valorAluno).append("\n");
        conteudoRelatorio.append(" - Real: ").append(valorReal).append("\n");
        conteudoRelatorio.append(" - Similaridade: ").append(String.format("%.2f", similaridade * 100)).append("%\n\n");
        return similaridade;
    }

    private String gerarFeedback(double mediaSimilaridade) {
        if (mediaSimilaridade > 90) {
            return "O planeta do aluno é muito próximo de um planeta real.";
        } else if (mediaSimilaridade > 70) {
            return "O planeta do aluno tem várias características semelhantes a um planeta real.";
        } else {
            return "O planeta do aluno possui diferenças significativas em relação a um planeta real.";
        }
    }

    public void gerarArquivoTxt(String conteudo, String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write(conteudo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
