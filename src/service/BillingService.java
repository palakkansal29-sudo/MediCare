
package service;

import model.Billing;
import Data.HospitalData;
import exception.HospitalException;

public class BillingService {

    public void generateBill(Billing bill) {

        boolean appointmentExists =
                HospitalData.appointments.stream()
                .anyMatch(a ->
                    a.getAppointmentId() == bill.getAppointmentId()
                    && a.getPatientId() == bill.getPatientId()
                    && a.getStatus().equalsIgnoreCase("Booked"));

        if (!appointmentExists) {
            throw new HospitalException(
                    "Valid booked appointment not found!");
        }

        if (bill.getAmount() <= 0) {
            throw new HospitalException("Invalid bill amount!");
        }

        for (Billing b : HospitalData.bills) {
            if (b.getBillId() == bill.getBillId()) {
                throw new HospitalException("Bill ID already exists!");
            }
        }

        HospitalData.bills.add(bill);
        System.out.println("Bill generated successfully!");
    }

    public void viewAllBills() {

        if (HospitalData.bills.isEmpty()) {
            System.out.println("No bills available.");
            return;
        }

        for (Billing b : HospitalData.bills) {
            System.out.println("\n" + b);
        }
    }

    public Billing searchBill(int id) {

        for (Billing b : HospitalData.bills) {
            if (b.getBillId() == id) {
                return b;
            }
        }

        return null;
    }

    public void payBill(int id) {

        Billing bill = searchBill(id);

        if (bill == null) {
            throw new HospitalException("Bill not found!");
        }

        if (bill.getPaymentStatus().equalsIgnoreCase("Paid")) {
            throw new HospitalException("Bill is already paid!");
        }

        bill.setPaymentStatus("Paid");
        System.out.println("Payment successful!");
    }

    public void deleteBill(int id) {

        Billing bill = searchBill(id);

        if (bill == null) {
            throw new HospitalException("Bill not found!");
        }

        HospitalData.bills.remove(bill);
        System.out.println("Bill deleted successfully!");
    }
}
