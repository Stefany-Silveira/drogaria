package br.com.itau.drogaria.controller.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MedicamentoRequest {

    private String nome;
    private String fabricante;
    private int quantidade;
    private BigDecimal preco;

}
