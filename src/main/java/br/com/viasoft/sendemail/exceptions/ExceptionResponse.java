package br.com.viasoft.sendemail.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class ExceptionResponse {
    @Schema(type = "string", format = "date", example = "1990-05-15")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date timestamp;
    @Schema(type = "string", example = "Houve um erro ")
    private String mensagem;
    @Schema(type = "string", example = "Detalhe do erro ")
    private String detalhes;
    @Schema(type = "string", example = "Código http do erro, ex: 404 ou 500 ")
    private String httpCodeMessage;

}