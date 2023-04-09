package br.com.fiap.stockhive.service;

import br.com.fiap.stockhive.entity.Fornecedor;
import br.com.fiap.stockhive.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FornecedorService {

    private final FornecedorRepository repository;

    public List<Fornecedor> findAll() {
        return repository.findAll();
    }

    public Optional<Fornecedor> findById(Integer id) {
        return repository.findById(id);
    }

    public Fornecedor save(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public Fornecedor update(Integer id, Fornecedor fornecedor) {
        Optional<Fornecedor> optionalFornecedor = repository.findById(id);
        if (optionalFornecedor.isPresent()) {
            fornecedor.setFornecedorId(id);
            return repository.save(fornecedor);
        }
        return null;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
