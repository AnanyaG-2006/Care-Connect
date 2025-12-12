package controller;

import model.Appointment;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class AppointmentController {

    private ArrayList<Appointment> appointmentList = new ArrayList<>();

    // Add appointment and send notifications
    public void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);

        // Get details from appointment
        String patientName = appointment.getPatientName();
        String doctorName = appointment.getDoctorName();
        String date = appointment.getDate();
        String time = appointment.getTime();

        // Confirmation message
        JOptionPane.showMessageDialog(null,
                "Appointment booked successfully!\nPatient: " + patientName +
                        "\nDoctor: " + doctorName + "\nDate: " + date + " " + time,
                "Appointment Confirmation",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Notify Doctor
        JOptionPane.showMessageDialog(null,
                "New Appointment Alert!\nPatient: " + patientName +
                        "\nDate: " + date + " " + time,
                "Doctor Notification",
                JOptionPane.INFORMATION_MESSAGE
        );


        // Notify Patient
        JOptionPane.showMessageDialog(null,
                "Your appointment is confirmed with Dr. " + doctorName +
                        "\nDate: " + date + " " + time,
                "Patient Notification",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void deleteAppointment(int index) {
        appointmentList.remove(index);
    }

    public ArrayList<Appointment> getAllAppointments() {
        return appointmentList;
    }
}


