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
}
