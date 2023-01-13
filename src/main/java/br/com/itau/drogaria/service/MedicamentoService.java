package br.com.itau.drogaria.service;

import br.com.itau.drogaria.adapter.MedicamentoAdapter;
import br.com.itau.drogaria.controller.request.MedicamentoRequest;
import br.com.itau.drogaria.controller.response.MedicamentoResponse;
import br.com.itau.drogaria.model.Medicamento;
import br.com.itau.drogaria.repository.MedicamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Medicamento findById(Long id) {
        Optional<Medicamento> medicamento = medicamentoRepository.findById(id);
        return medicamento.get();
    }

    public Medicamento update (Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public MedicamentoResponse save(MedicamentoRequest medicamentoRequest) {
        var medicamento = medicamentoAdapter.toMedicamento(medicamentoRequest);
        return medicamentoAdapter.toMedicamentoResponse(medicamentoRepository.save(medicamento));
    }

    public void delete(Long id) {
        medicamentoRepository.deleteById(id);
    }
}
