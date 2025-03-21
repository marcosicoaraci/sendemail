package br.com.viasoft.sendemail;

import br.com.viasoft.sendemail.dto.request.EmailRequestDTO;
import br.com.viasoft.sendemail.dto.response.EmailResponseDTO;
import br.com.viasoft.sendemail.estrategia.EstrategiaEmailResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EstrategiaEmailResponseTest {

    @InjectMocks
    private EstrategiaEmailResponse emailResponse;

    private String tipoIntegracaoAWS = "AWS";
    private String tipoIntegracaoOCI = "OCI";
    private String tipoIntegracaoXXX = "XXX";

    @Test
    public void preencherDadosTestAWS(){
        EmailRequestDTO emailRequestDTO = this.obterDadosRequest();

        EmailResponseDTO responseDTO = this.emailResponse.preencherDados(emailRequestDTO,this.tipoIntegracaoAWS);

        assertNotNull(responseDTO);
        assertEquals(responseDTO.getTipoIntegracao(),this.tipoIntegracaoAWS);
    }

    @Test
    public void preencherDadosTestOCI(){
        EmailRequestDTO emailRequestDTO = this.obterDadosRequest();

        EmailResponseDTO responseDTO = this.emailResponse.preencherDados(emailRequestDTO,this.tipoIntegracaoOCI);

        assertNotNull(responseDTO);
        assertEquals(responseDTO.getTipoIntegracao(),this.tipoIntegracaoOCI);
    }

    @Test
    public void preencherDadosTestNull(){
        EmailRequestDTO emailRequestDTO = this.obterDadosRequest();

        EmailResponseDTO responseDTO = this.emailResponse.preencherDados(emailRequestDTO,this.tipoIntegracaoXXX);

        assertNull(responseDTO);

    }

    private EmailRequestDTO obterDadosRequest(){
        EmailRequestDTO emailRequestDTO = new EmailRequestDTO();
        emailRequestDTO.setEmailRemetente("marcos.roberto.icoaraci@gmail.com");
        emailRequestDTO.setEmailDestinatario("djmarcos_roberto@hotmail.com");
        emailRequestDTO.setNomeDestinatario("Marcos Roberto");
        emailRequestDTO.setAssunto("Teste de envio de email");
        emailRequestDTO.setConteudo("Teste de envio de email");

        return emailRequestDTO;

    }
}


