package br.com.itau.drogaria.util;

import br.com.itau.drogaria.drogaria.controller.response.MedicamentoResponse;
import br.com.itau.drogaria.drogaria.model.Medicamento;

import java.math.BigDecimal;

public class MedicamentoBuilder {

    public static Medicamento medicamentoBuild() {

        return Medicamento.builder()
                .id(1L)
                .nome("Dipirona")
                .fabricante("Prati")
                .quantidade(3)
                .preco(BigDecimal.valueOf(2.25))
                .build();
    }

    public static MedicamentoResponse toolResponseBuild() {
        return MedicamentoResponse.builder()
                .id(1L)
                .nome("Dipirona")
                .fabricante("Prati")
                .quantidade(3)
                .preco(BigDecimal.valueOf(2.25))
                .build();
    }
}
