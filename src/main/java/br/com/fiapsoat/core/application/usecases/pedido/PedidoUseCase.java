package br.com.fiapsoat.core.application.usecases.pedido;

import br.com.fiapsoat.adapters.dto.PedidoDTO;

public interface PedidoUseCase {
    PedidoDTO buscarPedidoPorId(Long id);
}
