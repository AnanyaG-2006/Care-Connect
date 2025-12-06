package view;

import controller.DoctorController;
import model.Doctor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DoctorManagementForm extends JFrame {

    private JTextField txtId, txtName, txtPhone, txtDays, txtSlots;
    private JComboBox<String> cmbSpecialty;
    private JTable table;
    private DefaultTableModel model;

    private DoctorController controller = new DoctorController();

    public DoctorManagementForm() {

        setTitle("Manage Doctors");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ---------- Form Panel ----------
        JPanel form = new JPanel(new GridLayout(6, 2));

        form.add(new JLabel("Doctor ID"));
        txtId = new JTextField();
        form.add(txtId);

        form.add(new JLabel("Name"));
        txtName = new JTextField();
        form.add(txtName);

        form.add(new JLabel("Specialty"));
        cmbSpecialty = new JComboBox<>(new String[]{
                "Cardiology", "Dermatology", "Neurology", "General"
        });
        form.add(cmbSpecialty);

        form.add(new JLabel("Phone"));
        txtPhone = new JTextField();
        form.add(txtPhone);

        form.add(new JLabel("Working Days"));
        txtDays = new JTextField();
        form.add(txtDays);

        form.add(new JLabel("Time Slots"));
        txtSlots = new JTextField();
        form.add(txtSlots);

        add(form, BorderLayout.NORTH);

        // ---------- Table ----------
        model = new DefaultTableModel(
                new String[]{"ID", "Name", "Specialty", "Phone", "Days", "Slots"}, 0
        );
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // ---------- Buttons ----------
        JPanel buttons = new JPanel();

        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");

        buttons.add(btnAdd);
        buttons.add(btnUpdate);
        buttons.add(btnDelete);

        add(buttons, BorderLayout.SOUTH);

        // ---------- Button Actions --------
        btnAdd.addActionListener(e -> {
            Doctor doctor = new Doctor(
                    txtId.getText(),
                    txtName.getText(),
                    cmbSpecialty.getSelectedItem().toString(),
                    txtPhone.getText(),
                    txtDays.getText(),
                    txtSlots.getText()
            );

            controller.addDoctor(doctor);
            model.addRow(new Object[]{
                    doctor.getDoctorId(),
                    doctor.getName(),
                    doctor.getSpecialty(),
                    doctor.getPhone(),
                    doctor.getWorkingDays(),
                    doctor.getTimeSlots()
            });
            clearFields();
        });

        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                controller.deleteDoctor(row);
                model.removeRow(row);
            }
        });

        btnUpdate.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                Doctor doctor = new Doctor(
                        txtId.getText(),
                        txtName.getText(),
                        cmbSpecialty.getSelectedItem().toString(),
                        txtPhone.getText(),
                        txtDays.getText(),
                        txtSlots.getText()
                );

                controller.updateDoctor(row, doctor);
                model.setValueAt(txtId.getText(), row, 0);
                model.setValueAt(txtName.getText(), row, 1);
                model.setValueAt(cmbSpecialty.getSelectedItem(), row, 2);
                model.setValueAt(txtPhone.getText(), row, 3);
                model.setValueAt(txtDays.getText(), row, 4);
                model.setValueAt(txtSlots.getText(), row, 5);
            }
        });

        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                txtId.setText(model.getValueAt(row, 0).toString());
                txtName.setText(model.getValueAt(row, 1).toString());
                cmbSpecialty.setSelectedItem(model.getValueAt(row, 2));
                txtPhone.setText(model.getValueAt(row, 3).toString());
                txtDays.setText(model.getValueAt(row, 4).toString());
                txtSlots.setText(model.getValueAt(row, 5).toString());
            }
        });
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtPhone.setText("");
        txtDays.setText("");
        txtSlots.setText("");
    }
}
