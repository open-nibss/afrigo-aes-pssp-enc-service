package com.example.aespsspcrypto.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Mobolaji Ake
 * Property of Nigeria Interbank Settlement Systems
 * Use for AES AfriGO Encyption as a Service
 */

@Getter
@Setter
public class CardEncryptDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String key;
    private String cvv;
    private String pan;
    private String expiry;
    private String pin;

}
