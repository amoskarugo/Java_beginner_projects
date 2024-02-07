public class Customer {


    private long meter_number;
    private final double usage;

    private double arrears;
    private double BillOverpaid;

    private double currentMeterReading;
    private double priorMeterReading;

    public Billing billing;

    public Customer(long meter_number,
                    double arrears,
                    double currentMeterReading, double priorMeterReading) {

        this.meter_number = meter_number;
        this.arrears = arrears;
        this.currentMeterReading = currentMeterReading;
        this.priorMeterReading = priorMeterReading;
        this.usage = this.currentMeterReading - this.priorMeterReading;
        this.BillOverpaid = this.arrears > 0 ? this.arrears : 0;

    }

    public long getMeterNumber() {
        return this.meter_number;
    }

    public void setMeterNumber(long meter_number) {
        this.meter_number = meter_number;
    }

    public double getUsage() {
        return this.usage;
    }

    public double getArrears() {
        return arrears;
    }

    public void setArrears(double arrears) {
        this.arrears = arrears;
    }

    public long getMeter_number() {
        return meter_number;
    }

    public void setMeter_number(long meter_number) {
        this.meter_number = meter_number;
    }

    public double getCurrentMeterReading() {
        return currentMeterReading;
    }

    public void setCurrentMeterReading(double currentMeterReading) {
        this.currentMeterReading = currentMeterReading;
    }

    public double getPriorMeterReading() {
        return priorMeterReading;
    }

    public void setPriorMeterReading(double priorMeterReading) {
        this.priorMeterReading = priorMeterReading;
    }

    public double getBillOverpaid() {
        return BillOverpaid;
    }

    public void setBillOverpaid(double billOverpaid) {
        BillOverpaid = billOverpaid;
    }

    public double totalBill(Billing billing){
        return (billing.getPrice_per_unit() * this.getUsage());
    }

    public void payBill(int amount){
        double accrued = this.totalBill(billing);

        if (this.getArrears() < 0){

        }
    }
}
