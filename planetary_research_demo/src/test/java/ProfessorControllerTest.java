import com.example.dao.ProfessorDAO;
import com.example.model.Professor;
import com.example.controller.ProfessorController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ProfessorControllerTest {
    @Mock
    private ProfessorDAO professorDAO;

    @InjectMocks
    private ProfessorController professorController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarProfessorComSucesso() {
        // Configurar mock do Professor
        Professor professor = new Professor();
        professor.setNome("rafa");
        professor.setEmail("rafa@example.com");
        professor.setSenha("senha123");
        professor.setIdade("19");
        professor.setTelefone("123456789");
        professor.setNomeFaculdade("Faculdade ABC");
        professor.setTipoUsuario("professor");
        professor.setLinkedinGithub("github.com/rafa");

        // Chamar o método que será testado
        professorController.cadastrarProfessor(professor);
    }

    @Test
    public void testCadastrarProfessorComErroValidacao() {

        Professor professor = new Professor();
        try {
            professorController.cadastrarProfessor(professor);
        } catch (IllegalArgumentException e) {
            // Verificar se a exceção é lançada corretamente
            assert e.getMessage().equals("O campo nome não pode estar vazio.");
        }

        // Verificar que o método cadastrarAluno não foi chamado
        verify(professorDAO, times(0)).cadastrarProfessor(any(Professor.class));
    }

}
