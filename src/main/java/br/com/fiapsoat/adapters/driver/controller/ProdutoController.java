package br.com.fiapsoat.adapters.driver.controller;

import br.com.fiapsoat.adapters.dto.ProdutoDTO;
import br.com.fiapsoat.core.application.usecases.produto.ProdutoUseCase;
import br.com.fiapsoat.core.domain.entities.enums.Categoria;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("produto")
@Tag(name = "Produto", description = "Gerencia os produtos disponíveis")
public class ProdutoController {

    private final ProdutoUseCase produtoUseCase;

    @GetMapping
    @Operation(tags = "Produto", description = "Lista todos os produtos disponíveis")
    public Page<ProdutoDTO> listar(
            @RequestParam(name = "categoria", required = false) Categoria categoria,
            Pageable page){
        return produtoUseCase.listar(categoria, page);
    }

    @PostMapping
    @Operation(tags = "Produto", description = "Cadastra um novo produto")
    public ProdutoDTO salvar(@RequestBody ProdutoDTO produto) {
        return produtoUseCase.salvar(produto);
    }

}
