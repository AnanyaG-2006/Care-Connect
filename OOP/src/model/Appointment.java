package model;

public class Appointment {
    private String appointmentId;
    private String patientName;
    private String doctorName;
    private String date;
    private String time;
    private String status;


    public Appointment(String appointmentId, String patientName,
                       String doctorName, String date,
                       String time, String status) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    // Getters & Setters
    public String getAppointmentId() { return appointmentId; }
    public String getPatientName() { return patientName; }
    public String getDoctorName() { return doctorName; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}

