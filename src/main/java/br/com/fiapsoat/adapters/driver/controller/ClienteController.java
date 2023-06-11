package br.com.fiapsoat.adapters.driver.controller;

import br.com.fiapsoat.adapters.dto.ClienteDTO;
import br.com.fiapsoat.core.application.usecases.cliente.ClienteUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("cliente")
@Tag(name = "Cliente", description = "Gerencia os dados do cliente")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    @GetMapping
    @Operation(tags = "Cliente", description = "Lista todos os clientes cadastrados")
    public List<ClienteDTO> listar(){
        return clienteUseCase.listar();
    }

    @PostMapping
    @Operation(tags = "Cliente", description = "Salva um novo cliente")
    public ClienteDTO salvar(@RequestBody ClienteDTO cliente) {
        return clienteUseCase.salvar(cliente);
    }

}
