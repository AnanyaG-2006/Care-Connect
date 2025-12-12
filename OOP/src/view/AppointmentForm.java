package view;

import controller.AppointmentController;
import model.Appointment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AppointmentForm extends JFrame {

    private JTextField txtId, txtDate, txtTime;
    private JComboBox<String> cmbPatient, cmbDoctor;
    private JTable table;
    private DefaultTableModel model;

    private AppointmentController controller = new AppointmentController();

    public AppointmentForm() {

        setTitle("Schedule Appointments");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // ---------- Form ----------
        JPanel form = new JPanel(new GridLayout(5, 2));

        form.add(new JLabel("Appointment ID"));
        txtId = new JTextField();
        form.add(txtId);

        form.add(new JLabel("Patient"));
        cmbPatient = new JComboBox<>(new String[]{
                "Patient A", "Patient B", "Patient C"
        });
        form.add(cmbPatient);

        form.add(new JLabel("Doctor"));
        cmbDoctor = new JComboBox<>(new String[]{
                "Dr. Silva", "Dr. Perera", "Dr. Fernando"
        });
        form.add(cmbDoctor);

        form.add(new JLabel("Date"));
        txtDate = new JTextField("2025-01-01");
        form.add(txtDate);

        form.add(new JLabel("Time"));
        txtTime = new JTextField("10:00 AM");
        form.add(txtTime);

        add(form, BorderLayout.NORTH);

        // ---------- Table ----------
        model = new DefaultTableModel(
                new String[]{"ID", "Patient", "Doctor", "Date", "Time", "Status"}, 0
        );
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // ---------- Buttons ----------
        JPanel buttons = new JPanel();
        JButton btnAdd = new JButton("Schedule");
        JButton btnDelete = new JButton("Cancel");
        JButton btnBack = new JButton("Back");

        buttons.add(btnAdd);
        buttons.add(btnDelete);
        buttons.add(btnBack);

        add(buttons, BorderLayout.SOUTH);

        // ---------- Actions ----------
        btnAdd.addActionListener(e -> {
            Appointment appointment = new Appointment(
                    txtId.getText(),
                    cmbPatient.getSelectedItem().toString(),
                    cmbDoctor.getSelectedItem().toString(),
                    txtDate.getText(),
                    txtTime.getText(),
                    "Scheduled"
            );

            controller.addAppointment(appointment);
            model.addRow(new Object[]{
                    appointment.getAppointmentId(),
                    appointment.getPatientName(),
                    appointment.getDoctorName(),
                    appointment.getDate(),
                    appointment.getTime(),
                    appointment.getStatus()
            });
            clear();
        });

        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                controller.deleteAppointment(row);
                model.removeRow(row);
            }
        });
        btnBack.addActionListener(e -> dispose());

    }

    private void clear() {
        txtId.setText("");
        txtDate.setText("");
        txtTime.setText("");
    }
}
