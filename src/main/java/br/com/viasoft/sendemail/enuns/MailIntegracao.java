package br.com.viasoft.sendemail.enuns;

public enum MailIntegracao {
    AWS("AWS"),
    OCI("OCI");

    private final String descricao;

    MailIntegracao(String descricao) {
        this.descricao = descricao;
    }

    public String chave(){
        return this.descricao;
    }
}
