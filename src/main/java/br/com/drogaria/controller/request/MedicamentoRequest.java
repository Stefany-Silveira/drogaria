package br.com.drogaria.controller.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class MedicamentoRequest {

    @ApiModelProperty(value = "Nome do medicamento")
    private String nome;
    @ApiModelProperty(value = "Nome do fabricante")
    private String fabricante;
    @ApiModelProperty(value = "Quantidade do medicamento")
    private int quantidade;
    @ApiModelProperty(value = "Preço do medicamento")
    private BigDecimal preco;
}
