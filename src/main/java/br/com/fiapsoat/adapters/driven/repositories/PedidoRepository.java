package br.com.fiapsoat.adapters.driven.repositories;

import br.com.fiapsoat.core.domain.entities.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p WHERE p.pedidoRetirado IS NULL ORDER BY p.pedidoRealizadoEm ASC")
    List<Pedido> buscarPedidosDisponiveis();

}
