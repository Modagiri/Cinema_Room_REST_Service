package cinema.domain.dto;

public class Stats {
    int income;
    int available;
    int purchased;


    public Stats(int income, int avalaible, int purchased) {
        this.income = income;
        this.available = avalaible;
        this.purchased = purchased;
    }

    public Stats() {
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getPurchased() {
        return purchased;
    }

    public void setPurchased(int purchased) {
        this.purchased = purchased;
    }
}
