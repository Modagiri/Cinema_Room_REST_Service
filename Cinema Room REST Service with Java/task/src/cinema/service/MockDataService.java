package cinema.service;

import cinema.domain.Seat;
import cinema.domain.Theatre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockDataService {

    public static Theatre mockSeatInformation() {
        int rows = 9;
        int columns = 9;
        Seat[][] seats = generateSeats(rows, columns);

        return new Theatre(rows, columns, seats);
    }

    private static Seat[][] generateSeats(int rows, int columns) {
        Seat[][] seats = new Seat[rows][columns];
        for (int r = 1; r <= rows; r++) {
            int price = r <= 4 ? 10 : 8;
            for (int c = 1; c <= columns; c++) {
                seats[r-1][c-1] = new Seat(r, c, price, true);
            }
        }

        return seats;
    }
}
