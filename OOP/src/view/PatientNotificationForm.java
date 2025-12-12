package view;

import controller.AppointmentController;
import model.Appointment;

import javax.swing.*;
import java.awt.*;

public class PatientNotificationForm extends JFrame {

    public PatientNotificationForm(AppointmentController controller) {

        setTitle("Patient Notifications");
        setSize(400, 300);
        setLayout(new BorderLayout());


        JTextArea area = new JTextArea();
        area.setEditable(false);

        for (Appointment a : controller.getAllAppointments()) {
            area.append(
                    "Dear " + a.getPatientName() +
                            ", your appointment with " + a.getDoctorName() +
                            " on " + a.getDate() +
                            " is " + a.getStatus() + ".\n\n"
            );
        }

        add(new JScrollPane(area), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
