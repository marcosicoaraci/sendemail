package br.com.viasoft.sendemail.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EmailResponseDTO {

    @Schema(description = "Tipo de integração do e-mail", example = "AWS")
    private String tipoIntegracao;

}
