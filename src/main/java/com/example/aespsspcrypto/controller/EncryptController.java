package com.example.aespsspcrypto.controller;

import com.example.aespsspcrypto.dto.CardEncryptDto;
import com.example.aespsspcrypto.dto.EncryptDto;
import com.example.aespsspcrypto.dto.ResponseEncryptDto;
import com.example.aespsspcrypto.utility.Encrypt;
import com.example.aespsspcrypto.utility.Validation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Author: Mobolaji Ake
 * Property of Nigeria Interbank Settlement Systems
 * Use for AES AfriGO Encyption as a Service
 */

@Controller
@RequestMapping("/encrypt")
@Slf4j
public class EncryptController {

    @PostMapping(value="/card")
    public ResponseEntity<CardEncryptDto> cardEncrypt(@RequestBody CardEncryptDto cardEncryptDto) {

        try{

            CardEncryptDto response = new CardEncryptDto();
            Validation.validateCardDto(cardEncryptDto);
            log.info(cardEncryptDto.getPan());
            log.info(Encrypt.encrypt(cardEncryptDto.getCvv(),cardEncryptDto.getKey().getBytes()));
            response.setCvv(Encrypt.encrypt(cardEncryptDto.getCvv(),cardEncryptDto.getKey().getBytes()));
            response.setPan(Encrypt.encrypt(cardEncryptDto.getPan(),cardEncryptDto.getKey().getBytes()));
            response.setExpiry(Encrypt.encrypt(cardEncryptDto.getExpiry(),cardEncryptDto.getKey().getBytes()));
            response.setPin(Encrypt.encrypt(cardEncryptDto.getPin().concat(cardEncryptDto.getPan()),cardEncryptDto.getKey().getBytes()));
            return ResponseEntity.ok().body(response);

        }catch (Exception e) {
            return ResponseEntity.badRequest().body(new CardEncryptDto());
        }

    }

    @PostMapping(value="/any")
    public ResponseEntity<ResponseEncryptDto> cardEncrypt(@RequestBody EncryptDto encryptDto) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        ResponseEncryptDto response = new ResponseEncryptDto();
        Validation.validateEncryptDto(encryptDto);
        response.setEncryptedValue(Encrypt.encrypt(encryptDto.getMessage(),encryptDto.getKey().getBytes()));
        return ResponseEntity.ok(response);
    }

}
