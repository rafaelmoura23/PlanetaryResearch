package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PesquisaAluno {
    private String id;
    private String nomePlaneta; // Nome do Planeta
    private double distanciaDaTerra; // Distância da Terra (Anos luz)
    private String foto; // Foto (String)
    private double diametro; // Diâmetro (double)
    private double massa; // Massa (double)
    private String composicaoAtmosferica; // Composição Atmosférica (Gases presentes na atmosfera)
    private double temperaturaMedia; // Temperatura Média (double)
    private int numeroDeLuas; // Número de Luas (int)
    private String periodoOrbital; // Período Orbital (String)
    private String tipoDeSuperficie; // Tipo de Superficie (String)
    private String atividadeGeologica; // Atividade Geológica (String)
    private String possibilidadeDeAgua; // Possibilidade de Água (String)
    private String campoMagnetico; // Campo Magnético (String)
    private String radiacao; // Radiação (String)
    private String gravidade; // Gravidade (String)
    private String caracteristicasEspeciais;
    private String tipo; // aluno ou professor
    private String idAluno;

    public PesquisaAluno(String nomePlaneta, double distanciaDaTerra, String foto, double diametro,
            double massa, String composicaoAtmosferica, double temperaturaMedia, int numeroDeLuas,
            String periodoOrbital, String tipoDeSuperficie, String atividadeGeologica,
            String possibilidadeDeAgua, String campoMagnetico, String radiacao, String gravidade,
            String caracteristicasEspeciais, String tipo, String idAluno) {
        this.nomePlaneta = nomePlaneta;
        this.distanciaDaTerra = distanciaDaTerra;
        this.foto = foto;
        this.diametro = diametro;
        this.massa = massa;
        this.composicaoAtmosferica = composicaoAtmosferica;
        this.temperaturaMedia = temperaturaMedia;
        this.numeroDeLuas = numeroDeLuas;
        this.periodoOrbital = periodoOrbital;
        this.tipoDeSuperficie = tipoDeSuperficie;
        this.atividadeGeologica = atividadeGeologica;
        this.possibilidadeDeAgua = possibilidadeDeAgua;
        this.campoMagnetico = campoMagnetico;
        this.radiacao = radiacao;
        this.gravidade = gravidade;
        this.caracteristicasEspeciais = caracteristicasEspeciais;
        this.tipo = tipo;
        this.idAluno = idAluno;
    }

    

}
