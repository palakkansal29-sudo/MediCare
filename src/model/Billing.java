
package model;

public class Billing {

    private int billId;
    private int patientId;
    private int appointmentId;
    private double amount;
    private String paymentStatus;

    public Billing(int billId, int patientId,
                   int appointmentId, double amount) {

        this.billId = billId;
        this.patientId = patientId;
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.paymentStatus = "Pending";
    }

    public int getBillId() {
        return billId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String status) {
        this.paymentStatus = status;
    }

    @Override
    public String toString() {
        return "Bill ID: " + billId +
               "\nPatient ID: " + patientId +
               "\nAppointment ID: " + appointmentId +
               "\nAmount: " + amount +
               "\nPayment Status: " + paymentStatus;
    }
}
