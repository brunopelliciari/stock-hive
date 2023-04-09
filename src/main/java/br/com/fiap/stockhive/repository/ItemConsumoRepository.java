package br.com.fiap.stockhive.repository;

import br.com.fiap.stockhive.entity.ItemConsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemConsumoRepository extends JpaRepository<ItemConsumo, Integer> {
    List<ItemConsumo> findByItemConsumoId (Integer id);
}

