package br.com.fiapsoat.core.domain.entities.cliente;

import br.com.fiapsoat.core.domain.valueobjects.cpf.Cpf;
import br.com.fiapsoat.core.domain.valueobjects.email.Email;
import br.com.fiapsoat.core.domain.valueobjects.cpf.CpfAttributeConverter;
import br.com.fiapsoat.core.domain.valueobjects.email.EmailAttributeConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Convert(converter = CpfAttributeConverter.class)
    private Cpf cpf;

    @Convert(converter = EmailAttributeConverter.class)
    private Email email;

}
