package br.com.fiap.stockhive.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.stockhive.entity.ItemConsumo;
import br.com.fiap.stockhive.service.ItemConsumoService;
import lombok.RequiredArgsConstructor;


@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/itemConsumo")
public class ItemConsumoController {

    private final ItemConsumoService itemConsumoService;

    @GetMapping
    public ResponseEntity<List<ItemConsumo>> findAll() {
        List<ItemConsumo> itemConsumoList = itemConsumoService.findAll();
        return ResponseEntity.ok(itemConsumoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemConsumo> findById(@PathVariable Integer id) {
        ItemConsumo itemConsumo = itemConsumoService.findById(id);
        if (itemConsumo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(itemConsumo);
    }

    @PostMapping
    public ResponseEntity<ItemConsumo> create(@RequestBody ItemConsumo itemConsumo) {
        ItemConsumo savedItemConsumo = itemConsumoService.save(itemConsumo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItemConsumo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemConsumo> update(@PathVariable Integer id, @RequestBody ItemConsumo itemConsumo) {
        ItemConsumo itemConsumoToUpdate = itemConsumoService.findById(id);
        if (itemConsumoToUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        itemConsumo.setItemConsumoId(id);
        ItemConsumo updatedItemConsumo = itemConsumoService.save(itemConsumo);
        return ResponseEntity.ok(updatedItemConsumo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        ItemConsumo itemConsumoToDelete = itemConsumoService.findById(id);
        if (itemConsumoToDelete == null) {
            return ResponseEntity.notFound().build();
        }
        itemConsumoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

