package br.com.itau.drogaria.controller.response;

import br.com.itau.drogaria.controller.request.MedicamentoRequest;
import br.com.itau.drogaria.model.Medicamento;
import br.com.itau.drogaria.service.MedicamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("medicamentos")
@RequiredArgsConstructor
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    @GetMapping
    public ResponseEntity<List<MedicamentoResponse>> listAll() {
        return ResponseEntity.ok(medicamentoService.listAll());
    }

    @GetMapping(path="/{id}")
        public ResponseEntity<Medicamento> findById(@PathVariable Long id){
        Medicamento medicamento = medicamentoService.findById(id);
        return ResponseEntity.ok().body(medicamento);
    }

    @PostMapping
    public ResponseEntity<MedicamentoResponse> save(@RequestBody MedicamentoRequest medicamentoRequest) {
        return new ResponseEntity<>(medicamentoService.save(medicamentoRequest), HttpStatus.CREATED);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Medicamento> update(@RequestBody Medicamento medicamento) {
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoService.update(medicamento));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        medicamentoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
