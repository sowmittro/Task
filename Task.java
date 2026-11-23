import java.time.LocalDate;

interface Schedulable {
    String getNextAppointment();
}

interface Billable {
    void issueInvoice(String recipientName);
}

interface Referrable {
    void referPatient(String specialistName, String reason);
}

abstract class MedicalRecord implements Schedulable, Billable {
    private String recordID;
    private String patientName;
    private String doctorAssigned;
    private int admissionYear;
    private double treatmentCost;

    MedicalRecord(String recordID, String patientName, String doctorAssigned, int admissionYear, double treatmentCost){
        this.recordID = recordID;
        this.patientName = patientName;
        this.doctorAssigned = doctorAssigned;
        this.admissionYear = admissionYear;
        this.treatmentCost = treatmentCost;
    }

    public String getRecordID() {
        return recordID;
    }
    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorAssigned() {
        return doctorAssigned;
    }
    public void setDoctorAssigned(String doctorAssigned) {
        this.doctorAssigned = doctorAssigned;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }
    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    public double getTreatmentCost() {
        return treatmentCost;
    }
    public void setTreatmentCost(double treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    abstract double calculateBill();
    double calculateBill(double coveragePercentage) {
        return treatmentCost - (treatmentCost * coveragePercentage / 100);
    }
  
    String getNextAppointment() {
        int currentYear = LocalDate.now().getYear();
        int yearsAgo = currentYear - admissionYear;

        if(yearsAgo == 0){
            return "Immediate";
        }
        else if(yearsAgo >= 1 && yearsAgo <= 2) {
            return "Within 6 months";
        }
        else {
            return "Routine checkup";
        }
    }

    void issueInvoice(String recipientName) {
        System.out.println("Invoice Recipient: " + recipientName);
        System.out.printf("Treatment Cost: ", treatmentCost);
    }
}

abstract class SpecialistRecord extends MedicalRecord implements Referrable {
    private int maxReferrals;
    SpecialistRecord(String recordID, String patientName, String doctorAssigned, int admissionYear, double treatmentCost, int maxReferrals){
        super(recordID, patientName, doctorAssigned, admissionYear, treatmentCost);
        this.maxReferrals = maxReferrals;
    }

    public int getMaxReferrals() {
        return maxReferrals;
    }
    public void setMaxReferrals(int maxReferrals) {
        this.maxReferrals = maxReferrals;
    }
}

class GeneralConsultation extends MedicalRecord {
    private String symptoms;
    private int consultationDurationMinutes;

    GeneralConsultation(String recordID, String patientName, String doctorAssigned, int admissionYear, double treatmentCost, String symptoms, int consultationDurationMinutes){
        super(recordID, patientName, doctorAssigned, admissionYear, treatmentCost);
        this.symptoms = symptoms;
        this.consultationDurationMinutes = consultationDurationMinutes;
    }

    public String getSymptoms() {
        return symptoms;
    }
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public int getConsultationDurationMinutes() {
        return consultationDurationMinutes;
    }
    public void setConsultationDurationMinutes(int minutes) {
        this.consultationDurationMinutes = minutes;
    }
  
    public double calculateBill() {
        return getTreatmentCost() * 0.90;
    }
}

class SurgeryRecord extends SpecialistRecord {
    private String surgeryType;

    SurgeryRecord(String recordID, String patientName, String doctorAssigned, int admissionYear, double treatmentCost, int maxReferrals, String surgeryType) {
        super(recordID, patientName, doctorAssigned, admissionYear, treatmentCost, maxReferrals);
        this.surgeryType = surgeryType;
    }

    public String getSurgeryType() {
        return surgeryType;
    }
    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public double calculateBill() {
        return getTreatmentCost() * 0.70;
    }

    void referPatient(String specialistName, String reason) {
    
    }
}

public class Main {
    public static void main(String[] args) {
        GeneralConsultation general = new GeneralConsultation("MR001", "Rahim Ahmed", "Dr. Karim", 2026, 5000.00, "Fever and Headache", 30);
        SurgeryRecord surgery = new SurgeryRecord("MR002", "Abdul Rahman", "Dr. Hasan", 2024, 50000.00, 2, "Appendix Surgery");

        System.out.println("GENERAL CONSULTATION:");
        System.out.println("Next Appointment: " + general.getNextAppointment());
        general.issueInvoice("Rahim Ahmed");
        System.out.printf("Bill after 10% discount: ", general.calculateBill());
        System.out.printf("Bill after 20% insurance coverage: ", general.calculateBill(20));
    }
  }
