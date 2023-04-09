package br.com.fiap.stockhive.controller;

import br.com.fiap.stockhive.entity.Fornecedor;
import br.com.fiap.stockhive.service.FornecedorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/fornecedor")
public class FornecedorController {

    private final FornecedorService service;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> findAll() {
        List<Fornecedor> fornecedores = service.findAll();
        return ResponseEntity.ok(fornecedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Integer id) {
        Optional<Fornecedor> optionalFornecedor = service.findById(id);
        if (optionalFornecedor.isPresent()) {
            Fornecedor fornecedor = optionalFornecedor.get();
            return ResponseEntity.ok(fornecedor);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Fornecedor> save(@RequestBody Fornecedor fornecedor) {
        Fornecedor newFornecedor = service.save(fornecedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Integer id, @RequestBody Fornecedor fornecedor) {
        Fornecedor updatedFornecedor = service.update(id, fornecedor);
        if (updatedFornecedor != null) {
            return ResponseEntity.ok(updatedFornecedor);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
