package tech.ada.javatestproject.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class LivroDTO {

    private Long id;

    @NotBlank(message = "Título do Livro não pode ser vazio.")
    private String titulo;

    @NotBlank(message = "Resumo do Livro não pode ser vazio.")
    @Size(max = 500, message = "Número de caracteres do resumo excedeu o limite permitido.")
    private String resumo;

    private String sumario;

    @NotNull(message = "Preço do Livro não pode ser vazio.")
    @DecimalMin(value = "20.00", message = "Preço mínimo do Livro deve ser de 20 reais.")
    private Double preco;

    @NotNull(message = "O número de páginas do Livro não pode ser vazio.")
    @Min(value = 100, message = "Número de páginas minimas são 100")
    private Integer paginas;

    @NotBlank(message = "O ISBN do Livro não pode ser vazio.")
    private String isbn;

    @Future(message = "A data de lançamento do Livro deve ser no futuro.")
    private Date dataLancamento;
}

