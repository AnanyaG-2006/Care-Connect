package controller; //package name.

import java.util.ArrayList;

public class DoctorController {

    private ArrayList<Doctor> doctorList = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctorList.add(doctor);
    }

    public void deleteDoctor(int index) {
        doctorList.remove(index);
    }

    public void updateDoctor(int index, Doctor doctor) {
        doctorList.set(index, doctor);
    }

    public ArrayList<Doctor> getAllDoctors() {
        return doctorList;
    }
}

