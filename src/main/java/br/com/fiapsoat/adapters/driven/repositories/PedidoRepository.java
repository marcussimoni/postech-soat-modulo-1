package br.com.fiapsoat.adapters.driven.repositories;

import br.com.fiapsoat.core.domain.entities.enums.StatusDoPagamento;
import br.com.fiapsoat.core.domain.entities.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p WHERE p.pedidoRetirado IS NULL AND p.statusDoPagamento = :statusDoPagamento ORDER BY p.pedidoRealizadoEm ASC")
    List<Pedido> buscarPedidosDisponiveis(@Param("statusDoPagamento") StatusDoPagamento statusDoPagamento);

}
