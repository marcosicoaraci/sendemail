package br.com.viasoft.sendemail.estrategia;

import br.com.viasoft.sendemail.dto.EmailAwsDTO;
import br.com.viasoft.sendemail.dto.EmailOciDTO;
import br.com.viasoft.sendemail.dto.request.EmailRequestDTO;
import br.com.viasoft.sendemail.dto.response.EmailResponseDTO;
import br.com.viasoft.sendemail.enuns.MailIntegracao;

public class EstrategiaEmailResponse {

    public EmailResponseDTO preencherDados(EmailRequestDTO emailRequestDTO,String tipoIntegracao){
        EmailResponseDTO responseDTO;
        if (tipoIntegracao.equals(MailIntegracao.AWS.chave())) {
            EmailAwsDTO emailAwsDTO = new EmailAwsDTO();
            emailAwsDTO.setRecipient(emailRequestDTO.getEmailDestinatario());
            emailAwsDTO.setRecipientName(emailRequestDTO.getNomeDestinatario());
            emailAwsDTO.setSender(emailRequestDTO.getEmailRemetente());
            emailAwsDTO.setSubject(emailRequestDTO.getAssunto());
            emailAwsDTO.setContent(emailRequestDTO.getConteudo());
            emailAwsDTO.setTipoIntegracao(MailIntegracao.AWS.chave());
            responseDTO = emailAwsDTO;
        }else if (tipoIntegracao.equals(MailIntegracao.OCI.chave())){
            EmailOciDTO ociDTO = new EmailOciDTO();
            ociDTO.setRecipientEmail(emailRequestDTO.getEmailDestinatario());
            ociDTO.setRecipientName(emailRequestDTO.getNomeDestinatario());
            ociDTO.setSenderEmail(emailRequestDTO.getEmailRemetente());
            ociDTO.setSubject(emailRequestDTO.getAssunto());
            ociDTO.setBody(emailRequestDTO.getConteudo());
            ociDTO.setTipoIntegracao(MailIntegracao.OCI.chave());
            responseDTO = ociDTO;
        }else{
            return null;
        }
        return responseDTO;
    }

}
