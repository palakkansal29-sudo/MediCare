package model;

public class Patient extends Person {

    private String disease;

    public Patient(int id, String name, int age,
                   String gender, String phone,
                   String disease) {

        super(id, name, age, gender, phone);
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id +
               "\nName: " + name +
               "\nAge: " + age +
               "\nGender: " + gender +
               "\nPhone: " + phone +
               "\nDisease: " + disease;
    }
}
