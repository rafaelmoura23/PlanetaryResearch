package com.example.dao;

import com.example.model.Aluno;
import com.example.model.PesquisaAluno;
import com.example.model.Professor;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.Updates;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import org.bson.Document;
import org.bson.types.ObjectId;

public class PesquisaAlunoDAO {

    private MongoDatabase database;

    public PesquisaAlunoDAO() {
        this.database = ConnectionFactory.getDatabase();
        criarIndiceUnico();
    }

    private void criarIndiceUnico() {
        MongoCollection<Document> collection = database.getCollection("pesquisaAlunos");
        collection.createIndex(Indexes.ascending("nomePlaneta"), new IndexOptions().unique(true));
    }

    public void inserirPlaneta(PesquisaAluno pesquisaAluno) {
        MongoCollection<Document> collection = database.getCollection("pesquisaAlunos");
        Document doc = new Document("nomePlaneta", pesquisaAluno.getNomePlaneta())
                .append("distanciaDaTerra", pesquisaAluno.getDistanciaDaTerra())
                .append("foto", pesquisaAluno.getFoto())
                .append("diametro", pesquisaAluno.getDiametro())
                .append("massa", pesquisaAluno.getMassa())
                .append("composicaoAtmosferica", pesquisaAluno.getComposicaoAtmosferica())
                .append("temperaturaMedia", pesquisaAluno.getTemperaturaMedia())
                .append("numeroDeLuas", pesquisaAluno.getNumeroDeLuas())
                .append("periodoOrbital", pesquisaAluno.getPeriodoOrbital())
                .append("tipoDeSuperficie", pesquisaAluno.getTipoDeSuperficie())
                .append("atividadeGeologica", pesquisaAluno.getAtividadeGeologica())
                .append("possibilidadeDeAgua", pesquisaAluno.getPossibilidadeDeAgua())
                .append("campoMagnetico", pesquisaAluno.getCampoMagnetico())
                .append("radiacao", pesquisaAluno.getRadiacao())
                .append("gravidade", pesquisaAluno.getGravidade())
                .append("caracteristicasEspeciais", pesquisaAluno.getCaracteristicasEspeciais())
                .append("tipo", pesquisaAluno.getTipo())
                .append("idAluno", pesquisaAluno.getIdAluno());

        try {
            // Inserindo o documento na coleção e obtendo o resultado
            collection.insertOne(doc);

            // Obtendo o _id gerado pelo MongoDB
            ObjectId id = doc.getObjectId("_id");
            if (id != null) {
                pesquisaAluno.setId(id.toHexString());
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao obter o ID do documento após a inserção.");
            }

            JOptionPane.showMessageDialog(null, "Planeta Cadastrado com Sucesso!");
        } catch (MongoWriteException e) {
            if (e.getError().getCode() == 11000) {
                JOptionPane.showMessageDialog(null, "Erro: Já existe um planeta com esse nome.");
            } else {
                throw e;
            }
        }
    }

    // Método para atualizar a pesquisa por nome do planeta
    public void atualizarPesquisaPorIdPlaneta(String id, PesquisaAluno novaPesquisa) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("O id fornecido é nulo ou vazio.");
        }

        MongoCollection<Document> collection = database.getCollection("pesquisaAlunos");
        ObjectId objectId = new ObjectId(id);

        collection.updateOne(
                Filters.eq("_id", objectId),
                Updates.combine(
                        Updates.set("nomePlaneta", novaPesquisa.getNomePlaneta()),
                        Updates.set("distanciaDaTerra", novaPesquisa.getDistanciaDaTerra()),
                        Updates.set("foto", novaPesquisa.getFoto()),
                        Updates.set("diametro", novaPesquisa.getDiametro()),
                        Updates.set("massa", novaPesquisa.getMassa()),
                        Updates.set("composicaoAtmosferica", novaPesquisa.getComposicaoAtmosferica()),
                        Updates.set("temperaturaMedia", novaPesquisa.getTemperaturaMedia()),
                        Updates.set("numeroDeLuas", novaPesquisa.getNumeroDeLuas()),
                        Updates.set("periodoOrbital", novaPesquisa.getPeriodoOrbital()),
                        Updates.set("tipoDeSuperficie", novaPesquisa.getTipoDeSuperficie()),
                        Updates.set("atividadeGeologica", novaPesquisa.getAtividadeGeologica()),
                        Updates.set("possibilidadeDeAgua", novaPesquisa.getPossibilidadeDeAgua()),
                        Updates.set("campoMagnetico", novaPesquisa.getCampoMagnetico()),
                        Updates.set("radiacao", novaPesquisa.getRadiacao()),
                        Updates.set("gravidade", novaPesquisa.getGravidade()),
                        Updates.set("caracteristicasEspeciais", novaPesquisa.getCaracteristicasEspeciais())));

        System.out.println("Atualização realizada com sucesso.");
    }

    public void deletarPesquisaPorNomePlaneta(String nomePlaneta) {
        MongoCollection<Document> collection = database.getCollection("pesquisaAlunos");
        collection.deleteOne(Filters.eq("nomePlaneta", nomePlaneta));
    }

    // Método para buscar pesquisas do aluno logado pelo RA
    public List<PesquisaAluno> buscarPesquisasPorRA(String ra) {
        MongoCollection<Document> collection = database.getCollection("pesquisaAlunos");
        FindIterable<Document> documentos = collection.find(Filters.eq("idAluno", ra));
        List<PesquisaAluno> pesquisas = new ArrayList<>();

        for (Document doc : documentos) {
            PesquisaAluno pesquisa = new PesquisaAluno();
            pesquisa.setId(doc.getObjectId("_id").toHexString()); // Set the ID here
            pesquisa.setNomePlaneta(doc.getString("nomePlaneta"));
            pesquisa.setDistanciaDaTerra(doc.getDouble("distanciaDaTerra"));
            pesquisa.setFoto(doc.getString("foto"));
            pesquisa.setDiametro(doc.getDouble("diametro"));
            pesquisa.setMassa(doc.getDouble("massa"));
            pesquisa.setComposicaoAtmosferica(doc.getString("composicaoAtmosferica"));
            pesquisa.setTemperaturaMedia(doc.getDouble("temperaturaMedia"));
            pesquisa.setNumeroDeLuas(doc.getInteger("numeroDeLuas"));
            pesquisa.setPeriodoOrbital(doc.getString("periodoOrbital"));
            pesquisa.setTipoDeSuperficie(doc.getString("tipoDeSuperficie"));
            pesquisa.setAtividadeGeologica(doc.getString("atividadeGeologica"));
            pesquisa.setPossibilidadeDeAgua(doc.getString("possibilidadeDeAgua"));
            pesquisa.setCampoMagnetico(doc.getString("campoMagnetico"));
            pesquisa.setRadiacao(doc.getString("radiacao"));
            pesquisa.setGravidade(doc.getString("gravidade"));
            pesquisa.setCaracteristicasEspeciais(doc.getString("caracteristicasEspeciais"));
            pesquisa.setTipo(doc.getString("tipo"));
            pesquisa.setIdAluno(doc.getString("idAluno"));

            pesquisas.add(pesquisa);
        }

        return pesquisas;
    }

    

    public Document buscarDocumentoPorNomePlaneta(String nomePlaneta) {
        MongoCollection<Document> collection = database.getCollection("pesquisaAlunos");
        return collection.find(Filters.eq("nomePlaneta", nomePlaneta)).first();
    }


    // Método para listar planetas sem aluno (idAluno é null ou não existe)
    public List<PesquisaAluno> listarPlanetasSemAluno() {
        List<PesquisaAluno> planetas = new ArrayList<>();
        MongoCollection<Document> collection = database.getCollection("pesquisaAlunos");

        FindIterable<Document> documentos = collection.find(
                Filters.or(Filters.eq("idAluno", null), Filters.not(Filters.exists("idAluno"))));

        for (Document doc : documentos) {
            PesquisaAluno pesquisa = extrairPesquisaAluno(doc);
            planetas.add(pesquisa);
        }

        return planetas;
    }

// Método para listar planetas dos alunos do professor
public List<PesquisaAluno> listarPlanetasPorProfessor(Professor professor) {
    List<PesquisaAluno> planetas = new ArrayList<>();
    MongoCollection<Document> collection = database.getCollection("pesquisaAlunos");

    // Obter a lista de RAs dos alunos do professor
    List<String> rasDosAlunos = professor.getAlunos();

    // Buscar pesquisas onde idAluno está na lista de RAs
    if (rasDosAlunos != null && !rasDosAlunos.isEmpty()) {
        FindIterable<Document> documentos = collection.find(Filters.in("idAluno", rasDosAlunos));

        for (Document doc : documentos) {
            PesquisaAluno pesquisa = extrairPesquisaAluno(doc);
            planetas.add(pesquisa);
        }
    }

    return planetas;
}

    // Método auxiliar para extrair PesquisaAluno de um Document
    private PesquisaAluno extrairPesquisaAluno(Document doc) {
        PesquisaAluno pesquisa = new PesquisaAluno();
        pesquisa.setId(doc.getObjectId("_id").toHexString());
        pesquisa.setNomePlaneta(doc.getString("nomePlaneta"));
        pesquisa.setDistanciaDaTerra(doc.getDouble("distanciaDaTerra"));
        pesquisa.setFoto(doc.getString("foto"));
        pesquisa.setDiametro(doc.getDouble("diametro"));
        pesquisa.setMassa(doc.getDouble("massa"));
        pesquisa.setComposicaoAtmosferica(doc.getString("composicaoAtmosferica"));
        pesquisa.setTemperaturaMedia(doc.getDouble("temperaturaMedia"));
        pesquisa.setNumeroDeLuas(doc.getInteger("numeroDeLuas"));
        pesquisa.setPeriodoOrbital(doc.getString("periodoOrbital"));
        pesquisa.setTipoDeSuperficie(doc.getString("tipoDeSuperficie"));
        pesquisa.setAtividadeGeologica(doc.getString("atividadeGeologica"));
        pesquisa.setPossibilidadeDeAgua(doc.getString("possibilidadeDeAgua"));
        pesquisa.setCampoMagnetico(doc.getString("campoMagnetico"));
        pesquisa.setRadiacao(doc.getString("radiacao"));
        pesquisa.setGravidade(doc.getString("gravidade"));
        pesquisa.setCaracteristicasEspeciais(doc.getString("caracteristicasEspeciais"));
        pesquisa.setTipo(doc.getString("tipo"));
        pesquisa.setIdAluno(doc.getString("idAluno"));
        return pesquisa;
    }

}
