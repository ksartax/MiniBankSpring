package spring.logic;

/**
 * Created by Damian Stępniak on 02.04.2017.
 */
public class RequestStatus<T> {

    private String status;
    private String code;
    private T optionalObject;
    private String optionalMessages;

    public RequestStatus(String status, String code) {
        this.status = status;
        this.code = code;
    }

    public RequestStatus(String status, String code, T optionalObject) {
        this.status = status;
        this.code = code;
        this.optionalObject = optionalObject;
    }

    public RequestStatus(String status, String code, T optionalObject, String optionalMessages) {
        this.status = status;
        this.code = code;
        this.optionalObject = optionalObject;
        this.optionalMessages = optionalMessages;
    }

    public String getOptionalMessages() {
        return optionalMessages;
    }

    public void setOptionalMessages(String optionalMessages) {
        this.optionalMessages = optionalMessages;
    }

    public T getOptionalObject() {
        return optionalObject;
    }

    public void setOptionalObject(T optionalObject) {
        this.optionalObject = optionalObject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
