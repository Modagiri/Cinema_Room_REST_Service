package cinema.domain;

import cinema.exception.SeatDoesNotExistException;
import cinema.exception.SeatNotVacantException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Theatre {
    int rows;
    int columns;
    Seat[][] seats;

    public Theatre(int rows, int columns, Seat[][] seats) {
        this.rows = rows;
        this.columns = columns;
        this.seats = seats;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<Seat> getSeats() {
        List<Seat> seatList = new ArrayList<>();
        List<List<Seat>> tmp = Arrays.stream(seats).map(Arrays::asList).collect(Collectors.toList());
        tmp.forEach(seats1 -> seatList.addAll(seats1));

        return seatList;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public Seat getSeat(int row, int col) {
        if(row < 1 || row > rows || col < 1 || col > columns) {
            throw new SeatDoesNotExistException("The number of a row or a column is out of bounds!");
        }

        Seat s = seats[row-1][col-1];
        if(!s.vacant) {
            throw new SeatNotVacantException("The ticket has been already purchased!");
        }

        return s;
    }
}
