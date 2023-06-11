package br.com.fiapsoat.core.domain.valueobjects.email;

import lombok.Getter;

@Getter
public class Email {

    private final String email;

    public Email(String email){
        this.email = email;
        validate(email);
    }

    private void validate(String email){

    }

}
