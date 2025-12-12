package view;

import controller.AppointmentController;
import model.Appointment;

import javax.swing.*;
import java.awt.*;

public class DoctorNotificationForm extends JFrame {

    public DoctorNotificationForm(AppointmentController controller) {

        setTitle("Doctor Notifications");
        setSize(400, 300);
        setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setEditable(false);

        for (Appointment a : controller.getAllAppointments()) {
            area.append(
                    "Doctor " + a.getDoctorName() +
                            ", you have an appointment with " +
                            a.getPatientName() +
                            " on " + a.getDate() +
                            " at " + a.getTime() +
                            " (Status: " + a.getStatus() + ")\n\n"
            );
        }


        add(new JScrollPane(area), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
