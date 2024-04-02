package cinema.domain.dto;

import cinema.domain.Seat;

public class PurchaseDTOIn {
    private int row;
    private int column;

    public PurchaseDTOIn(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public PurchaseDTOIn() {

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }


    public static SeatDTOOut mapToDTO(Seat seat) {
        return new SeatDTOOut(seat.getRow(), seat.getColumn(), seat.getPrice());
    }
}
