package cinema.domain.dto;

public class RefundDTOIn {
    String token;

    public RefundDTOIn(String token) {
        this.token = token;
    }

    public RefundDTOIn() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
