package br.com.viasoft.sendemail.rest;

import br.com.viasoft.sendemail.dto.request.EmailRequestDTO;
import br.com.viasoft.sendemail.dto.response.EmailResponseDTO;
import br.com.viasoft.sendemail.exceptions.ExceptionResponse;
import br.com.viasoft.sendemail.service.EmailSrv;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Tag(name = "Email", description = "Envio de e-mail")
@RequestMapping(value = "/email", produces = "application/json")
public class EmailRest {

    private final EmailSrv emailSrv;

    @PostMapping(path = "/enviar",produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    @Operation(summary = "Enviar Email", description = "Realiza o envio do email ",tags = {"Email"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso",
                    content = {@Content(mediaType = MimeTypeUtils.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EmailResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Objeto Não Encontrado",
                    content = {@Content(mediaType = MimeTypeUtils.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ExceptionResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = {@Content(mediaType = MimeTypeUtils.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ExceptionResponse.class))})
    })
    public ResponseEntity<EmailResponseDTO> post(@RequestBody EmailRequestDTO emailRequestDTO) throws MessagingException {
        EmailResponseDTO emailResponseDTO = emailSrv.enviarEmail(emailRequestDTO);

        return new ResponseEntity<>(emailResponseDTO, HttpStatus.OK);
    }

}
