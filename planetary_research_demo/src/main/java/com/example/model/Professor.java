package com.example.model;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professor {
    private String nome;
    private String email;
    private String telefone;
    private String registroFaculdade;
    private String nomeFaculdade;
    private String formacao;
    private String idade;
    private String senha;
    private String linkedinGithub;
    private String areaDeEstudo;
    private List<String> alunos; // Lista de RAs dos alunos

    // Construtor
    public Professor(String nome, String email, String telefone, String registroFaculdade, String nomeFaculdade,
            String formacao, String idade, String senha, String linkedinGithub, String areaDeEstudo) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.registroFaculdade = registroFaculdade;
        this.nomeFaculdade = nomeFaculdade;
        this.formacao = formacao;
        this.idade = idade;
        this.senha = senha;
        this.linkedinGithub = linkedinGithub;
        this.areaDeEstudo = areaDeEstudo;
        this.alunos = new ArrayList<>();
    }

}
