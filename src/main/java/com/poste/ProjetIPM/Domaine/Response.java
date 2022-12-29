package com.poste.ProjetIPM.Domaine;

public class Response {
    public String message;

    public Response(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response() {
        super();
    }
}
