package service;

import model.Appointment;
import model.Doctor;
import model.Patient;
import Data.HospitalData;
import exception.HospitalException;

import java.util.ArrayList;

public class AppointmentService {

    // Book Appointment
    public void bookAppointment(Appointment appointment) {

        if (findAppointment(appointment.getAppointmentId()) != null) {
            throw new HospitalException("Appointment ID already exists!");
        }

        boolean patientExists = false;
        boolean doctorExists = false;

        for (Patient p : HospitalData.patients) {
            if (p.getId() == appointment.getPatientId()) {
                patientExists = true;
                break;
            }
        }

        for (Doctor d : HospitalData.doctors) {
            if (d.getDoctorId() == appointment.getDoctorId()) {
                doctorExists = true;
                break;
            }
        }

        if (!patientExists || !doctorExists) {
            throw new HospitalException("Invalid Patient ID or Doctor ID!");
        }

        HospitalData.appointments.add(appointment);
        System.out.println("Appointment booked successfully!");
    }

    // Get All Appointments
    public ArrayList<Appointment> getAllAppointments() {
        return HospitalData.appointments;
    }

    // Find Appointment
    public Appointment findAppointment(int id) {

        for (Appointment a : HospitalData.appointments) {
            if (a.getAppointmentId() == id) {
                return a;
            }
        }

        return null;
    }

    // Search by Patient ID
    public ArrayList<Appointment> searchByPatientId(int patientId) {

        ArrayList<Appointment> result = new ArrayList<>();

        for (Appointment a : HospitalData.appointments) {
            if (a.getPatientId() == patientId) {
                result.add(a);
            }
        }

        return result;
    }

    // Cancel Appointment
    public void cancelAppointment(int id) {

        Appointment appointment = findAppointment(id);

        if (appointment == null) {
            throw new HospitalException("Appointment not found!");
        }

        appointment.setStatus("Cancelled");
        System.out.println("Appointment cancelled!");
    }
}