package view;

import controller.AppointmentController;
import model.Appointment;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class MonthlyReportForm extends JFrame {

    public MonthlyReportForm(AppointmentController controller) {

        setTitle("Monthly Report");
        setSize(400, 300);
        setLayout(new BorderLayout());

        JTextArea report = new JTextArea();
        report.setEditable(false);


        int total = controller.getAllAppointments().size();
        report.append("Total Appointments: " + total + "\n\n");

        HashMap<String, Integer> doctorCount = new HashMap<>();
        for (Appointment a : controller.getAllAppointments()) {
            doctorCount.put(
                    a.getDoctorName(),
                    doctorCount.getOrDefault(a.getDoctorName(), 0) + 1
            );
        }

        report.append("Doctor Performance:\n");
        for (String d : doctorCount.keySet()) {
            report.append(d + " : " + doctorCount.get(d) + " appointments\n");
        }

        add(new JScrollPane(report), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
