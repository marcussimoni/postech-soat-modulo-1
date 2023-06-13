package br.com.fiapsoat.adapters.dto;

import lombok.Data;

import java.util.List;

@Data
public class CheckoutPedidoDTO {

    private String cliente;
    private List<ProdutoDTO> produtos;

}
