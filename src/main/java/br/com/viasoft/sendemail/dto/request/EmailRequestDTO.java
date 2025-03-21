package br.com.viasoft.sendemail.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EmailRequestDTO {

    @Schema(type = "string", example = "marcos.roberto.icoaraci@gmail.com")
    private String emailRemetente;
    @Schema(type = "string", example = "djmarcos_roberto@hotmail.com")
    private String emailDestinatario;
    @Schema(type = "string", example = "Marcos Roberto Lopes Chagas")
    private String nomeDestinatario;
    @Schema(type = "string", example = "Teste de envio de email")
    private String assunto;
    @Schema(type = "string", example = "Envio de conteúdo para o destino")
    private String conteudo;

}
