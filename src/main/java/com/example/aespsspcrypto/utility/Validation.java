package com.example.aespsspcrypto.utility;

import com.example.aespsspcrypto.dto.CardEncryptDto;
import com.example.aespsspcrypto.dto.EncryptDto;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Mobolaji Ake
 * Property of Nigeria Interbank Settlement Systems
 * Use for AES AfriGO Encyption as a Service
 */

@Slf4j
public class Validation {

    public static void validateCardDto(CardEncryptDto cardEncryptDto){

        if (cardEncryptDto.getExpiry().isEmpty() || cardEncryptDto.getPin().isEmpty()
                ||cardEncryptDto.getKey().isEmpty() ||cardEncryptDto.getPan().isEmpty()){

            log.info("One of the parameters is invalid");

            throw new IllegalArgumentException();

        }

    }

    public static void validateEncryptDto(EncryptDto EncryptDto){

        if (EncryptDto.getMessage().isEmpty() || EncryptDto.getKey().isEmpty()){

            log.info("One of the EncryptDto parameters is invalid");

            throw new IllegalArgumentException();

        }

    }
}
