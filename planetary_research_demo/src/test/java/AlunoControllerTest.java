import com.example.controller.AlunoController;
import com.example.dao.AlunoDAO;
import com.example.model.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class AlunoControllerTest {

    @Mock
    private AlunoDAO alunoDAO;

    @InjectMocks
    private AlunoController alunoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarAlunoComSucesso() {
        // Configurar mock do Aluno
        Aluno aluno = new Aluno();
        aluno.setNome("Felipe");
        aluno.setEmail("felipe@example.com");
        aluno.setSenha("senha123");
        aluno.setRa("12345");
        aluno.setTelefone("123456789");
        aluno.setCurso("Ciência da Computação");
        aluno.setNomeFaculdade("Faculdade ABC");
        aluno.setAreaDePesquisa("Inteligência Artificial");
        aluno.setOrientador("Professor XYZ");
        aluno.setTipoUsuario("Aluno");
        aluno.setLinkedinGithub("github.com/felipe");

        // método que será testado
        alunoController.cadastrarAlunoController(aluno);
    }

    @Test
    public void testCadastrarAlunoComErroValidacao() {
        
        Aluno aluno = new Aluno(); 
        try {
            alunoController.cadastrarAlunoController(aluno);
        } catch (IllegalArgumentException e) {
            // Verificar se a exceção é lançada
            assert e.getMessage().equals("O campo nome não pode estar vazio.");
        }
    }


}
