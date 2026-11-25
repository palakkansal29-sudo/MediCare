package service;

public class HospitalStatistics {

    public void displayStatistics() {

        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        AppointmentService appointmentService =
                new AppointmentService();

        long totalPatients =
                patientService.getAllPatients().size();

        long totalDoctors =
                doctorService.getAllDoctors().size();

        long totalAppointments =
                appointmentService.getAllAppointments()
                .stream()
                .filter(a ->
                    a.getStatus().equalsIgnoreCase("Booked"))
                .count();

        System.out.println("\n===== HOSPITAL STATISTICS =====");

        System.out.println("Total Patients: " + totalPatients);
        System.out.println("Total Doctors: " + totalDoctors);
        System.out.println("Active Appointments: " + totalAppointments);
    }
}