/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pharmacy.business.custom.Impl;

import java.util.ArrayList;
import lk.ijse.pharmacy.busines.custom.MedicineBO;
import lk.ijse.pharmacy.dao.DAOFactory;
import lk.ijse.pharmacy.dao.custom.MedicineDAO;
import lk.ijse.pharmacy.dto.MedicineDTO;
import lk.ijse.pharmacy.entity.Medicine;

/**
 *
 * @author mcs
 */
public class MedicineBOImpl implements MedicineBO{
   MedicineDAO medicinedao=(MedicineDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.Medicine);
    @Override
    public boolean saveMedicine(MedicineDTO medicine) throws Exception {
        Medicine medi=new Medicine(medicine.getMID(), medicine.getDescription(), medicine.getQty(), medicine.getApproval());
        boolean result=medicinedao.save(medi);
       return result;
    }

    @Override
    public boolean deleteMedicine(String id) throws Exception {
        boolean result=medicinedao.delete(id);
        return  result;
    }

    @Override
    public boolean UpdateMedicine(MedicineDTO medicine) throws Exception {
        Medicine medi=new Medicine(medicine.getMID(), medicine.getDescription(), medicine.getQty(), medicine.getApproval());
        boolean result=medicinedao.update(medi);
        return result;
    }

    @Override
    public MedicineDTO find(String id) throws Exception {
            Medicine medi=medicinedao.find(id);
            MedicineDTO medicinedto=new MedicineDTO(medi.getMID(), medi.getDescription(), medi.getQty(), medi.getApproval());
            return  medicinedto;
    }

    @Override
    public ArrayList<MedicineDTO> getAllMedicine() throws Exception {
        ArrayList<Medicine>allMedicine=medicinedao.getAll();
        ArrayList<MedicineDTO>medidto=new ArrayList<>();
        for (Medicine medicine : allMedicine) {
            MedicineDTO medi=new MedicineDTO(medicine.getMID(), medicine.getDescription(), medicine.getQty(), medicine.getApproval());
            medidto.add(medi);
        }
       return medidto;
    }

    @Override
    public boolean updateQty(int Qty, String id) throws Exception {
        
        boolean medi=medicinedao.UpdateQty(Qty, id);
       return medi;
        
    }
    
}
