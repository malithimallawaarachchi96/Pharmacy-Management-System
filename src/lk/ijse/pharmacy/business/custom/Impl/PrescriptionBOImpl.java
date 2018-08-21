/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pharmacy.business.custom.Impl;

import java.util.ArrayList;
import lk.ijse.pharmacy.busines.custom.PrescriptionBO;
import lk.ijse.pharmacy.dao.DAOFactory;
import lk.ijse.pharmacy.dao.custom.PrescriptionDAO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.dto.PrescriptionDTO;
import lk.ijse.pharmacy.entity.Prescription;

/**
 *
 * @author mcs
 */
public class PrescriptionBOImpl implements PrescriptionBO {

    PrescriptionDAO prescriptiondao;

    public PrescriptionBOImpl() {
        this.prescriptiondao = (PrescriptionDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PreSCRIPTION);
    }

    @Override
    public boolean SavePrescription(PrescriptionDTO presd) throws Exception {
        try {
        DBConnection.getInstance().getConnection().setAutoCommit(false);
        Prescription pre = new Prescription(presd.getPID(),presd.getPatientID(), presd.getDate());
        boolean result = prescriptiondao.save(pre);
        return result;
            
        } catch (Exception e) {
            DBConnection.getInstance().getConnection().rollback();
            throw e;
        }
        finally{
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    
        
    } 
    

    @Override
    public boolean UpdatePrescription(PrescriptionDTO presd) throws Exception {
        Prescription pre = new Prescription(presd.getPID(), presd.getPatientID(), presd.getDate());
        boolean result = prescriptiondao.update(pre);
        return result;
    }

    @Override
    public boolean DeletePrescription(String id) throws Exception {
        boolean pre = prescriptiondao.delete(id);
        return pre;
    }

    @Override
    public PrescriptionDTO Find(String ID) throws Exception {
        Prescription pre = prescriptiondao.find(ID);
        PrescriptionDTO prescriptiondto = new PrescriptionDTO(pre.getPID(), pre.getPatientID(), pre.getDate());
        return prescriptiondto;
    }

    @Override
    public ArrayList<PrescriptionDTO> getAllPrescriptions() throws Exception {
        ArrayList<Prescription> allpres = prescriptiondao.getAll();
        ArrayList<PrescriptionDTO> olpres = new ArrayList<>();
        for (Prescription olpre : allpres) {
            PrescriptionDTO prescriptionDTO = new PrescriptionDTO(olpre.getPID(), olpre.getPatientID(), olpre.getDate());
            olpres.add(prescriptionDTO);
        }
        return olpres;
    }
   
  
 }





