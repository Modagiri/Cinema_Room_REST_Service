package cinema.domain.dto;

public class SeatDTOOut {
    private int row;
    private int col;
    private int price;

    public SeatDTOOut(int row, int col, int price) {
        this.row = row;
        this.col = col;
        this.price = price;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
