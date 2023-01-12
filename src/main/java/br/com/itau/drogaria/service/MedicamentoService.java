package br.com.itau.drogaria.service;

import br.com.itau.drogaria.adapter.MedicamentoAdapter;
import br.com.itau.drogaria.controller.request.MedicamentoRequest;
import br.com.itau.drogaria.controller.response.MedicamentoResponse;
import br.com.itau.drogaria.repository.MedicamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;
    private final MedicamentoAdapter medicamentoAdapter;

    public List<MedicamentoResponse> listAll() {
        return medicamentoRepository.findAll()
                .stream()
                .map(medicamentoAdapter::toMedicamentoResponse)
                .collect(Collectors.toList());
    }

    public List<MedicamentoResponse> findByTag(String tag) {
        var toolResponseList = listAll();
        return toolResponseList.stream()
                .filter(toolResponse -> toolResponse.getTags().stream().anyMatch(toolTag -> toolTag.equals(tag)))
                .collect(Collectors.toList());
    }

    public MedicamentoResponse save(MedicamentoRequest medicamentoRequest) {
        var tool = medicamentoAdapter.toMedicamento(medicamentoRequest);
        return medicamentoAdapter.toMedicamentoResponse(medicamentoRepository.save(tool));
    }

    public void delete(Long id) {
        var tool = medicamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ferramenta não encotrada"));
        medicamentoRepository.delete(tool);
    }
}
