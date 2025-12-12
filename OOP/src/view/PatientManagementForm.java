package view;

import controller.PatientController;
import model.Patient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PatientManagementForm extends JFrame {

    private JTextField txtId, txtName, txtAge, txtPhone;
    private JTextArea txtMedical;
    private JTable table;
    private DefaultTableModel model;

    private PatientController controller = new PatientController();

    public PatientManagementForm() {

        setTitle("Manage Patients");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // -------- Form --------
        JPanel form = new JPanel(new GridLayout(5, 2));

        form.add(new JLabel("Patient ID"));
        txtId = new JTextField();
        form.add(txtId);

        form.add(new JLabel("Name"));
        txtName = new JTextField();
        form.add(txtName);

        form.add(new JLabel("Age"));
        txtAge = new JTextField();
        form.add(txtAge);

        form.add(new JLabel("Phone"));
        txtPhone = new JTextField();
        form.add(txtPhone);

        form.add(new JLabel("Medical History"));
        txtMedical = new JTextArea(3, 20);
        form.add(new JScrollPane(txtMedical));

        add(form, BorderLayout.NORTH);

        // -------- Table --------
        model = new DefaultTableModel(
                new String[]{"ID", "Name", "Age", "Phone", "History"}, 0
        );
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // -------- Buttons --------
        JPanel buttons = new JPanel();

        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        JButton btnBack = new JButton("Back");

        buttons.add(btnAdd);
        buttons.add(btnUpdate);
        buttons.add(btnDelete);
        buttons.add(btnBack);

        add(buttons, BorderLayout.SOUTH);

        // -------- Actions --------
        btnAdd.addActionListener(e -> {
            Patient patient = new Patient(
                    txtId.getText(),
                    txtName.getText(),
                    txtAge.getText(),
                    txtPhone.getText(),
                    txtMedical.getText()
            );

            controller.addPatient(patient);
            model.addRow(new Object[]{
                    patient.getPatientId(),
                    patient.getName(),
                    patient.getAge(),
                    patient.getPhone(),
                    patient.getMedicalHistory()
            });
            clear();
        });

        btnUpdate.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                Patient patient = new Patient(
                        txtId.getText(),
                        txtName.getText(),
                        txtAge.getText(),
                        txtPhone.getText(),
                        txtMedical.getText()
                );
                controller.updatePatient(row, patient);

                model.setValueAt(txtId.getText(), row, 0);
                model.setValueAt(txtName.getText(), row, 1);
                model.setValueAt(txtAge.getText(), row, 2);
                model.setValueAt(txtPhone.getText(), row, 3);
                model.setValueAt(txtMedical.getText(), row, 4);
            }
        });

        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                controller.deletePatient(row);
                model.removeRow(row);
            }
        });
        btnBack.addActionListener(e -> dispose());


        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                txtId.setText(model.getValueAt(row, 0).toString());
                txtName.setText(model.getValueAt(row, 1).toString());
                txtAge.setText(model.getValueAt(row, 2).toString());
                txtPhone.setText(model.getValueAt(row, 3).toString());
                txtMedical.setText(model.getValueAt(row, 4).toString());
            }
        });
    }

    private void clear() {
        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtPhone.setText("");
        txtMedical.setText("");
    }
}
