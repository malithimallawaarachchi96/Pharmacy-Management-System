/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pharmacy.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.pharmacy.dao.CrudUtil;
import lk.ijse.pharmacy.dao.custom.PrescriptionDetailDAO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.entity.Prescriptiondetail;
import lk.ijse.pharmacy.entity.Prescriptiondetail_PK;

/**
 *
 * @author mcs
 */
public class PrescriptiondetailDAOImpl implements PrescriptionDetailDAO{

    @Override
    public boolean save(Prescriptiondetail entity) throws Exception {
      //  System.out.println("sgjks");
        boolean result = CrudUtil.executeUpdate("Insert into Prescription_detail  values(?,?,?)",entity.getDoctorName(),
                entity.getPrescriptiondetail_PK().getPID(),entity.getPrescriptiondetail_PK().getMID());
        //System.out.println(result);
        return result;
    }

    @Override
    public boolean update(Prescriptiondetail entity) throws Exception {
        return CrudUtil.executeUpdate("Update Prescription_detail set  DoctorName=?,  where PID=? && MID=? ",entity.getDoctorName(),
                entity.getPrescriptiondetail_PK().getPID(),entity.getPrescriptiondetail_PK().getMID());
    }


    @Override
    public ArrayList<Prescriptiondetail> getAll() throws Exception {
        ArrayList<Prescriptiondetail> pres=new ArrayList<>();
        ResultSet rs=CrudUtil.executeQuery("Select * from Prescription_detail");
        while(rs.next()){
            Prescriptiondetail presde=new Prescriptiondetail(rs.getString(1), rs.getString(2), rs.getString(3));
            pres.add(presde);
        }
        return pres;
    }

    @Override
    public boolean delete(Prescriptiondetail_PK id) throws Exception {
        return CrudUtil.executeUpdate("Delete  from Prescription_detail where PID=? && MID=?",id.getPID(),id.getMID()); 
    
    }

    @Override
    public Prescriptiondetail find(Prescriptiondetail_PK id) throws Exception {
        ResultSet rs=CrudUtil.executeQuery("Select * from Prescription_detail");
        rs.next();
        Prescriptiondetail pres=new Prescriptiondetail(rs.getString(1), rs.getString(2), rs.getString(3));
        return pres;
    }
    
}
