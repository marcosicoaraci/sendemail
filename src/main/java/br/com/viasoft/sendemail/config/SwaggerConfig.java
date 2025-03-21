package br.com.viasoft.sendemail.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()

                .info(new Info()
                        .title("Send Email API")
                        .description("API Para envio simples de email")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Url do projeto no GitHub")
                                .url("https://github.com/marcosicoaraci/sendemail")
                                .email("marcos.roberto.icoaraci@gmail.com"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Perfil no Linkedin")
                        .url("https://www.linkedin.com/in/marcos-roberto-0741a776/"));
    }

}

