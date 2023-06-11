package br.com.fiapsoat.adapters.driven.repositories;

import br.com.fiapsoat.core.domain.entities.pedido.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}
