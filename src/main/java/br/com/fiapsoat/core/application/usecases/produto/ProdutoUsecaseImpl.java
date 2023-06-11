package br.com.fiapsoat.core.application.usecases.produto;

import br.com.fiapsoat.adapters.driven.repositories.ProdutoRepository;
import br.com.fiapsoat.core.domain.entities.enums.Categoria;
import br.com.fiapsoat.core.domain.entities.produto.Produto;
import br.com.fiapsoat.core.domain.mappers.ProdutoMapper;
import br.com.fiapsoat.adapters.dto.ProdutoDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoUsecaseImpl implements ProdutoUseCase {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    @Override
    public Page<ProdutoDTO> listar(Categoria categoria, Pageable pageable) {
        return repository.findByCategoria(categoria, pageable);
    }

    @Override
    @Transactional
    public ProdutoDTO salvar(ProdutoDTO produto) {

        Produto entity = mapper.dtoToEntity(produto);

        repository.save(entity);

        return produto;

    }
}
