package cinema.domain.dto;

import cinema.domain.Seat;

public class PurchaseDTOOut {
    String token;
    Seat ticket;

    public PurchaseDTOOut() {
    }

    public PurchaseDTOOut(String token, Seat ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Seat getTicket() {
        return ticket;
    }
    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }

}
