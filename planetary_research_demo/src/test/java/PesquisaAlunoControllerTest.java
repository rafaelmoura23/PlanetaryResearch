import com.example.dao.PesquisaAlunoDAO;
import com.example.model.PesquisaAluno;
import com.example.controller.PesquisaAlunoController;
import com.mongodb.MongoWriteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class PesquisaAlunoControllerTest {

    @Mock
    private PesquisaAlunoDAO pesquisaAlunoDAO;

    @InjectMocks
    private PesquisaAlunoController pesquisaAlunoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarPesquisaAlunoComSucesso() {
        PesquisaAluno aluno = new PesquisaAluno();
        aluno.setNomePlaneta("Terra");
        aluno.setIdAluno("1");

        // Simular comportamento do DAO
        doNothing().when(pesquisaAlunoDAO).inserirPlaneta(aluno);

        // Chamar o método que será testado
        
        pesquisaAlunoController.cadastrarPesquisaAluno(aluno);

        // Verificar se o método do DAO foi chamado
        verify(pesquisaAlunoDAO, times(1)).inserirPlaneta(aluno);
    }

    @Test
    public void testCadastrarPesquisaAlunoComPesquisaNula() {
        // Chamar o método que será testado
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            pesquisaAlunoController.cadastrarPesquisaAluno(null);
        });

        // Verificar a mensagem de exceção
        assertEquals("A pesquisa do aluno não pode ser nula.", exception.getMessage());
    }

    @Test
    public void testCadastrarPesquisaAlunoComNomePlanetaVazio() {
        // Configurar mock do objeto PesquisaAluno
        PesquisaAluno aluno = new PesquisaAluno();
        aluno.setNomePlaneta("");
        aluno.setIdAluno("1");

        // Chamar o método que será testado
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            pesquisaAlunoController.cadastrarPesquisaAluno(aluno);
        });

        // Verificar a mensagem de exceção
        assertEquals("O nome do planeta não pode ser vazio.", exception.getMessage());
    }

    @Test
    public void testCadastrarPesquisaAlunoComIdAlunoVazio() {
        // Configurar mock do objeto PesquisaAluno
        PesquisaAluno aluno = new PesquisaAluno();
        aluno.setNomePlaneta("Terra");
        aluno.setIdAluno("");

        // Chamar o método que será testado
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            pesquisaAlunoController.cadastrarPesquisaAluno(aluno);
        });

        // Verificar a mensagem de exceção
        assertEquals("O ID do aluno não pode ser vazio.", exception.getMessage());
    }

    @Test
    public void testAtualizarPesquisaComIdNulo() {
        // Configurar mock do objeto PesquisaAluno
        PesquisaAluno aluno = new PesquisaAluno();
        aluno.setId(null);

        // Chamar o método que será testado
        Exception exception = assertThrows(Exception.class, () -> {
            pesquisaAlunoController.atualizarPesquisa(aluno);
        });

        // Verificar a mensagem de exceção
        assertEquals("Erro: O ID está nulo ou vazio.", exception.getMessage());
    }


    @Test
    public void testAtualizarPesquisaComSucesso() {
        // Configurar mock do objeto PesquisaAluno
        PesquisaAluno aluno = new PesquisaAluno();
        aluno.setId("10");
        aluno.setAtividadeGeologica("TesteAtualizacao");
        aluno.setDiametro(10);
    }

    @Test
    public void testDeletarPesquisaComNomePlanetaVazio() {
        // Configurar mock do objeto PesquisaAluno
        PesquisaAluno aluno = new PesquisaAluno();
        aluno.setNomePlaneta("");

        // Chamar o método que será testado
        Exception exception = assertThrows(Exception.class, () -> {
            pesquisaAlunoController.deletarPesquisa(aluno);
        });

        // Verificar a mensagem de exceção
        assertEquals("Erro: O nome do planeta está vazio.", exception.getMessage());
    }
}
