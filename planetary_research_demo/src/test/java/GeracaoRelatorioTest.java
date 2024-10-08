import com.example.controller.RelatorioController;
import com.example.model.PesquisaAluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

import static org.junit.jupiter.api.Assertions.*;

public class GeracaoRelatorioTest {
    private RelatorioController relatorioController;
    private PesquisaAluno planetaAluno;
    private PesquisaAluno planetaReal;

    @BeforeEach
    public void setUp() {
        relatorioController = new RelatorioController();

        // Mock de dados para os testes
        planetaAluno = new PesquisaAluno();
        planetaAluno.setNomePlaneta("Terra");
        planetaAluno.setDistanciaDaTerra(150e6);
        planetaAluno.setDiametro(12742);
        planetaAluno.setMassa(5.972e24);
        planetaAluno.setTemperaturaMedia(15);
        planetaAluno.setNumeroDeLuas(1);
        planetaAluno.setGravidade("9.8");

        planetaReal = new PesquisaAluno();
        planetaReal.setNomePlaneta("Terra");
        planetaReal.setDistanciaDaTerra(150e6);
        planetaReal.setDiametro(12742);
        planetaReal.setMassa(5.972e24);
        planetaReal.setTemperaturaMedia(15);
        planetaReal.setNumeroDeLuas(1);
        planetaReal.setGravidade("9.8");
    }

    @Test
    public void testCalcularSimilaridadeValorRealZero() {
        double similaridade = relatorioController.calcularSimilaridade(0, 0);
        assertEquals(1.0, similaridade);

        similaridade = relatorioController.calcularSimilaridade(10, 0);
        assertEquals(0.0, similaridade);
    }

    @Test
    public void testCalcularSimilaridadeValoresNormais() {
        double similaridade = relatorioController.calcularSimilaridade(100, 200);
        assertEquals(0.5, similaridade, 0.01);

        similaridade = relatorioController.calcularSimilaridade(200, 100);
        assertEquals(0.5, similaridade, 0.01);
    }

    @Test
    public void testGerarArquivoTxt() throws IOException {
        String conteudo = "Teste de conteúdo para o arquivo.";
        String nomeArquivo = "relatorio_teste.txt";

        // Gerar o arquivo
        relatorioController.gerarArquivoTxt(conteudo, nomeArquivo);

        // Verificar se o arquivo foi criado
        File arquivo = new File(nomeArquivo);
        assertTrue(arquivo.exists());

        // Ler o arquivo e verificar seu conteúdo
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha = reader.readLine();
            assertEquals(conteudo, linha);
        }

        // Apagar o arquivo de teste após a verificação
        arquivo.delete();
    }
}
