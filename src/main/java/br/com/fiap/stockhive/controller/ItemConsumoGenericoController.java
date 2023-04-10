package br.com.fiap.stockhive.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.fiap.stockhive.entity.ItemConsumoGenerico;
import br.com.fiap.stockhive.service.ItemConsumoGenericoService;
import lombok.RequiredArgsConstructor;


@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/itemConsumoGenerico")
public class ItemConsumoGenericoController {

    private final ItemConsumoGenericoService itemConsumoGenericoService;

    @GetMapping
    public List<ItemConsumoGenerico> findAll() {
        return itemConsumoGenericoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemConsumoGenerico> findById(@PathVariable Integer id) {
        Optional<ItemConsumoGenerico> item = Optional.of(itemConsumoGenericoService.findById(id));
        return item.isPresent() ? ResponseEntity.ok(item.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ItemConsumoGenerico> create(@RequestBody ItemConsumoGenerico item) {
        ItemConsumoGenerico savedItem = itemConsumoGenericoService.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemConsumoGenerico> update(@PathVariable Integer id, @RequestBody ItemConsumoGenerico item) {
        item.setItemConsumoGenericoId(id);
        ItemConsumoGenerico updatedItem = itemConsumoGenericoService.update(item);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        itemConsumoGenericoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}