package com.example.dao;

import com.example.model.Aluno;
import com.example.model.PesquisaAluno;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import org.bson.Document;

public class PesquisaAlunoDAO {

    private MongoDatabase database;

    public PesquisaAlunoDAO() {
        this.database = ConnectionFactory.getDatabase();
    }

    // Método para inserir um novo planeta
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

        collection.insertOne(doc);
    }

    // Método para atualizar a pesquisa por nome do planeta
    public void atualizarPesquisaPorNomePlaneta(String nomePlaneta, PesquisaAluno novaPesquisa) {
        MongoCollection<Document> collection = database.getCollection("pesquisaAlunos");

        collection.updateOne(
                Filters.eq("nomePlaneta", nomePlaneta), // Filtro para encontrar a pesquisa
                Updates.combine(
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
    }

    public void deletarPesquisaPorNomePlaneta(String nomePlaneta) {
        MongoCollection<Document> collection = database.getCollection("pesquisaAlunos");
        collection.deleteOne(Filters.eq("nomePlaneta", nomePlaneta));
    }
}
