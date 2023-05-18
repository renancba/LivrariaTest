package tech.ada.javatestproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tech.ada.javatestproject.model.Livro;
import tech.ada.javatestproject.model.LivroDTO;
import tech.ada.javatestproject.repository.LivroRepository;
import tech.ada.javatestproject.utils.LivroMapper;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class LivroControllerTest {

    @Autowired
    private LivroController controller;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LivroRepository repository;

    @Autowired
    private LivroMapper mapper;

    @Test
    public void carregouContexto(){
        Assertions.assertNotNull(controller);
    }
    @Test
    public void testeOk() throws Exception{
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/livros"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void criarLivroComSucesso() throws Exception{
        LivroDTO livro1 = new LivroDTO();

        livro1.setTitulo("Dom Casmurro");
        livro1.setResumo("A história de Capitu e Bentinho, dois jovens apaixonados que enfrentam diversos obstáculos para viver seu amor.");
        livro1.setSumario("1. Capítulo 1\n2. Capítulo 2\n3. Capítulo 3");
        livro1.setPreco(29.9);
        livro1.setPaginas(256);
        livro1.setIsbn("9788571640072");
        livro1.setDataLancamento(Date.valueOf(LocalDate.now().plusDays(1)));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(livro1);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void criarLivroSemTituloComErro() throws Exception{
        LivroDTO livro1 = new LivroDTO();

        livro1.setTitulo("");
        livro1.setResumo("A história de Capitu e Bentinho, dois jovens apaixonados que enfrentam diversos obstáculos para viver seu amor.");
        livro1.setSumario("1. Capítulo 1\n2. Capítulo 2\n3. Capítulo 3");
        livro1.setPreco(29.9);
        livro1.setPaginas(256);
        livro1.setIsbn("9788571640072");
        livro1.setDataLancamento(Date.valueOf(LocalDate.now().plusDays(1)));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(livro1);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void criarLivroSemResumoComErro() throws Exception{
        LivroDTO livro1 = new LivroDTO();

        livro1.setTitulo("Dom Casmurro");
        livro1.setResumo("");
        livro1.setSumario("1. Capítulo 1\n2. Capítulo 2\n3. Capítulo 3");
        livro1.setPreco(29.9);
        livro1.setPaginas(256);
        livro1.setIsbn("9788571640072");
        livro1.setDataLancamento(Date.valueOf(LocalDate.now().plusDays(1)));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(livro1);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void criarLivroComResumoGrandeComErro() throws Exception{
        LivroDTO livro1 = new LivroDTO();

        livro1.setTitulo("Dom Casmurro");
        livro1.setResumo("Dom Casmurro é um romance de Machado de Assis que narra a história de Bentinho e Capitu, jovens apaixonados que enfrentam obstáculos para viver seu amor. " +
                "Bentinho se torna padre, mas desconfia da fidelidade de Capitu, alimentando suspeitas sobre a paternidade de seu filho. O ciúme e a dúvida corroem a relação do casal ao longo dos anos. " +
                "O livro aborda temas como traição, amor, ciúme e as complexidades da natureza humana. Com sua narrativa envolvente e perspicácia psicológica, " +
                "Machado de Assis questiona a percepção da realidade e instiga o leitor a refletir sobre os limites da confiança e a natureza das relações interpessoais.");
        livro1.setSumario("1. Capítulo 1\n2. Capítulo 2\n3. Capítulo 3");
        livro1.setPreco(29.9);
        livro1.setPaginas(256);
        livro1.setIsbn("9788571640072");
        livro1.setDataLancamento(Date.valueOf(LocalDate.now().plusDays(1)));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(livro1);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void criarLivroComPrecoBaixoComErro() throws Exception{
        LivroDTO livro1 = new LivroDTO();

        livro1.setTitulo("Dom Casmurro");
        livro1.setResumo("A história de Capitu e Bentinho, dois jovens apaixonados que enfrentam diversos obstáculos para viver seu amor.");
        livro1.setSumario("1. Capítulo 1\n2. Capítulo 2\n3. Capítulo 3");
        livro1.setPreco(9.99);
        livro1.setPaginas(256);
        livro1.setIsbn("9788571640072");
        livro1.setDataLancamento(Date.valueOf(LocalDate.now().plusDays(1)));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(livro1);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
    @Test
    public void criarLivroSemPrecoComErro() throws Exception{
        LivroDTO livro1 = new LivroDTO();

        livro1.setTitulo("Dom Casmurro");
        livro1.setResumo("A história de Capitu e Bentinho, dois jovens apaixonados que enfrentam diversos obstáculos para viver seu amor.");
        livro1.setSumario("1. Capítulo 1\n2. Capítulo 2\n3. Capítulo 3");
        livro1.setPreco(null);
        livro1.setPaginas(256);
        livro1.setIsbn("9788571640072");
        livro1.setDataLancamento(Date.valueOf(LocalDate.now().plusDays(1)));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(livro1);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void criarLivroComPaginasBaixaComErro() throws Exception{
        LivroDTO livro1 = new LivroDTO();

        livro1.setTitulo("Dom Casmurro");
        livro1.setResumo("A história de Capitu e Bentinho, dois jovens apaixonados que enfrentam diversos obstáculos para viver seu amor.");
        livro1.setSumario("1. Capítulo 1\n2. Capítulo 2\n3. Capítulo 3");
        livro1.setPreco(29.99);
        livro1.setPaginas(99);
        livro1.setIsbn("9788571640072");
        livro1.setDataLancamento(Date.valueOf(LocalDate.now().plusDays(1)));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(livro1);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void criarLivroSemPaginasComErro() throws Exception{
        LivroDTO livro1 = new LivroDTO();

        livro1.setTitulo("Dom Casmurro");
        livro1.setResumo("A história de Capitu e Bentinho, dois jovens apaixonados que enfrentam diversos obstáculos para viver seu amor.");
        livro1.setSumario("1. Capítulo 1\n2. Capítulo 2\n3. Capítulo 3");
        livro1.setPreco(29.99);
        livro1.setPaginas(null);
        livro1.setIsbn("9788571640072");
        livro1.setDataLancamento(Date.valueOf(LocalDate.now().plusDays(1)));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(livro1);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void criarLivroSemIsbnComErro() throws Exception{
        LivroDTO livro1 = new LivroDTO();

        livro1.setTitulo("Dom Casmurro");
        livro1.setResumo("A história de Capitu e Bentinho, dois jovens apaixonados que enfrentam diversos obstáculos para viver seu amor.");
        livro1.setSumario("1. Capítulo 1\n2. Capítulo 2\n3. Capítulo 3");
        livro1.setPreco(29.99);
        livro1.setPaginas(256);
        livro1.setIsbn("");
        livro1.setDataLancamento(Date.valueOf(LocalDate.now().plusDays(1)));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(livro1);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }


    @Test
    public void criarLivroDataPassadaComErro() throws Exception{
        LivroDTO livro1 = new LivroDTO();

        livro1.setTitulo("Dom Casmurro");
        livro1.setResumo("A história de Capitu e Bentinho, dois jovens apaixonados que enfrentam diversos obstáculos para viver seu amor.");
        livro1.setSumario("1. Capítulo 1\n2. Capítulo 2\n3. Capítulo 3");
        livro1.setPreco(29.99);
        livro1.setPaginas(256);
        livro1.setIsbn("9788571640072");
        livro1.setDataLancamento(Date.valueOf(LocalDate.now().minusDays(1)));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(livro1);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void criarLivroDataPresenteaComErro() throws Exception{
        LivroDTO livro1 = new LivroDTO();

        livro1.setTitulo("Dom Casmurro");
        livro1.setResumo("A história de Capitu e Bentinho, dois jovens apaixonados que enfrentam diversos obstáculos para viver seu amor.");
        livro1.setSumario("1. Capítulo 1\n2. Capítulo 2\n3. Capítulo 3");
        livro1.setPreco(29.99);
        livro1.setPaginas(256);
        livro1.setIsbn("9788571640072");
        livro1.setDataLancamento(Date.valueOf(LocalDate.now()));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(livro1);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

}
