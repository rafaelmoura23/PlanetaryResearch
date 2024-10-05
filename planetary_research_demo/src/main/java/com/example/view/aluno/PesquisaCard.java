package com.example.view.aluno;

import javax.swing.*;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.dao.PesquisaAlunoDAO;
import com.example.model.Aluno;
import com.example.model.PesquisaAluno;

public class PesquisaCard extends JPanel {
    public PesquisaCard(PesquisaAluno pesquisa, Aluno aluno) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        setPreferredSize(new Dimension(250, 250));

        JLabel nomeLabel = new JLabel("Nome: " + pesquisa.getNomePlaneta());
        JLabel distanciaLabel = new JLabel("Distância: " + pesquisa.getDistanciaDaTerra());
        JLabel fotoLabel = new JLabel();

        // Carregar a imagem da foto, se houver
        if (pesquisa.getFoto() != null && !pesquisa.getFoto().isEmpty()) {
            ImageIcon icon = new ImageIcon(pesquisa.getFoto()); // Supondo que a foto é um caminho para a imagem
            fotoLabel.setIcon(icon);
        }

        add(nomeLabel, BorderLayout.NORTH);
        add(distanciaLabel, BorderLayout.CENTER);
        add(fotoLabel, BorderLayout.SOUTH);

        // Adicionar o botão de ações
        JButton actionButton = new JButton("Opções");
        add(actionButton, BorderLayout.EAST);

        actionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Atualizar", "Deletar"};
                int choice = JOptionPane.showOptionDialog(null, "Escolha uma ação", "Opções",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                if (choice == 0) { // Atualizar
                    atualizarPesquisa(pesquisa, aluno);
                } else if (choice == 1) { // Deletar
                    deletarPesquisa(pesquisa, aluno);
                }
            }
        });
    }

    private void atualizarPesquisa(PesquisaAluno pesquisa, Aluno aluno) {
        // Criando um painel personalizado para os campos de entrada
        JPanel panel = new JPanel(new GridLayout(0, 2));

        JTextField idField = new JTextField(pesquisa.getId());

    
        // Adicionando os campos ao painel
        panel.add(new JLabel("Nome do Planeta:"));
        JTextField nomeField = new JTextField(pesquisa.getNomePlaneta());
        panel.add(nomeField);
    
        panel.add(new JLabel("Distância da Terra:"));
        JTextField distanciaField = new JTextField(String.valueOf(pesquisa.getDistanciaDaTerra()));
        panel.add(distanciaField);
    
        panel.add(new JLabel("Foto URL:"));
        JTextField fotoField = new JTextField(pesquisa.getFoto());
        panel.add(fotoField);
    
        panel.add(new JLabel("Diâmetro:"));
        JTextField diametroField = new JTextField(String.valueOf(pesquisa.getDiametro()));
        panel.add(diametroField);
    
        panel.add(new JLabel("Massa:"));
        JTextField massaField = new JTextField(String.valueOf(pesquisa.getMassa()));
        panel.add(massaField);
    
        panel.add(new JLabel("Composição Atmosférica:"));
        JTextField composicaoAtmosfericaField = new JTextField(pesquisa.getComposicaoAtmosferica());
        panel.add(composicaoAtmosfericaField);
    
        panel.add(new JLabel("Temperatura Média:"));
        JTextField temperaturaMediaField = new JTextField(String.valueOf(pesquisa.getTemperaturaMedia()));
        panel.add(temperaturaMediaField);
    
        panel.add(new JLabel("Número de Luas:"));
        JTextField numeroDeLuasField = new JTextField(String.valueOf(pesquisa.getNumeroDeLuas()));
        panel.add(numeroDeLuasField);
    
        panel.add(new JLabel("Período Orbital:"));
        JTextField periodoOrbitalField = new JTextField(pesquisa.getPeriodoOrbital());
        panel.add(periodoOrbitalField);
    
        panel.add(new JLabel("Tipo de Superfície:"));
        JTextField tipoDeSuperficieField = new JTextField(pesquisa.getTipoDeSuperficie());
        panel.add(tipoDeSuperficieField);
    
        panel.add(new JLabel("Atividade Geológica:"));
        JTextField atividadeGeologicaField = new JTextField(pesquisa.getAtividadeGeologica());
        panel.add(atividadeGeologicaField);
    
        panel.add(new JLabel("Possibilidade de Água:"));
        JTextField possibilidadeDeAguaField = new JTextField(pesquisa.getPossibilidadeDeAgua());
        panel.add(possibilidadeDeAguaField);
    
        panel.add(new JLabel("Campo Magnético:"));
        JTextField campoMagneticoField = new JTextField(pesquisa.getCampoMagnetico());
        panel.add(campoMagneticoField);
    
        panel.add(new JLabel("Radiação:"));
        JTextField radiacaoField = new JTextField(pesquisa.getRadiacao());
        panel.add(radiacaoField);
    
        panel.add(new JLabel("Gravidade:"));
        JTextField gravidadeField = new JTextField(String.valueOf(pesquisa.getGravidade()));
        panel.add(gravidadeField);
    
        panel.add(new JLabel("Características Especiais:"));
        JTextField caracteristicasEspeciaisField = new JTextField(pesquisa.getCaracteristicasEspeciais());
        panel.add(caracteristicasEspeciaisField);
    
        // Exibindo o JOptionPane com o painel
        int result = JOptionPane.showConfirmDialog(null, panel, "Atualizar Pesquisa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
        if (result == JOptionPane.OK_OPTION) {
            try {
                // Atualizando os valores do objeto pesquisa
                pesquisa.setId(idField.getText());
                pesquisa.setNomePlaneta(nomeField.getText());
                pesquisa.setDistanciaDaTerra(Double.parseDouble(distanciaField.getText()));
                pesquisa.setFoto(fotoField.getText());
                pesquisa.setDiametro(Double.parseDouble(diametroField.getText()));
                pesquisa.setMassa(Double.parseDouble(massaField.getText()));
                pesquisa.setComposicaoAtmosferica(composicaoAtmosfericaField.getText());
                pesquisa.setTemperaturaMedia(Double.parseDouble(temperaturaMediaField.getText()));
                pesquisa.setNumeroDeLuas(Integer.parseInt(numeroDeLuasField.getText()));
                pesquisa.setPeriodoOrbital(periodoOrbitalField.getText());
                pesquisa.setTipoDeSuperficie(tipoDeSuperficieField.getText());
                pesquisa.setAtividadeGeologica(atividadeGeologicaField.getText());
                pesquisa.setPossibilidadeDeAgua(possibilidadeDeAguaField.getText());
                pesquisa.setCampoMagnetico(campoMagneticoField.getText());
                pesquisa.setRadiacao(radiacaoField.getText());
                pesquisa.setGravidade(gravidadeField.getText());
                pesquisa.setCaracteristicasEspeciais(caracteristicasEspeciaisField.getText());
    
                // Verificar se o ID está presente
                if (idField.getText() == null || idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Erro: Não é possível atualizar pois o ID está nulo ou vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
    
                // Atualizando no banco de dados utilizando o id
                PesquisaAlunoDAO pesquisaAlunoDAO = new PesquisaAlunoDAO();
                pesquisaAlunoDAO.atualizarPesquisaPorIdPlaneta(pesquisa.getId(), pesquisa);
    
                JOptionPane.showMessageDialog(null, "Pesquisa atualizada com sucesso!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: Certifique-se de que os campos numéricos estão preenchidos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    

    private void deletarPesquisa(PesquisaAluno pesquisa, Aluno aluno) {
        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar essa pesquisa?", "Confirmar exclusão", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            PesquisaAlunoDAO pesquisaAlunoDAO = new PesquisaAlunoDAO();
            pesquisaAlunoDAO.deletarPesquisaPorNomePlaneta(pesquisa.getNomePlaneta());

            JOptionPane.showMessageDialog(null, "Pesquisa deletada com sucesso!");
        }
    }

    
}
