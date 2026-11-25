
package service;

import model.Patient;
import Data.HospitalData;
import exception.HospitalException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PatientService {

    // Add Patient
    public void addPatient(Patient patient) {

        if (patient == null ||
            patient.getId() <= 0 ||
            patient.getName() == null ||
            patient.getName().trim().isEmpty() ||
            patient.getAge() <= 0) {

            throw new HospitalException("Invalid patient details!");
        }

        if (searchPatient(patient.getId()) != null) {
            throw new HospitalException("Patient ID already exists!");
        }

        HospitalData.patients.add(patient);

        System.out.println("Patient added successfully!");
    }

    // Get All Patients
    public ArrayList<Patient> getAllPatients() {
        return HospitalData.patients;
    }

    // Search Patient
    public Patient searchPatient(int id) {

        for (Patient p : HospitalData.patients) {

            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    // Update Patient
    public void updatePatient(Patient updatedPatient) {

        if (updatedPatient == null) {
            throw new HospitalException("Invalid patient details!");
        }

        Patient old = searchPatient(updatedPatient.getId());

        if (old == null) {
            throw new HospitalException("Patient not found!");
        }

        old.setName(updatedPatient.getName());
        old.setAge(updatedPatient.getAge());
        old.setGender(updatedPatient.getGender());
        old.setPhone(updatedPatient.getPhone());
        old.setDisease(updatedPatient.getDisease());

        System.out.println("Patient updated successfully!");
    }

    // Delete Patient
    public void deletePatient(int id) {

        Patient patient = searchPatient(id);

        if (patient == null) {
            throw new HospitalException("Patient not found!");
        }

        HospitalData.patients.remove(patient);

        System.out.println("Patient deleted successfully!");
    }

    // Search By Disease
    public List<Patient> searchByDisease(String disease) {

        List<Patient> result = new ArrayList<>();

        for (Patient p : HospitalData.patients) {

            if (p.getDisease() != null &&
                p.getDisease().equalsIgnoreCase(disease)) {

                result.add(p);
            }
        }

        return result;
    }

    // Sort Patients By Name
    public List<Patient> sortPatientsByName() {

        List<Patient> result =
                new ArrayList<>(HospitalData.patients);

        result.sort(
            Comparator.comparing(
                Patient::getName,
                String.CASE_INSENSITIVE_ORDER
            )
        );

        return result;
    }
}
