package com.example.view.pesquisa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.dao.PesquisaAlunoDAO;
import com.example.model.Aluno;
import com.example.model.PesquisaAluno;
import com.example.model.Professor;

public class PaginaCadastroPesquisaAluno extends JFrame {
    public PaginaCadastroPesquisaAluno(Aluno aluno, Professor professor) {
        setTitle("Sistema de Gerenciamento de Pesquisas");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Verifica se aluno ou professor estão disponíveis
        String tipoUsuario;
        String nomeUsuario;

        if (aluno != null) {
            tipoUsuario = aluno.getTipoUsuario();
            nomeUsuario = aluno.getNome();
        } else if (professor != null) {
            tipoUsuario = professor.getTipoUsuario();
            nomeUsuario = professor.getNome();
        } else {
            tipoUsuario = "desconhecido";
            nomeUsuario = "usuário";
        }

        JLabel welcomeLabel = new JLabel("Bem-vindo, " + tipoUsuario + " " + nomeUsuario);
        welcomeLabel.setBounds(50, 20, 300, 30);
        add(welcomeLabel);

        // Campos para cadastro de planeta
        JLabel nomePlanetaLabel = new JLabel("Nome do Planeta:");
        nomePlanetaLabel.setBounds(50, 60, 200, 30);
        add(nomePlanetaLabel);
        JTextField nomePlanetaField = new JTextField();
        nomePlanetaField.setBounds(250, 60, 400, 30);
        add(nomePlanetaField);

        JLabel distanciaLabel = new JLabel("Distância da Terra (Anos luz):");
        distanciaLabel.setBounds(50, 100, 200, 30);
        add(distanciaLabel);
        JTextField distanciaField = new JTextField();
        distanciaField.setBounds(250, 100, 400, 30);
        add(distanciaField);

        JLabel fotoLabel = new JLabel("Foto (URL):");
        fotoLabel.setBounds(50, 140, 200, 30);
        add(fotoLabel);
        JTextField fotoField = new JTextField();
        fotoField.setBounds(250, 140, 400, 30);
        add(fotoField);

        JLabel diametroLabel = new JLabel("Diâmetro:");
        diametroLabel.setBounds(50, 180, 200, 30);
        add(diametroLabel);
        JTextField diametroField = new JTextField();
        diametroField.setBounds(250, 180, 400, 30);
        add(diametroField);

        JLabel massaLabel = new JLabel("Massa:");
        massaLabel.setBounds(50, 220, 200, 30);
        add(massaLabel);
        JTextField massaField = new JTextField();
        massaField.setBounds(250, 220, 400, 30);
        add(massaField);

        JLabel composicaoLabel = new JLabel("Composição Atmosférica:");
        composicaoLabel.setBounds(50, 260, 200, 30);
        add(composicaoLabel);
        JTextField composicaoField = new JTextField();
        composicaoField.setBounds(250, 260, 400, 30);
        add(composicaoField);

        JLabel temperaturaLabel = new JLabel("Temperatura Média:");
        temperaturaLabel.setBounds(50, 300, 200, 30);
        add(temperaturaLabel);
        JTextField temperaturaField = new JTextField();
        temperaturaField.setBounds(250, 300, 400, 30);
        add(temperaturaField);

        JLabel numeroLuasLabel = new JLabel("Número de Luas:");
        numeroLuasLabel.setBounds(50, 340, 200, 30);
        add(numeroLuasLabel);
        JTextField numeroLuasField = new JTextField();
        numeroLuasField.setBounds(250, 340, 400, 30);
        add(numeroLuasField);

        JLabel periodoOrbitalLabel = new JLabel("Período Orbital:");
        periodoOrbitalLabel.setBounds(50, 380, 200, 30);
        add(periodoOrbitalLabel);
        JTextField periodoOrbitalField = new JTextField();
        periodoOrbitalField.setBounds(250, 380, 400, 30);
        add(periodoOrbitalField);

        JLabel tipoSuperficieLabel = new JLabel("Tipo de Superfície:");
        tipoSuperficieLabel.setBounds(50, 420, 200, 30);
        add(tipoSuperficieLabel);
        JTextField tipoSuperficieField = new JTextField();
        tipoSuperficieField.setBounds(250, 420, 400, 30);
        add(tipoSuperficieField);

        JLabel atividadeGeologicaLabel = new JLabel("Atividade Geológica:");
        atividadeGeologicaLabel.setBounds(50, 460, 200, 30);
        add(atividadeGeologicaLabel);
        JTextField atividadeGeologicaField = new JTextField();
        atividadeGeologicaField.setBounds(250, 460, 400, 30);
        add(atividadeGeologicaField);

        JLabel possibilidadeAguaLabel = new JLabel("Possibilidade de Água:");
        possibilidadeAguaLabel.setBounds(50, 500, 200, 30);
        add(possibilidadeAguaLabel);
        JTextField possibilidadeAguaField = new JTextField();
        possibilidadeAguaField.setBounds(250, 500, 400, 30);
        add(possibilidadeAguaField);

        JLabel campoMagneticoLabel = new JLabel("Campo Magnético:");
        campoMagneticoLabel.setBounds(50, 540, 200, 30);
        add(campoMagneticoLabel);
        JTextField campoMagneticoField = new JTextField();
        campoMagneticoField.setBounds(250, 540, 400, 30);
        add(campoMagneticoField);

        JLabel radiacaoLabel = new JLabel("Radiação:");
        radiacaoLabel.setBounds(50, 580, 200, 30);
        add(radiacaoLabel);
        JTextField radiacaoField = new JTextField();
        radiacaoField.setBounds(250, 580, 400, 30);
        add(radiacaoField);

        JLabel gravidadeLabel = new JLabel("Gravidade:");
        gravidadeLabel.setBounds(50, 620, 200, 30);
        add(gravidadeLabel);
        JTextField gravidadeField = new JTextField();
        gravidadeField.setBounds(250, 620, 400, 30);
        add(gravidadeField);

        JLabel caracteristicasLabel = new JLabel("Características Especiais:");
        caracteristicasLabel.setBounds(50, 660, 200, 30);
        add(caracteristicasLabel);
        JTextField caracteristicasField = new JTextField();
        caracteristicasField.setBounds(250, 660, 400, 30);
        add(caracteristicasField);

        JLabel idAlunoLabel = new JLabel("ID Aluno:");
        idAlunoLabel.setBounds(50, 690, 200, 30);
        add(idAlunoLabel);
        String idAluno = aluno.getRa();
        JTextField idAlunoField = new JTextField(idAluno);
        idAlunoField.setBounds(250, 690, 400, 30);
        add(idAlunoField);
        idAlunoField.setEditable(false);

        // Botão para salvar a pesquisa
        JButton salvarButton = new JButton("Salvar Pesquisa");
        salvarButton.setBounds(300, 700, 200, 40);
        add(salvarButton);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Captura dos dados dos campos
                String nomePlaneta = nomePlanetaField.getText();
                String distanciaString = distanciaField.getText(); // double
                double distancia = Double.parseDouble(distanciaString);
                String foto = fotoField.getText();
                String diametroString = diametroField.getText(); // double
                double diametro = Double.parseDouble(diametroString); // parse
                String massaString = massaField.getText(); // double
                double massa = Double.parseDouble(massaString);
                String composicao = composicaoField.getText();
                String temperaturaString = temperaturaField.getText(); // double
                double temperatura = Double.parseDouble(temperaturaString);
                String numeroLuasString = numeroLuasField.getText(); // int
                int numeroLuas = Integer.parseInt(numeroLuasString);
                String periodoOrbital = periodoOrbitalField.getText();
                String tipoSuperficie = tipoSuperficieField.getText();
                String atividadeGeologica = atividadeGeologicaField.getText();
                String possibilidadeAgua = possibilidadeAguaField.getText();
                String campoMagnetico = campoMagneticoField.getText();
                String radiacao = radiacaoField.getText();
                String gravidade = gravidadeField.getText();
                String caracteristicas = caracteristicasField.getText();
                String idAluno = aluno.getRa();

                PesquisaAluno pesquisaAluno = new PesquisaAluno(
                        nomePlaneta, distancia, foto, diametro, massa, composicao,
                        temperatura, numeroLuas, periodoOrbital, tipoSuperficie,
                        atividadeGeologica, possibilidadeAgua, campoMagnetico,
                        radiacao, gravidade, caracteristicas, tipoUsuario, idAluno);
                PesquisaAlunoDAO pesquisaAlunoDAO = new PesquisaAlunoDAO();
                pesquisaAlunoDAO.inserirPlaneta(pesquisaAluno);
                JOptionPane.showMessageDialog(null, "Pesquisa/Planeta cadastrada com sucesso!");

                // Limpar campos após salvar
                nomePlanetaField.setText("");
                distanciaField.setText("");
                fotoField.setText("");
                diametroField.setText("");
                massaField.setText("");
                composicaoField.setText("");
                temperaturaField.setText("");
                numeroLuasField.setText("");
                periodoOrbitalField.setText("");
                tipoSuperficieField.setText("");
                atividadeGeologicaField.setText("");
                possibilidadeAguaField.setText("");
                campoMagneticoField.setText("");
                radiacaoField.setText("");
                gravidadeField.setText("");
                caracteristicasField.setText("");
            }
        });

        setVisible(true);
    }
}
