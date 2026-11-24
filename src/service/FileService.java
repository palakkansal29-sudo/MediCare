
package service;

import model.Patient;
import Data.HospitalData;

import java.io.*;

public class FileService {

    public void savePatients() {

        try (BufferedWriter writer =
                new BufferedWriter(
                    new FileWriter("patients.txt"))) {

            for (Patient p : HospitalData.patients) {

                writer.write(
                    p.getId() + "|" +
                    p.getName() + "|" +
                    p.getAge() + "|" +
                    p.getGender() + "|" +
                    p.getPhone() + "|" +
                    p.getDisease()
                );

                writer.newLine();
            }

            System.out.println("Patient records saved!");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    public void readPatients() {

        try (BufferedReader reader =
                new BufferedReader(
                    new FileReader("patients.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
