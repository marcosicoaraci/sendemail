package br.com.viasoft.sendemail.exceptions;

public abstract class AbstractSendEmailApiExceptions extends RuntimeException{

    private final String[] args;

    public AbstractSendEmailApiExceptions(String mensagem) {
        super(mensagem);
        this.args = null;
    }

    public AbstractSendEmailApiExceptions(String message, String[] args) {
        super(message);
        this.args = args;
    }

    public AbstractSendEmailApiExceptions(String message, Throwable cause) {
        super(message, cause);
        this.args = null;
    }

    public AbstractSendEmailApiExceptions(String message, Throwable cause, String[] args) {
        super(message, cause);
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }
}
