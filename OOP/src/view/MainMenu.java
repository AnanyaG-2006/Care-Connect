package view;

import controller.AppointmentController;
import controller.DoctorController;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    DoctorController doctorController = new DoctorController();
    AppointmentController appointmentController = new AppointmentController();

    public MainMenu() {


        setTitle("MediCare Plus System");
        setSize(350, 400);
        setLayout(new GridLayout(9, 1));

        addButton("Manage Patients", () -> new PatientManagementForm().setVisible(true));
        addButton("Manage Doctors", () -> new DoctorManagementForm().setVisible(true));
        addButton("Schedule Appointments", () -> new AppointmentForm().setVisible(true));
        addButton("Track Appointment Status",
                () -> new AppointmentStatusForm(appointmentController).setVisible(true));
        addButton("Assign Doctor",
                () -> new DoctorAssignmentForm(doctorController).setVisible(true));
        addButton("Monthly Report",
                () -> new MonthlyReportForm(appointmentController).setVisible(true));
        addButton("Patient Notifications",
                () -> new PatientNotificationForm(appointmentController).setVisible(true));
        addButton("Doctor Notifications",
                () -> new DoctorNotificationForm(appointmentController).setVisible(true));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private void addButton(String title, Runnable action) {
        JButton btn = new JButton(title);
        btn.addActionListener(e -> action.run());
        add(btn);
    }
}
