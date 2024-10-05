package com.example.view.aluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.example.dao.PesquisaAlunoDAO;
import com.example.model.Aluno;
import com.example.model.PesquisaAluno;
import com.example.view.pesquisa.PaginaCadastroPesquisaAluno;

public class PaginaInternaAluno extends JFrame {
    private Aluno aluno;

    public PaginaInternaAluno(Aluno aluno) {
        this.aluno = aluno; 
        setTitle("Página Interna do Aluno");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Bem-vindo, Aluno " + aluno.getNome() + " Tipo de Usuário: " + aluno.getTipoUsuario());
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.NORTH);

        JButton planetButton = new JButton("Cadastro de Planetas");
        add(planetButton, BorderLayout.SOUTH);

        // Botão para ir para cadastro de pesquisa
        planetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PaginaCadastroPesquisaAluno(aluno, null);
            }
        });

        // Adicionar painel para as pesquisas
        JPanel pesquisaPanel = new JPanel();
        pesquisaPanel.setLayout(new FlowLayout()); // Usar FlowLayout para dispor os cards
        add(pesquisaPanel, BorderLayout.CENTER);

        carregarPesquisas(aluno.getRa(), pesquisaPanel);

        setVisible(true);
    }

    private void carregarPesquisas(String ra, JPanel pesquisaPanel) {
        PesquisaAlunoDAO pesquisaAlunoDAO = new PesquisaAlunoDAO();
        List<PesquisaAluno> pesquisas = pesquisaAlunoDAO.buscarPesquisasPorRA(ra);

        for (PesquisaAluno pesquisa : pesquisas) {
            PesquisaCard card = new PesquisaCard(pesquisa, aluno);
            pesquisaPanel.add(card);
        }

        revalidate();
        repaint();
    }
}
