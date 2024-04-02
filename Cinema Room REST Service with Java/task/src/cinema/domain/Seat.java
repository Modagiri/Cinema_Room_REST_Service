package cinema.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {
    int row;
    int column;
    int price;
    @JsonIgnore
    boolean vacant;

    public Seat(int row, int column, int price, boolean vacant) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.vacant = vacant;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setVacant(boolean vacant) {
        this.vacant = vacant;
    }

    public boolean getVacant() {
        return vacant;
    }
}
