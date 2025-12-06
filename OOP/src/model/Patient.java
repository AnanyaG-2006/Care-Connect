package model;

public class Patient {
    private String patientId;
    private String name;
    private String age;
    private String phone;
    private String medicalHistory;

    public Patient(String patientId, String name, String age,
                   String phone, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.medicalHistory = medicalHistory;
    }

    // Getters and Setters
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getMedicalHistory() { return medicalHistory; }
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}

