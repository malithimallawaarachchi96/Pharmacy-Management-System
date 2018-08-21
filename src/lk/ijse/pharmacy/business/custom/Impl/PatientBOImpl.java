/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pharmacy.business.custom.Impl;

import java.util.ArrayList;
import lk.ijse.pharmacy.busines.custom.PatientBO;
import lk.ijse.pharmacy.dao.DAOFactory;
import lk.ijse.pharmacy.dao.custom.PatientDAO;
import lk.ijse.pharmacy.dto.PatientDTO;
import lk.ijse.pharmacy.entity.Patient;

/**
 *
 * @author mcs
 */
public class PatientBOImpl implements PatientBO{
    
    PatientDAO patientDAO=(PatientDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.Patient);
    
    @Override
    public boolean savePatient(PatientDTO patient) throws Exception {
        Patient patiente=new Patient(patient.getPatientID(), patient.getAddress(), patient.getName());
        boolean result=patientDAO.save(patiente);
        return  result;
       
    }

    @Override
    public boolean UpdatePatient(PatientDTO patient) throws Exception {
        Patient patiente=new Patient(patient.getPatientID(), patient.getAddress(),patient.getName());
        boolean result=patientDAO.update(patiente);
        return  result;
    }

    @Override
    public boolean DeletePatient(String id) throws Exception {
        boolean result=patientDAO.delete(id);
        return result;
    }

    @Override
    public PatientDTO Find(String ID) throws Exception {
        Patient patient=patientDAO.find(ID);
        PatientDTO patientdto=new PatientDTO(patient.getPatientID(), patient.getAddress(), patient.getName());
        return patientdto;
    }

    @Override
    public ArrayList<PatientDTO> getAllPatient() throws Exception {
        ArrayList<Patient>allPatients=patientDAO.getAll();
        ArrayList<PatientDTO>olpatient=new ArrayList<>();
        for (Patient patient : allPatients) {
            PatientDTO patientdto=new PatientDTO(patient.getPatientID(), patient.getAddress(), patient.getName());
            olpatient.add(patientdto);
        }
        return olpatient;
    }
    
}
