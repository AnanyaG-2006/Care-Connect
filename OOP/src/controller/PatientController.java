package controller;

import model.Patient;
import java.util.ArrayList;


public class PatientController {

    private ArrayList<Patient> patientList = new ArrayList<>();

    public void addPatient(Patient patient) {
        patientList.add(patient);
    }

    public void updatePatient(int index, Patient patient) {
        patientList.set(index, patient);
    }

    public void deletePatient(int index) {
        patientList.remove(index);
    }

    public ArrayList<Patient> getAllPatients() {
        return patientList;
    }
}
