package br.com.fiapsoat.adapters.driver.controller;

import br.com.fiapsoat.adapters.dto.PedidoDTO;
import br.com.fiapsoat.adapters.dto.ProdutoDTO;
import br.com.fiapsoat.core.application.usecases.pedido.PedidoUseCase;
import br.com.fiapsoat.core.application.usecases.produto.ProdutoUseCase;
import br.com.fiapsoat.core.domain.entities.enums.Categoria;
import br.com.fiapsoat.core.domain.entities.enums.EtapaDoPedido;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("pedido")
@Tag(name = "Pedido", description = "Gerencia os pedidos disponíveis")
public class PedidoController {

    private final PedidoUseCase pedidoUseCase;

    @GetMapping
    @Operation(tags = "Pedido", summary = "Lista todos os pedidos disponíveis.", description = "Lista todos os pedidos disponíveis.")
    public List<PedidoDTO> listar(){
        return pedidoUseCase.listar();
    }

    @PutMapping(path = "/proxima-etapa/{pedido}")
    @Operation(tags = "Pedido", summary = "Atualiza etapa do pedido para próxima etapa disponível", description = "As etapas são atualizadas de: RECEBIDO para EM PREPARACAO para PRONTO e FINALIZADO")
    public PedidoDTO atualizaParaEmPreparacao(@PathVariable Long pedido){
        return pedidoUseCase.atualizaParaAProximaEtapaDoPedido(pedido);
    }

}
