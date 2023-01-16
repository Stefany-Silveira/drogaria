package br.com.itau.drogaria.model;

import br.com.itau.drogaria.controller.request.MedicamentoRequest;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Medicamento")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento extends MedicamentoRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String fabricante;
    private int quantidade;
    private BigDecimal preco;

}
