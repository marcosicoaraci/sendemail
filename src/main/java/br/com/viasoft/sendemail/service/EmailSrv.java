package br.com.viasoft.sendemail.service;

import br.com.viasoft.sendemail.dto.EmailAwsDTO;
import br.com.viasoft.sendemail.dto.EmailOciDTO;
import br.com.viasoft.sendemail.dto.request.EmailRequestDTO;
import br.com.viasoft.sendemail.dto.response.EmailResponseDTO;
import br.com.viasoft.sendemail.enuns.MailIntegracao;
import br.com.viasoft.sendemail.estrategia.EstrategiaEmailResponse;
import br.com.viasoft.sendemail.exceptions.ObjetoNaoEncontradoException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSrv {

    @Value("${mail.integracao}")
    private String mailIntegracao;
    private final JavaMailSender mailSender;

    public EmailSrv(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public EmailResponseDTO enviarEmail(EmailRequestDTO emailRequestDTO) throws MessagingException {
        EmailResponseDTO emailResponseDTO= null;
        EstrategiaEmailResponse estrategiaEmailResponse = new EstrategiaEmailResponse();
        emailResponseDTO = estrategiaEmailResponse.preencherDados(emailRequestDTO,this.mailIntegracao);

        if (emailResponseDTO == null) {
            throw new ObjetoNaoEncontradoException("Erro ao enviar email: ");
        }else{
            if (emailResponseDTO.getTipoIntegracao().equals(MailIntegracao.AWS.chave())) {
                EmailAwsDTO emailAwsDTO = (EmailAwsDTO) emailResponseDTO;
                this.sendEmail(emailAwsDTO.getRecipient(),emailAwsDTO.getSubject(),emailAwsDTO.getContent());
            }else if (emailResponseDTO.getTipoIntegracao().equals(MailIntegracao.OCI.chave())){
                EmailOciDTO emailOciDTO = (EmailOciDTO) emailResponseDTO;
                this.sendEmail(emailOciDTO.getRecipientEmail(),emailOciDTO.getSubject(),emailOciDTO.getBody());
            }
            return emailResponseDTO;
        }
    }

    private void sendEmail(String para, String assunto, String corpo) throws MessagingException {
        MimeMessage mensagem = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensagem, true);

        helper.setTo(para);
        helper.setSubject(assunto);
        helper.setText(corpo, true);

        mailSender.send(mensagem);
    }

}
