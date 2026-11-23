package model;

public class Doctor {

    private int doctorId;
    private String name;
    private String specialization;
    private String phone;
    private double consultationFee;

    public Doctor(int doctorId, String name, String specialization,
                  String phone, double consultationFee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
        this.consultationFee = consultationFee;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getPhone() {
        return phone;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + doctorId +
               ", Name: " + name +
               ", Specialization: " + specialization +
               ", Phone: " + phone +
               ", Consultation Fee: " + consultationFee;
    }
}
