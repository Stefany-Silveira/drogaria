package br.com.itau.drogaria.drogaria.controller;

import br.com.itau.drogaria.drogaria.controller.request.MedicamentoRequest;
import br.com.itau.drogaria.drogaria.controller.response.MedicamentoResponse;
import br.com.itau.drogaria.drogaria.repository.MedicamentoRepository;
import br.com.itau.drogaria.drogaria.model.Medicamento;
import br.com.itau.drogaria.drogaria.service.MedicamentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicamentos")
@RequiredArgsConstructor
@Api(value="API REST Medicamentos")
@CrossOrigin(origins="*")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;
    private final MedicamentoRepository medicamentoRepository;

    @GetMapping
    @ApiOperation(value="Retornar uma lista de medicamentos")
    public ResponseEntity<List<MedicamentoResponse>> listAll() {
        return ResponseEntity.ok(medicamentoService.listAll());
    }

    @GetMapping(path="/{id}")
    @ApiOperation(value="Retornar medicamento por id")
    public ResponseEntity<Medicamento> findById(@PathVariable Long id){
        Medicamento medicamento = medicamentoService.findById(id);
        return ResponseEntity.ok().body(medicamento);
    }

    @PostMapping
    @ApiOperation(value="Inserir um novo medicamento")
    public ResponseEntity<MedicamentoResponse> save(@RequestBody MedicamentoRequest medicamentoRequest) {
        return new ResponseEntity<>(medicamentoService.save(medicamentoRequest), HttpStatus.CREATED);
    }

    @PutMapping(path="/{id}")
    @ApiOperation(value="Atualizar um medicamento")
    public ResponseEntity<MedicamentoResponse> update(@RequestBody MedicamentoRequest medicamento) {
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoService.save(medicamento));
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value="Deletar um medicamento")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        medicamentoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
