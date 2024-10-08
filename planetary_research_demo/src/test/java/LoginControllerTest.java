import com.example.dao.AlunoDAO;
import com.example.model.Aluno;
import com.example.controller.LoginController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class LoginControllerTest {

    @Mock
    private AlunoDAO alunoDAO;

    @InjectMocks
    private LoginController loginController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginAlunoComSucesso() {
        // Configurar mock do Aluno
        Aluno aluno = new Aluno();
        aluno.setEmail("rafa@example.com");
        aluno.setSenha("senha123");

        // Simular comportamento do DAO
        when(alunoDAO.buscarAlunoPorEmailESenha("rafa@example.com", "senha123")).thenReturn(aluno);

        // Chamar o método que será testado
        Aluno resultado = loginController.loginAluno("rafa@example.com", "senha123");

        // Verificar o comportamento
        assert resultado != null;
        assert resultado.getEmail().equals("rafa@example.com");

        // Verificar se o método buscarAlunoPorEmailESenha foi chamado
        verify(alunoDAO, times(1)).buscarAlunoPorEmailESenha("rafa@example.com", "senha123");
    }

    @Test
    public void testLoginAlunoComErroDeCredenciais() {
        // Simular retorno nulo no DAO
        when(alunoDAO.buscarAlunoPorEmailESenha("rafa@example.com", "senhaErrada")).thenReturn(null);

        // Chamar o método que será testado
        Aluno resultado = loginController.loginAluno("rafa@example.com", "senhaErrada");

        // Verificar o comportamento
        assert resultado == null;

        // Verificar se o método buscarAlunoPorEmailESenha foi chamado
        verify(alunoDAO, times(1)).buscarAlunoPorEmailESenha("felipe@example.com", "senhaErrada");
    }
}
