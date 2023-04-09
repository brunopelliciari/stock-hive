package br.com.fiap.stockhive.service;

import br.com.fiap.stockhive.entity.ItemConsumo;
import br.com.fiap.stockhive.repository.ItemConsumoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemConsumoService {

    private final ItemConsumoRepository itemConsumoRepository;

    public List<ItemConsumo> findAll() {
        return itemConsumoRepository.findAll();
    }

    public ItemConsumo findById(Integer id) {
        return itemConsumoRepository.findById(id).orElse(null);
    }

    public ItemConsumo save(ItemConsumo itemConsumo) {
        return itemConsumoRepository.save(itemConsumo);
    }

    public void deleteById(Integer id) {
        itemConsumoRepository.deleteById(id);
    }

}

