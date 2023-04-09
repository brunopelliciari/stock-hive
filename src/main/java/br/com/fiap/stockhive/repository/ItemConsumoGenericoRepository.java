package br.com.fiap.stockhive.repository;

import br.com.fiap.stockhive.entity.ItemConsumoGenerico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemConsumoGenericoRepository extends JpaRepository<ItemConsumoGenerico, Integer> {
    List<ItemConsumoGenerico> findByItemConsumoGenericoId(String cpf);
}
