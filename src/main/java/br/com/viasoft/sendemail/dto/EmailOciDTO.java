package br.com.viasoft.sendemail.dto;

import br.com.viasoft.sendemail.dto.response.EmailResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EmailOciDTO extends EmailResponseDTO {

    @Schema(type = "string", example = "djmarcos_roberto@hotmail.com")
    private String recipientEmail;
    @Schema(type = "string", example = "Marcos Roberto Lopes Chagas")
    private String recipientName;
    @Schema(type = "string", example = "marcos.roberto.icoaraci@gmail.com")
    private String senderEmail;
    @Schema(type = "string", example = "Teste de envio de email")
    private String subject;
    @Schema(type = "string", example = "Envio de conteúdo para o destino")
    private String body;

}
