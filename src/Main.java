
import model.*;
import service.*;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static PatientService patientService = new PatientService();
    static DoctorService doctorService = new DoctorService();
    static AppointmentService appointmentService =
            new AppointmentService();
    static BillingService billingService = new BillingService();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Billing Management");
            System.out.println("5. Hospital Statistics");
            System.out.println("6. Export Patient Records");
            System.out.println("7. Create Patient Backup");
            System.out.println("8. Notification Demo");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    patientMenu();
                    break;
                case 2:
                    doctorMenu();
                    break;
                case 3:
                    appointmentMenu();
                    break;
                case 4:
                    billingMenu();
                    break;
                case 5:
                    HospitalStatistics.displayStatistics(
                            patientService, doctorService,
                            appointmentService);
                    break;
                case 6:
                    new PatientFileService(
                            patientService).exportPatients();
                    break;
                case 7:
                    HospitalBackup.createBackup();
                    break;
                case 8:
                    NotificationDemo.startDemo();
                    break;
                case 9:
                    System.out.println("Thank you for using HMS!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 9);
    }

    static void patientMenu() {

        System.out.println("\n--- PATIENT MANAGEMENT ---");
        System.out.println("1. Add Patient");
        System.out.println("2. View Patients");
        System.out.println("3. Search Patient");
        System.out.println("4. Update Patient");
        System.out.println("5. Delete Patient");
        System.out.println("6. Search by Disease");
        System.out.println("7. Sort Patients");

        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch) {

            case 1: {
                System.out.print("Patient ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Gender: ");
                String gender = sc.nextLine();

                System.out.print("Phone: ");
                String phone = sc.nextLine();

                System.out.print("Disease: ");
                String disease = sc.nextLine();

                Patient p = new Patient(
                        id, name, age, gender, phone, disease);

                System.out.println(
                        patientService.addPatient(p)
                        ? "Patient Added!"
                        : "Failed!");
                break;
            }

            case 2:
                patientService.viewPatients();
                break;

            case 3: {
                System.out.print("Patient ID: ");
                Patient p = patientService.searchPatient(sc.nextInt());

                System.out.println(p == null
                        ? "Patient not found!"
                        : p);
                break;
            }

            case 4: {
                System.out.print("Patient ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("New Name: ");
                String name = sc.nextLine();

                System.out.print("New Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("New Gender: ");
                String gender = sc.nextLine();

                System.out.print("New Phone: ");
                String phone = sc.nextLine();

                System.out.print("New Disease: ");
                String disease = sc.nextLine();

                Patient p = new Patient(
                        id, name, age, gender, phone, disease);

                System.out.println(
                        patientService.updatePatient(p)
                        ? "Updated!"
                        : "Update failed!");
                break;
            }

            case 5:
                System.out.print("Patient ID: ");
                System.out.println(
                        patientService.deletePatient(sc.nextInt())
                        ? "Deleted!"
                        : "Failed!");
                break;

            case 6: {
                System.out.print("Disease: ");
                String disease = sc.nextLine();

                patientService.searchByDisease(disease)
                        .forEach(System.out::println);
                break;
            }

            case 7:
                patientService.sortPatientsByName()
                        .forEach(System.out::println);
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }

    static void doctorMenu() {

        System.out.println("\n--- DOCTOR MANAGEMENT ---");
        System.out.println("1. Add Doctor");
        System.out.println("2. View Doctors");
        System.out.println("3. Search Doctor");
        System.out.println("4. Update Doctor");
        System.out.println("5. Delete Doctor");

        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch) {

            case 1: {
                System.out.print("Doctor ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Specialization: ");
                String spec = sc.nextLine();

                System.out.print("Phone: ");
                String phone = sc.nextLine();

                System.out.print("Consultation Fee: ");
                double fee = sc.nextDouble();

                Doctor d = new Doctor(id, name, spec, phone, fee);

                System.out.println(
                        doctorService.addDoctor(d)
                        ? "Doctor Added!"
                        : "Failed!");
                break;
            }

            case 2:
                doctorService.viewAllDoctors();
                break;

            case 3: {
                System.out.print("Doctor ID: ");
                Doctor d = doctorService.searchDoctor(sc.nextInt());

                System.out.println(d == null
                        ? "Doctor not found!"
                        : d);
                break;
            }

            case 4: {
                System.out.print("Doctor ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("New Name: ");
                String name = sc.nextLine();

                System.out.print("New Specialization: ");
                String spec = sc.nextLine();

                System.out.print("New Phone: ");
                String phone = sc.nextLine();

                System.out.print("New Fee: ");
                double fee = sc.nextDouble();

                Doctor d = new Doctor(id, name, spec, phone, fee);

                System.out.println(
                        doctorService.updateDoctor(d)
                        ? "Updated!"
                        : "Failed!");
                break;
            }

            case 5:
                System.out.print("Doctor ID: ");
                System.out.println(
                        doctorService.deleteDoctor(sc.nextInt())
                        ? "Deleted!"
                        : "Failed!");
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }

    static void appointmentMenu() {

        System.out.println("\n--- APPOINTMENT MANAGEMENT ---");
        System.out.println("1. Book Appointment");
        System.out.println("2. View Appointments");
        System.out.println("3. Search by Patient ID");
        System.out.println("4. Cancel Appointment");

        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch) {

            case 1: {
                System.out.print("Appointment ID: ");
                int aid = sc.nextInt();

                System.out.print("Patient ID: ");
                int pid = sc.nextInt();

                System.out.print("Doctor ID: ");
                int did = sc.nextInt();
                sc.nextLine();

                System.out.print("Date: ");
                String date = sc.nextLine();

                System.out.print("Time: ");
                String time = sc.nextLine();

                Appointment a = new Appointment(
                        aid, pid, did, date, time);

                System.out.println(
                        appointmentService.bookAppointment(a)
                        ? "Appointment Booked!"
                        : "Booking Failed!");
                break;
            }

            case 2:
                appointmentService.viewAllAppointments();
                break;

            case 3: {
                System.out.print("Patient ID: ");
                appointmentService.searchByPatientId(sc.nextInt())
                        .forEach(System.out::println);
                break;
            }

            case 4:
                System.out.print("Appointment ID: ");
                System.out.println(
                        appointmentService.cancelAppointment(
                                sc.nextInt())
                        ? "Cancelled!"
                        : "Failed!");
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }

    static void billingMenu() {

        System.out.println("\n--- BILLING MANAGEMENT ---");
        System.out.println("1. Generate Bill");
        System.out.println("2. View Bills");
        System.out.println("3. Search Bill");
        System.out.println("4. Pay Bill");
        System.out.println("5. Delete Bill");

        int ch = sc.nextInt();

        switch (ch) {

            case 1: {
                System.out.print("Bill ID: ");
                int bid = sc.nextInt();

                System.out.print("Patient ID: ");
                int pid = sc.nextInt();

                System.out.print("Appointment ID: ");
                int aid = sc.nextInt();

                System.out.print("Amount: ");
                double amount = sc.nextDouble();

                Billing b = new Billing(bid, pid, aid, amount);

                System.out.println(
                        billingService.generateBill(b)
                        ? "Bill Generated!"
                        : "Failed!");
                break;
            }

            case 2:
                billingService.viewAllBills();
                break;

            case 3: {
                System.out.print("Bill ID: ");
                Billing b = billingService.searchBill(sc.nextInt());

                System.out.println(b == null
                        ? "Bill not found!"
                        : b);
                break;
            }

            case 4:
                System.out.print("Bill ID: ");
                System.out.println(
                        billingService.payBill(sc.nextInt())
                        ? "Payment Successful!"
                        : "Payment Failed!");
                break;

            case 5:
                System.out.print("Bill ID: ");
                System.out.println(
                        billingService.deleteBill(sc.nextInt())
                        ? "Deleted!"
                        : "Failed!");
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
}
