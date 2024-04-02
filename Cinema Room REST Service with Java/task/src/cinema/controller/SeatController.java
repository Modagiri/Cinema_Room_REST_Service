package cinema.controller;

import cinema.domain.Seat;
import cinema.domain.Theatre;
import cinema.domain.Ticket;
import cinema.domain.dto.*;
import cinema.exception.WrongPasswordException;
import cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class SeatController {

    @Autowired
    SeatService seatService;

    @GetMapping("/seats")
    public Theatre getSeats() {
        return seatService.getSeatOverview();
    }

    @PostMapping("/purchase")
    public PurchaseDTOOut purchaseTicket(@RequestBody PurchaseDTOIn dtoIn) {
        return seatService.purchaseSeat(dtoIn.getRow(), dtoIn.getColumn());
    }

    @PostMapping("/return")
    public RefundDTOOut refundTicket(@RequestBody RefundDTOIn refund) {
        return seatService.refundTicket(refund.getToken());
    }

    @GetMapping("/stats")
    public Stats getStats(@RequestParam(value = "password", required = false) String password) {
        if(password == null || !password.equals("super_secret")) {
            throw new WrongPasswordException("The password is wrong!");
        }

        return seatService.getStats();
    }
}
