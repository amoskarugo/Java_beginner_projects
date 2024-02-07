import java.util.Date;

public class Billing {
    private  double price_per_unit;
    private double discount;

    public void setPrice_per_unit() {
        this.price_per_unit = 1.8;
    }

    public double getPrice_per_unit() {
        return price_per_unit;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
