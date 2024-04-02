package cinema.domain.dto;

import cinema.domain.Seat;

public class RefundDTOOut {
    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }

    Seat ticket;

    public RefundDTOOut(Seat ticket) {
        this.ticket = ticket;
    }

    public RefundDTOOut() {
    }
}
