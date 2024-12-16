package PrescriptionsProcessingFolder;
import java.io.*;
import java.util.*;

public class PrescriptionsProcessing {
    List<Prescription> prescriptions;

    public PrescriptionsProcessing() {
        this.prescriptions = new ArrayList<>();
    }

    public void loadPrescriptions(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                String patientName = values[1];
                String medication = values[2];
                String dosage = values[3];
                String instructions = values[4];
                this.prescriptions.add(new Prescription(id, patientName, medication, dosage, instructions));
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public int size() {
        return this.prescriptions.size();
    }

    public void add (int id, String patientName, String medication, String dosage, String instructions) {
        this.prescriptions.add(new Prescription(id, patientName, medication, dosage, instructions));
    }

    public void remove(int id, String patientName) {
        int index = -1;
        for (int i = 0; i < this.prescriptions.size(); i++) {
            Prescription element = this.prescriptions.get(i);
            if (element.getPrescriptionId() == id && element.getPatientName().equals(patientName)) {
                index = i;
            }
        }
        this.prescriptions.remove(index);
    }

    public void displayPrescriptions() {
        if (this.prescriptions.isEmpty()) {
            System.out.println("No prescriptions found.");
        } else {
            for (Prescription p : prescriptions) {
                System.out.println(p);
            }
        }
    }
}
