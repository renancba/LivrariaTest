package tech.ada.javatestproject.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.javatestproject.model.Livro;
import tech.ada.javatestproject.model.LivroDTO;
import tech.ada.javatestproject.repository.LivroRepository;
import tech.ada.javatestproject.utils.LivroMapper;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository repository;

    @Autowired
    LivroMapper mapper;

    public List<LivroDTO> listar() {
        return mapper.updateListLivroEntity(repository.findAll());
    }

    public LivroDTO getById(Long id) {
        Optional<Livro> editoraOptional = repository.findById(id);
        if (editoraOptional.isPresent()) {
            return mapper.updateLivro(editoraOptional.get());
        }
        throw new EntityNotFoundException("Livro não encontrado.");
    }

    public LivroDTO criar(LivroDTO livroDTO) {
        Livro LivroSave = repository.save(mapper.updateLivro(livroDTO));
        return mapper.updateLivro(LivroSave);
    }

    public void deletar(Long id){
        Optional<Livro> editoraOptional = repository.findById(id);
        if (editoraOptional.isPresent()) {
            repository.deleteById(id);
        }
        throw new EntityNotFoundException("Livro não encontrado.");
    }

    public LivroDTO editar(LivroDTO livroDTO, Long id){
        if (repository.existsById(id)){
            Livro livro = mapper.updateLivro(livroDTO);
            livro.setId(livroDTO.getId());
            return mapper.updateLivro(repository.save(livro));
        }
        throw new EntityNotFoundException("Livro não encontrado.");
    }
}
