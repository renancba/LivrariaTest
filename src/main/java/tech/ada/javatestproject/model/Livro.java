package tech.ada.javatestproject.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "resumo", nullable = false)
    private String resumo;

    @Column(name = "sumario")
    private String sumario;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @Column(name = "paginas", nullable = false)
    private Integer paginas;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "data")
    private Date dataLancamento;
}
