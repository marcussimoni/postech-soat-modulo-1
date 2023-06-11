package br.com.fiapsoat.core.application.usecases.pedido;

import br.com.fiapsoat.adapters.driven.repositories.PedidoRepository;
import br.com.fiapsoat.adapters.dto.PedidoDTO;
import br.com.fiapsoat.core.domain.entities.pedido.Pedido;
import br.com.fiapsoat.core.domain.entities.produto.Produto;
import br.com.fiapsoat.core.domain.exceptions.BusinessException;
import br.com.fiapsoat.core.domain.mappers.ProdutoMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PedidoUseCaseImpl implements PedidoUseCase {

    private final PedidoRepository repository;

    private final ProdutoMapper produtoMapper;

    @Override
    public PedidoDTO buscarPedidoPorId(Long id) {

        Optional<Pedido> optional = repository.findById(id);

        if (optional.isEmpty()) {
            throw BusinessException
                    .builder()
                    .erro("Pedido não encontrado")
                    .detalhes(List.of(MessageFormat.format("Pedido não encontrado para o id {0}", id)))
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }

        Pedido pedido = optional.get();

        Double total = pedido.produtos.stream().map(Produto::getPreco).reduce(0.0, Double::sum);

        Long tempoDesdeORecebimentoDoPedido = Duration.between(pedido.getPedidoRealizadoEm(), LocalDateTime.now()).toMinutes();

        return PedidoDTO
                .builder()
                .numeroDoPedido(pedido.getId())
                .pedidoRealizadoEm(pedido.getPedidoRealizadoEm())
                .pedidoRetiradoEm(pedido.getPedidoRetirado())
                .etapa(pedido.getEtapa())
                .tempoDesdeRecebimentoDoPedido(MessageFormat.format("{0} minutos", tempoDesdeORecebimentoDoPedido))
                .cliente(pedido.getCliente() == null ? "Cliente não identificado" : pedido.getCliente().getNome())
                .valorTotalDoPedido(MessageFormat.format("R$ {0}", BigDecimal.valueOf(total).setScale(2)))
                .items(produtoMapper.entityToDto(pedido.produtos))
                .build();

    }

}
