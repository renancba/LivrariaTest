package tech.ada.javatestproject.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import tech.ada.javatestproject.model.LivroDTO;


import java.sql.Date;
import java.time.LocalDate;

public class LivroTeste {


    @Test
    public void LivroTest(){
        LivroDTO livro = new LivroDTO();

        livro.setId(1L);
        livro.setTitulo("Dom Casmurro");
        livro.setResumo("A história de Capitu e Bentinho, dois jovens apaixonados que enfrentam diversos obstáculos para viver seu amor.");
        livro.setSumario("1. Capítulo 1\n2. Capítulo 2\n3. Capítulo 3");
        livro.setPreco(29.9);
        livro.setPaginas(256);
        livro.setIsbn("9788571640072");
        livro.setDataLancamento(Date.valueOf(LocalDate.now().plusDays(1)));

        Assertions.assertEquals(1L, livro.getId());
        Assertions.assertEquals("Dom Casmurro", livro.getTitulo());
        Assertions.assertEquals("A história de Capitu e Bentinho, dois jovens apaixonados que enfrentam diversos obstáculos para viver seu amor.", livro.getResumo());
        Assertions.assertEquals("1. Capítulo 1\n2. Capítulo 2\n3. Capítulo 3", livro.getSumario());
        Assertions.assertEquals(29.9, livro.getPreco());
        Assertions.assertEquals(256, livro.getPaginas());
        Assertions.assertEquals("9788571640072", livro.getIsbn());
        Assertions.assertEquals(Date.valueOf(LocalDate.now().plusDays(1)), livro.getDataLancamento());
    }
}
