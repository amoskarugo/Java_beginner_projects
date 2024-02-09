public class Customer {

    static final double price_per_unit;
    public static double discount;
    private static  double total;
    private static final long meter_number;
    private final static double usage;

    private static double arrears;
    private static double BillOverpaid;

    private static final double currentMeterReading;
    private static final double priorMeterReading;
    static {
        arrears = 0;
        meter_number = 378346120098912L;
        currentMeterReading = 16712;
        priorMeterReading = 19324;
        BillOverpaid = 0;
        price_per_unit = 1.67;
        discount = 0.07;
        usage = priorMeterReading - currentMeterReading;
        total =  ((usage * price_per_unit) - calculateDiscount(usage));
    }

//    public Customer(long meter_number,
//                    double currentMeterReading, double priorMeterReading) {
//
//        this.meter_number = meter_number;
//        this.currentMeterReading = currentMeterReading;
//        this.priorMeterReading = priorMeterReading;
//        this.usage = this.priorMeterReading - this.currentMeterReading;
//
//    }

    public long getMeterNumber() {
        return meter_number;
    }


    public double getUsage() {
        return usage;
    }

    public double getArrears() {
        return arrears;
    }


    public long getMeter_number() {
        return meter_number;
    }

    public double getDiscount() {
        return discount;
    }

    public static double getTotal() {
        return total;
    }

    public double getCurrentMeterReading() {
        return currentMeterReading;
    }


    public double getPriorMeterReading() {
        return priorMeterReading;
    }


    public double getBillOverpaid() {
        return BillOverpaid;
    }

    public void setBillOverpaid(double billOverpaid) {
        BillOverpaid = billOverpaid;
    }


   public static double calculateDiscount(double units){
        //discount of $0.07 per unit
        return (units * 0.07);
   }
    public void payBill(int amount){
      if (arrears > 0){
          arrears -= amount;
          if (arrears < 0){
              BillOverpaid = (-1 * arrears);
              arrears = 0;
          }
      }else {
          arrears += BillOverpaid;
          total = (arrears + total) - amount;
          if (total < 0){
              BillOverpaid = (-1 * total);
          }else {
              arrears = total;
              BillOverpaid = 0;
          }
          total = 0;
      }

    }
}
