/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pharmacy.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.pharmacy.dao.CrudUtil;
import lk.ijse.pharmacy.dao.custom.PrescriptionDAO;
import lk.ijse.pharmacy.entity.Prescription;

/**
 *
 * @author mcs
 */
public class PrescriptionDAOImpl implements  PrescriptionDAO{

    @Override
    public boolean save(Prescription entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into prescription Values(?,?,?)",entity.getPID(),entity.getPatientID(),entity.getDate());
    }

    @Override
    public boolean update(Prescription entity) throws Exception {
        return CrudUtil.executeUpdate("Update Prescription set PatientID=?, Date=?  where PID=?",entity.getPID(),entity.getPatientID(),entity.getDate());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from prescription where PID=?", id);
    }

    @Override
    public Prescription find(String id) throws Exception {
        ResultSet rs=CrudUtil.executeQuery("Select * from Prescription where PID=?",id);
        rs.next();
        Prescription pres=new Prescription(rs.getString(1),rs.getString(2), rs.getDate(3));
        return  pres;
    }

    @Override
    public ArrayList<Prescription> getAll() throws Exception {
        ArrayList<Prescription> Pres=new ArrayList<>();
        ResultSet rs=CrudUtil.executeQuery("Select * from prescription");
        while (rs.next()) {            
            Pres.add(new Prescription(rs.getString(1), rs.getString(2),rs.getDate(3)));
           
        }
        return Pres;
    }
    
    
}
