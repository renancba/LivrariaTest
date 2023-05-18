package tech.ada.javatestproject.utils;

import org.springframework.stereotype.Component;
import tech.ada.javatestproject.model.Livro;
import tech.ada.javatestproject.model.LivroDTO;

import java.util.List;

@Component
public class LivroMapper {

    public Livro updateLivro(LivroDTO livro){
        Livro livroEntity = new Livro();
        livroEntity.setId(livro.getId());
        livroEntity.setTitulo(livro.getTitulo());
        livroEntity.setResumo(livro.getResumo());
        livroEntity.setSumario(livro.getSumario());
        livroEntity.setPaginas(livro.getPaginas());
        livroEntity.setIsbn(livro.getIsbn());
        livroEntity.setPreco(livro.getPreco());
        livroEntity.setDataLancamento(livro.getDataLancamento());
        return livroEntity;
    }

    public LivroDTO updateLivro(Livro livro){
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setTitulo(livro.getTitulo());
        livroDTO.setResumo(livro.getResumo());
        livroDTO.setSumario(livro.getSumario());
        livroDTO.setPaginas(livro.getPaginas());
        livroDTO.setIsbn(livro.getIsbn());
        livroDTO.setPreco(livro.getPreco());
        livroDTO.setDataLancamento(livro.getDataLancamento());
        return livroDTO;
    }

    public List<Livro> updateListLivroDTO(List<LivroDTO> livros){
        return livros.stream()
                .map(this::updateLivro)
                .toList();
    }

    public List<LivroDTO> updateListLivroEntity(List<Livro> livros){
        return livros.stream()
                .map(this::updateLivro)
                .toList();
    }

}
