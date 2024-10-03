# PlanetaryResearch 🌌

**PlanetaryResearch** é uma aplicação educacional interativa desenvolvida em **Java** (utilizando **Swing**) com um banco de dados **MongoDB**. O sistema visa facilitar a pesquisa e o estudo de planetas por **professores** e **alunos/pesquisadores**, promovendo um ambiente acadêmico para o lançamento e validação de informações planetárias.

## Funcionalidades Principais

### 1. Página de Login e Cadastro
O sistema oferece login e cadastro diferenciados para **Professores** e **Alunos/Pesquisadores**:
- **Professor:**
  - Informações: Nome, Email, Telefone, Registro da Faculdade, Nome da Faculdade, Formação, Idade, Senha, Linkedin ou Github, Área de Estudo, Lista de Alunos.
  - Controle de orientandos: Professores podem cadastrar seus alunos para associá-los às suas pesquisas.

- **Aluno/Pesquisador:**
  - Informações: Nome, Email, Telefone, RA, Nome da Faculdade, Senha, Curso, Orientador, Linkedin ou Github, Área de Pesquisa.
  - O orientador é automaticamente associado com base nos alunos cadastrados pelo professor.

### 2. Funcionalidades para o Professor
- **Cadastro de Planetas:** O professor pode cadastrar planetas reais com informações como:
  - Nome do Planeta, Distância da Terra, Diâmetro, Massa, Composição Atmosférica, Número de Luas, etc.
- **Validação de Descobertas:** Professores podem comparar os planetas cadastrados pelos alunos com os planetas reais e gerar relatórios determinando a veracidade das descobertas.

### 3. Funcionalidades para o Aluno/Pesquisador
- **Cadastro de Novos Planetas:** Alunos podem cadastrar informações sobre planetas que acreditam ter descoberto, inserindo dados como:
  - Nome, Distância da Terra, Composição Atmosférica, Temperatura Média, Tipo de Superfície, etc.
- **API CRUD:** Alunos podem realizar operações de criar, visualizar, atualizar e deletar planetas por meio da API do sistema.

### 4. Relatório de Descoberta
- Após o envio das informações, o professor pode comparar os dados inseridos pelo aluno com planetas reais e gerar um relatório que determina se a descoberta do aluno corresponde a um novo planeta ou não.
- Futuramente, o sistema poderá contar com uma **IA** para realizar comparações automáticas e verificar a habitabilidade dos planetas.

## Diagrama de Navegação

1. **Página Inicial**: Escolha entre login para Professor ou Aluno/Pesquisador.
2. **Página de Cadastro**: Preenchimento de informações e registro no sistema.
3. **Página de Login**: Validação de credenciais (email/RA e senha) para acesso à plataforma.
4. **Página Interna do Aluno**:
   - Visualização de Planetas em Andamento (CARDS)
   - Cadastro de Novos Planetas por meio da API
5. **Página Interna do Professor**:
   - Cadastro de Planetas Reais
   - Geração de Relatório sobre as descobertas dos Alunos
6. **Logout**: Opção disponível para ambos os tipos de usuário.

## Tecnologias Utilizadas
- **Java (JavaFX ou Swing)**
- **MongoDB** para gerenciamento de banco de dados
- **APIs** para comunicação entre alunos e professores

## Futuras Expansões
- Implementação de uma **IA** para validar planetas automaticamente.
- Função para verificar a habitabilidade de planetas cadastrados pelos alunos.

---

**PlanetaryResearch** traz a exploração espacial para a sala de aula, promovendo uma experiência de aprendizado prática e interativa, onde alunos e professores podem colaborar e validar descobertas científicas.

``` mermaid

classDiagram
    class Professor {
        +String nome
        +String email
        +String telefone
        +String registroFaculdade
        +String nomeFaculdade
        +String formacao
        +int idade
        +String senha
        +String linkedinOuGithub
        +String areaEstudo
        +List~Aluno~ alunos
    }

    class Aluno {
        +String nome
        +String email
        +String telefone
        +String ra
        +String nomeFaculdade
        +String senha
        +String curso
        +Professor orientador
        +String linkedinOuGithub
        +String areaPesquisa
    }

    Professor "1" --> "0..*" Aluno : tem
    
    Aluno --> Professor : orientadoPor
```
