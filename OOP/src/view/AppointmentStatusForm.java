package view;

import controller.AppointmentController;
import model.Appointment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AppointmentStatusForm extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private JComboBox<String> cmbStatus;

    private AppointmentController controller;

    public AppointmentStatusForm(AppointmentController controller) {

        this.controller = controller;

        setTitle("Track Appointment Status");
        setSize(700, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // -------- Table --------
        model = new DefaultTableModel(
                new String[]{"ID", "Patient", "Doctor", "Date", "Time", "Status"}, 0
        );
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        loadAppointments();

        // -------- Bottom Panel --------
        JPanel bottom = new JPanel();

        cmbStatus = new JComboBox<>(new String[]{
                "Scheduled", "Completed", "Cancelled", "Delayed"
        });
        JButton btnUpdate = new JButton("Update Status");
        JButton btnBack = new JButton("Back");


        bottom.add(new JLabel("Status:"));
        bottom.add(cmbStatus);
        bottom.add(btnUpdate);
        bottom.add(btnBack);

        add(bottom, BorderLayout.SOUTH);

        // -------- Action --------
        btnUpdate.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                String status = cmbStatus.getSelectedItem().toString();
                controller.getAllAppointments().get(row).setStatus(status);
                model.setValueAt(status, row, 5);
            }
        });
        btnBack.addActionListener(e -> dispose());

    }

    private void loadAppointments() {
        model.setRowCount(0);
        for (Appointment a : controller.getAllAppointments()) {
            model.addRow(new Object[]{
                    a.getAppointmentId(),
                    a.getPatientName(),
                    a.getDoctorName(),
                    a.getDate(),
                    a.getTime(),
                    a.getStatus()
            });
        }
    }
}

