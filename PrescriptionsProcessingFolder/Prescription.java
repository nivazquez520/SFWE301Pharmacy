package PrescriptionsProcessingFolder;

public class Prescription {
    private final int prescriptionId;
    private final String patientName;
    private final String medication;
    private final String dosage;
    private final String instructions;
    
    public Prescription(int prescriptionId, String patientName, String medication, String dosage, String instructions) {
        this.prescriptionId = prescriptionId;
        this.patientName = patientName;
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
    }

    public int getPrescriptionId() {
        return this.prescriptionId;
    }

    public String getPatientName() {
        return this.patientName;
    }

    public String getMedication() {
        return this.medication;
    }

    public String getDosage() {
        return this.dosage;
    }

    public String getInstructions() {
        return this.instructions;
    }

    @Override
    public String toString() {
        String str = "Prescription ID: " + this.prescriptionId + ", Patient: " + this.patientName;
        str += ", Medication: " + this.medication + ", Dosage: " + this.dosage + ", Instructions: ";
        str += this.instructions;
        return str;
    }
}