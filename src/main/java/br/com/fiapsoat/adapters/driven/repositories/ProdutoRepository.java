package br.com.fiapsoat.adapters.driven.repositories;

import br.com.fiapsoat.adapters.dto.ProdutoDTO;
import br.com.fiapsoat.core.domain.entities.enums.Categoria;
import br.com.fiapsoat.core.domain.entities.produto.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT NEW br.com.fiapsoat.adapters.dto.ProdutoDTO(p) FROM Produto p " +
            "WHERE (p.categoria = :categoria OR :categoria IS NULL)")
    Page<ProdutoDTO> findByCategoria(@Param("categoria") Categoria categoria, Pageable page);
}
