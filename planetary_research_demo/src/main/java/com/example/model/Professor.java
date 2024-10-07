package com.example.model;

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
    private String tipoUsuario;
}