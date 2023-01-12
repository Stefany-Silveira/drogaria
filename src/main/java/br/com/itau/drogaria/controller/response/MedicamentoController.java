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

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoResponse> getById(@PathVariable Long id) {
        return MedicamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Medicamento>> buscarPorNome(@PathVariable String name){
        return ResponseEntity.ok(medicamentoService.findAllByNomeContainingIgnoreCase(name));
    }

    @PostMapping
    public ResponseEntity<MedicamentoResponse> save(@RequestBody MedicamentoRequest medicamentoRequest) {
        return new ResponseEntity<>(medicamentoService.save(medicamentoRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Medicamento> alterarProduto(@Valid @RequestBody Medicamento medicamento) {
        if(medicamentoService.existsById(medicamento.getId())) {
            return categoriaRepository.findById(medicamento.getCategoria().getId())
                    .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(medicamentoService.save(medicamento)))
                    .orElse(ResponseEntity.badRequest().build());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        medicamentoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
