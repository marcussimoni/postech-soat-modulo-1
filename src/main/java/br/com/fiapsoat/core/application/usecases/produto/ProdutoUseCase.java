package br.com.fiapsoat.core.application.usecases.produto;

import br.com.fiapsoat.adapters.dto.ProdutoDTO;
import br.com.fiapsoat.core.domain.entities.enums.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoUseCase {
    Page<ProdutoDTO> listar(Categoria categoria, Pageable page);
    ProdutoDTO salvar(ProdutoDTO produto);
}
