package cinema.service;

import cinema.domain.Seat;
import cinema.domain.Theatre;
import cinema.domain.dto.PurchaseDTOOut;
import cinema.domain.dto.RefundDTOOut;
import cinema.domain.dto.Stats;
import cinema.exception.TokenExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SeatService {
    private Theatre theatre = MockDataService.mockSeatInformation();
    private Map<String, PurchaseDTOOut> purchaseMap = new HashMap<>();

    public Theatre getSeatOverview() {
        return theatre;
    }


    public Seat getSeat(int row, int col) {
        return theatre.getSeat(row, col);
    }

    public PurchaseDTOOut purchaseSeat(int row, int col) {
        Seat seat =  theatre.getSeat(row, col);
        seat.setVacant(false);

        String token = UUID.randomUUID().toString();
        PurchaseDTOOut out = new PurchaseDTOOut(token, seat);
        purchaseMap.put(token, out);

        return out;
    }

    public RefundDTOOut refundTicket(String token) {
        PurchaseDTOOut out = purchaseMap.get(token);
        if (out == null ) {
            throw new TokenExpiredException("Wrong token!");
        }
        out.getTicket().setVacant(true);
        purchaseMap.remove(token);
        return new RefundDTOOut(out.getTicket());
    }

    public Stats getStats() {
        int purchased = purchaseMap.size();
        int available = (theatre.getRows() * theatre.getColumns()) - purchased;
        int income = purchaseMap.values().stream().mapToInt(p -> p.getTicket().getPrice()).sum();

        return new Stats(income, available, purchased);
    }

}
