package br.com.drogaria.adapter;

import br.com.drogaria.controller.request.MedicamentoRequest;
import br.com.drogaria.model.Medicamento;
import br.com.drogaria.controller.response.MedicamentoResponse;
import org.springframework.stereotype.Component;

@Component
public class MedicamentoAdapter {

    public Medicamento toMedicamento(MedicamentoRequest medicamentoRequest) {
        return Medicamento.builder()
                .nome(medicamentoRequest.getNome())
                .fabricante(medicamentoRequest.getFabricante())
                .quantidade(medicamentoRequest.getQuantidade())
                .preco(medicamentoRequest.getPreco())
                .build();
    }

    public MedicamentoResponse tomedicamentoResponse(Medicamento medicamento) {
        return MedicamentoResponse.builder()
                .id(medicamento.getId())
                .nome(medicamento.getNome())
                .fabricante(medicamento.getFabricante())
                .quantidade(medicamento.getQuantidade())
                .preco(medicamento.getPreco())
                .build();
    }
}