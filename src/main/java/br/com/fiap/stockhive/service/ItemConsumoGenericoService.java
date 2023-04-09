package br.com.fiap.stockhive.service;

import br.com.fiap.stockhive.entity.ItemConsumoGenerico;
import br.com.fiap.stockhive.repository.ItemConsumoGenericoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemConsumoGenericoService {

    private final ItemConsumoGenericoRepository itemConsumoGenericoRepository;

    public List<ItemConsumoGenerico> findAll() {
        return itemConsumoGenericoRepository.findAll();
    }

    public ItemConsumoGenerico findById(Integer id) {
        return itemConsumoGenericoRepository.findById(id).orElse(null);
    }

    public ItemConsumoGenerico save(ItemConsumoGenerico itemConsumoGenerico) {
        return itemConsumoGenericoRepository.save(itemConsumoGenerico);
    }

    public void deleteById(Integer id) {
        itemConsumoGenericoRepository.deleteById(id);
    }

    public ItemConsumoGenerico update(ItemConsumoGenerico itemConsumoGenerico) {
        return itemConsumoGenericoRepository.save(itemConsumoGenerico);
    }
}
