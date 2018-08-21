/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pharmacy.business.custom.Impl;

import java.util.ArrayList;
import lk.ijse.pharmacy.busines.custom.MedicineBO;
import lk.ijse.pharmacy.busines.custom.ReceiptBO;
import lk.ijse.pharmacy.business.BOFactory;
import lk.ijse.pharmacy.dao.DAOFactory;
import lk.ijse.pharmacy.dao.custom.ReceiptDAO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.dto.ReceiptDTO;
import lk.ijse.pharmacy.entity.Receipt;

/**
 *
 * @author mcs
 */
public class ReceiptBOImpl implements ReceiptBO{
  ReceiptDAO receiptdao;
    MedicineBO medicineBO;
    public ReceiptBOImpl() {
        this.medicineBO = (MedicineBO) BOFactory.getInstance().getBO(BOFactory.BOType.Medicine);
        this.receiptdao = (ReceiptDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.Receipt);
    }
    @Override
    public boolean saveRecipt(ReceiptDTO receipt) throws Exception {
        
        Receipt res=new Receipt(receipt.getReceiptID(),receipt.getPatientID(),receipt.getPID(),receipt.getMID(), receipt.getUnitprice(), receipt.getQty(), receipt.getDate());
        boolean result=receiptdao.save(res);
        return  result;
    }

    @Override
    public boolean UpdateReceipt(ReceiptDTO receipt) throws Exception {
       Receipt res=new Receipt(receipt.getReceiptID(),receipt.getPatientID(),receipt.getPID(),receipt.getMID(), receipt.getUnitprice(), receipt.getQty(), receipt.getDate());
        boolean result=receiptdao.update(res);
        return  result;
    }

    @Override
    public boolean DeleteReceipt(String id) throws Exception {
      boolean result=receiptdao.delete(id);
      return result;
    }

    @Override
    public ReceiptDTO find(String ID) throws Exception {
        Receipt res=receiptdao.find(ID);
        ReceiptDTO receiptdto=new ReceiptDTO(res.getReceiptID(),res.getPatientID(),res.getPID(),res.getMID(),res.getUnitprice(),res.getQty(),res.getDate());
      return receiptdto;
     
    }

    @Override
    public ArrayList<ReceiptDTO> getAllReceipt() throws Exception {
        ArrayList<Receipt>res=receiptdao.getAll();
        ArrayList<ReceiptDTO>resdto=new ArrayList<>();
        for (Receipt receipt : res) {
            ReceiptDTO resdDTO=new ReceiptDTO(receipt.getReceiptID(),receipt.getPatientID(),receipt.getPID(),receipt.getMID(), receipt.getUnitprice(), receipt.getQty(), receipt.getDate());
            resdto.add(resdDTO);
        }
      return resdto;
    }
  @Override
    public  boolean  UpdateReceiptQty(String receiptid)throws Exception{
        boolean result = false;
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            Receipt find = receiptdao.find(receiptid);
            if(find == null){
                DBConnection.getInstance().getConnection().rollback();
                return false;
            }
            result = medicineBO.updateQty(find.getQty(), find.getMID());
        } catch (Exception e) {
            DBConnection.getInstance().getConnection().rollback();
        }
        finally{
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
        return result;
    }
}
