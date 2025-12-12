package view;

import controller.DoctorController;
import model.Doctor;

import javax.swing.*;
import java.awt.*;

public class DoctorAssignmentForm extends JFrame {

    private JComboBox<String> cmbSpecialty;
    private JTextArea txtResult;

    private DoctorController controller;

    public DoctorAssignmentForm(DoctorController controller) {

        this.controller = controller;

        setTitle("Assign Doctor to Patient");
        setSize(400, 250);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        // -------- Top --------
        JPanel top = new JPanel();

        cmbSpecialty = new JComboBox<>(new String[]{
                "Cardiology", "Dermatology", "Neurology", "General"
        });

        JButton btnAssign = new JButton("Assign Doctor");
        JButton btnBack = new JButton("Back");

        top.add(new JLabel("Required Specialty:"));
        top.add(cmbSpecialty);
        top.add(btnAssign);
        top.add(btnBack);

        add(top, BorderLayout.NORTH);

        // -------- Result --------
        txtResult = new JTextArea();
        txtResult.setEditable(false);
        add(new JScrollPane(txtResult), BorderLayout.CENTER);

        // -------- Action --------
        btnAssign.addActionListener(e -> assignDoctor());
        btnBack.addActionListener(e -> dispose());

    }


    private void assignDoctor() {
        String required = cmbSpecialty.getSelectedItem().toString();

        for (Doctor d : controller.getAllDoctors()) {
            if (d.getSpecialty().equalsIgnoreCase(required)) {
                txtResult.setText(
                        "Doctor Assigned:\n" +
                                "Name: " + d.getName() + "\n" +
                                "Specialty: " + d.getSpecialty() + "\n" +
                                "Available: " + d.getTimeSlots()
                );
                return;
            }
        }

        txtResult.setText("No available doctor for selected specialty.");
    }
}

