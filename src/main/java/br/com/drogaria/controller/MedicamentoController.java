package br.com.drogaria.controller;

import br.com.drogaria.controller.request.MedicamentoRequest;
import br.com.drogaria.controller.response.MedicamentoResponse;
import br.com.drogaria.model.Medicamento;
import br.com.drogaria.service.MedicamentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
@RequiredArgsConstructor
@Api(value="API REST Medicamentos")
@CrossOrigin(origins="*")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    @GetMapping
    @ApiOperation(value = "Retornar uma lista de medicamentos")
    public ResponseEntity<List<MedicamentoResponse>> listAll() {
        return ResponseEntity.ok(medicamentoService.listAll());
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Retornar um medicamento por id")
    public ResponseEntity<Medicamento> findById(@PathVariable Long id) {
        Medicamento medicamento = medicamentoService.findById(id);
        return ResponseEntity.ok().body(medicamento);
    }

    @PostMapping
    @ApiOperation(value = "Inserir um medicamento")
    public ResponseEntity<MedicamentoResponse> save(@RequestBody MedicamentoRequest medicamentoRequest) {
        return new ResponseEntity<>(medicamentoService.save(medicamentoRequest), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "Atualizar um medicamento")
    public ResponseEntity<Medicamento> update(@RequestBody Medicamento medicamento) {
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoService.update(medicamento));
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deletar um medicamento")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        medicamentoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
