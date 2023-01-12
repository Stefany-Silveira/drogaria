package br.com.itau.drogaria.util;

import br.com.itau.drogaria.controller.response.MedicamentoResponse;
import br.com.itau.drogaria.model.Medicamento;

import java.util.List;

public class ToolBuilder {

    public static Medicamento toolBuild() {
        return Medicamento.builder()
                .id(1L)
                .title("Google")
                .link("www.google.com")
                .description("Ferramenta de pesquisa")
                .tags(List.of("web", "navegador"))
                .build();
    }

    public static MedicamentoResponse toolResponseBuild() {
        return MedicamentoResponse.builder()
                .id(1L)
                .title("Google")
                .link("www.google.com")
                .description("Ferramenta de pesquisa")
                .tags(List.of("web", "navegador"))
                .build();
    }

}
