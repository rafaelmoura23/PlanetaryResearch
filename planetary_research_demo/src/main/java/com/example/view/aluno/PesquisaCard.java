package com.example.view.aluno;

import javax.swing.*;
import java.awt.*;

public class PesquisaCard extends JPanel {
    public PesquisaCard(String nomePlaneta, String distanciaDaTerra, String foto) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        setPreferredSize(new Dimension(250, 200));

        JLabel nomeLabel = new JLabel("Nome: " + nomePlaneta);
        JLabel distanciaLabel = new JLabel("Distância: " + distanciaDaTerra);
        JLabel fotoLabel = new JLabel();

        // Carregar a imagem da foto, se houver
        if (foto != null && !foto.isEmpty()) {
            ImageIcon icon = new ImageIcon(foto); // Supondo que a foto é um caminho para a imagem
            JLabel imgLabel = new JLabel(icon);
            fotoLabel = imgLabel;
        }

        add(nomeLabel, BorderLayout.NORTH);
        add(distanciaLabel, BorderLayout.CENTER);
        add(fotoLabel, BorderLayout.SOUTH);
    }
}
