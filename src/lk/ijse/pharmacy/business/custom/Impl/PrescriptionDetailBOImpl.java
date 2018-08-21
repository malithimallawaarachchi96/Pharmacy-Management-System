/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pharmacy.business.custom.Impl;

import java.util.ArrayList;
import lk.ijse.pharmacy.busines.custom.PrescriptionDetailBO;
import lk.ijse.pharmacy.dao.DAOFactory;
import lk.ijse.pharmacy.dao.custom.PrescriptionDetailDAO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.dto.PrescriptiondetailDTO;
import lk.ijse.pharmacy.entity.Prescriptiondetail;
import lk.ijse.pharmacy.entity.Prescriptiondetail_PK;

/**
 *
 * @author mcs
 */
public class PrescriptionDetailBOImpl implements PrescriptionDetailBO {

    PrescriptionDetailDAO presdetdao = (PrescriptionDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PrescriptionDetail);

    @Override
    public boolean savePrescriptiondetail(PrescriptiondetailDTO presdet) throws Exception {
        try {
//            DBConnection.getInstance().getConnection().setAutoCommit(false);
            Prescriptiondetail presdetail = new Prescriptiondetail(presdet.getDoctorName(), presdet.getPID(), presdet.getMID());
            boolean result = presdetdao.save(presdetail);
            return result;
        } catch (Exception e) {
            //DBConnection.getInstance().getConnection().rollback();
            throw e;
        }

    }

    @Override
    public boolean UpdatePrescriptiondetail(PrescriptiondetailDTO presdet) throws Exception {
        Prescriptiondetail presdetail = new Prescriptiondetail(presdet.getDoctorName(), presdet.getPID(), presdet.getMID());
        boolean result = presdetdao.update(presdetail);
        return result;
    }

    @Override
    public boolean DeletePrescriptiondetail(String PID, String MID) throws Exception {
        boolean result = presdetdao.delete(new Prescriptiondetail_PK(PID, MID));
        return result;
    }

    @Override
    public PrescriptiondetailDTO Find(String PID, String MID) throws Exception {
        Prescriptiondetail predetail = presdetdao.find(new Prescriptiondetail_PK(PID, MID));
        PrescriptiondetailDTO predto = new PrescriptiondetailDTO(predetail.getDoctorName(),
                predetail.getPrescriptiondetail_PK().getPID(), predetail.getPrescriptiondetail_PK().getMID());
        return predto;
    }

    @Override
    public ArrayList<PrescriptiondetailDTO> getAllperesDetail() throws Exception {
        ArrayList<Prescriptiondetail> predetail = presdetdao.getAll();
        ArrayList<PrescriptiondetailDTO> Presdto = new ArrayList<>();
        for (Prescriptiondetail presc : predetail) {
            PrescriptiondetailDTO predto = new PrescriptiondetailDTO(presc.getDoctorName(), presc.getPrescriptiondetail_PK().getPID(),
                    presc.getPrescriptiondetail_PK().getMID());
            Presdto.add(predto);
        }
        return Presdto;
    }

}
