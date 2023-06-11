package br.com.fiapsoat.core.domain.entities.pedido;

import br.com.fiapsoat.core.domain.entities.cliente.Cliente;
import br.com.fiapsoat.core.domain.entities.enums.EtapaDoPedido;
import br.com.fiapsoat.core.domain.entities.produto.Produto;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private EtapaDoPedido etapa;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pedido_realizado_em")
    private LocalDateTime pedidoRealizadoEm;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pedido_retirado_em")
    private LocalDateTime pedidoRetirado;

    @ManyToMany
    @JoinTable(
            name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    public List<Produto> produtos;

}
