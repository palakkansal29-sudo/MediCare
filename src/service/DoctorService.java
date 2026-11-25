package service;

import model.Doctor;
import Data.HospitalData;
import exception.HospitalException;

import java.util.ArrayList;

public class DoctorService {

    public void addDoctor(Doctor doctor) {

        if (doctor.getDoctorId() <= 0 ||
            doctor.getConsultationFee() < 0) {
            throw new HospitalException("Invalid doctor details!");
        }

        if (searchDoctor(doctor.getDoctorId()) != null) {
            throw new HospitalException("Doctor ID already exists!");
        }

        HospitalData.doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }

    public ArrayList<Doctor> getAllDoctors() {
        return HospitalData.doctors;
    }

    public Doctor searchDoctor(int id) {

        for (Doctor d : HospitalData.doctors) {
            if (d.getDoctorId() == id) {
                return d;
            }
        }

        return null;
    }

    public void updateDoctor(Doctor updatedDoctor) {

        Doctor old = searchDoctor(updatedDoctor.getDoctorId());

        if (old == null) {
            throw new HospitalException("Doctor not found!");
        }

        old.setName(updatedDoctor.getName());
        old.setSpecialization(updatedDoctor.getSpecialization());
        old.setPhone(updatedDoctor.getPhone());
        old.setConsultationFee(updatedDoctor.getConsultationFee());

        System.out.println("Doctor updated successfully!");
    }

    public void deleteDoctor(int id) {

        Doctor doctor = searchDoctor(id);

        if (doctor == null) {
            throw new HospitalException("Doctor not found!");
        }

        HospitalData.doctors.remove(doctor);
        System.out.println("Doctor deleted successfully!");
    }
}