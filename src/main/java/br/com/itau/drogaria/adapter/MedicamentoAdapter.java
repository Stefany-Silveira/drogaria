package br.com.itau.drogaria.adapter;

import br.com.itau.drogaria.controller.request.MedicamentoRequest;
import br.com.itau.drogaria.controller.response.MedicamentoResponse;
import br.com.itau.drogaria.model.Medicamento;
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

    public MedicamentoResponse toMedicamentoResponse(Medicamento medicamento) {
        return MedicamentoResponse.builder()
                .id(medicamento.getId())
                .nome(medicamento.getNome())
                .fabricante(medicamento.getFabricante())
                .quantidade(medicamento.getQuantidade())
                .preco(medicamento.getPreco())
                .build();
    }
}
