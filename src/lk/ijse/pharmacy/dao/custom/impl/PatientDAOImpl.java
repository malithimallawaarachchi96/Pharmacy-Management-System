/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pharmacy.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.pharmacy.dao.CrudUtil;
import lk.ijse.pharmacy.dao.custom.PatientDAO;
import lk.ijse.pharmacy.entity.Patient;

/**
 *
 * @author mcs
 */
public class PatientDAOImpl implements PatientDAO{

    @Override
    public boolean save(Patient entity) throws Exception {
        return  CrudUtil.executeUpdate("Insert Into patient values(?,?,?)",entity.getPatientID(),
              entity.getAddress(),entity.getName());
    }

    @Override
    public boolean update(Patient entity) throws Exception {
        return CrudUtil.executeUpdate("Update patient set  Address=?,Name=? where PatientID=?",entity.getAddress(),entity.getName(),entity.getPatientID());
    }

    @Override
    public boolean delete(String id) throws Exception {
         return CrudUtil.executeUpdate("Delete  from patient where  PatientID=?",id);
    }

    @Override
    public Patient find(String id) throws Exception {
        ResultSet rs= CrudUtil.executeQuery("Select * from Patient where PatientID=? ",id);
        rs.next();
        Patient patient=new Patient(rs.getString(1), rs.getString(2), rs.getString(3));
        return patient;
    
    }

    @Override
    public ArrayList<Patient> getAll() throws Exception {
        ArrayList<Patient>patients=new ArrayList<>();
        ResultSet rs=CrudUtil.executeQuery("Select * from Patient");
        while(rs.next()){
           Patient patient=new Patient(rs.getString(1), rs.getString(2), rs.getString(3));
           patients.add(patient);
        }
        return patients;
    }

   
}