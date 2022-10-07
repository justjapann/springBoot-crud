package DAO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ACCEPTED)
public class ResourceAccept extends RuntimeException {

    private static final long serialVersionUID = 1;

    private String message;

    public ResourceAccept(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}