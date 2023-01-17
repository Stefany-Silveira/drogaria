package br.com.itau.drogaria.drogaria.controller.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MedicamentoResponse {

    private Long id;
    private String nome;
    private String fabricante;
    private int quantidade;
    private BigDecimal preco;
}
