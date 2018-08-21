/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pharmacy.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.pharmacy.dao.CrudUtil;
import lk.ijse.pharmacy.dao.custom.ReceiptDAO;
import lk.ijse.pharmacy.entity.Receipt;

/**
 *
 * @author mcs
 */
public class ReceiptDAOImpl implements  ReceiptDAO{

    @Override
    public boolean save(Receipt entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into Receipt Values(?,?,?,?,?,?,?)", entity.getReceiptID(),
                entity.getPatientID(),entity.getPID(),entity.getMID(),entity.getUnitprice(),entity.getQty(),entity.getDate());
    }

    @Override
    public boolean update(Receipt entity) throws Exception {
        return CrudUtil.executeUpdate("Update Receipt set patientID=? ,PID=?,MID=?,unitprice=?,Qty=?,Date=?,ReceiptID=?",entity.getPatientID(),
                entity.getPID(),entity.getMID(), entity.getUnitprice(),entity.getQty(),
                entity.getDate(),entity.getReceiptID());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete  from Receipt where ReceiptID=?", id);
    }

    @Override
    public Receipt find(String id) throws Exception {
        ResultSet rs=CrudUtil.executeQuery("Select * from Receipt where ReceiptID=?", id);
        rs.next();
            Receipt rec=new Receipt(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                    rs.getBigDecimal(5), rs.getInt(6), rs.getDate(7));
            return rec;
        }
        
    

    @Override
    public ArrayList<Receipt> getAll() throws Exception {
        ArrayList<Receipt>allreceipts=new ArrayList<>();
        ResultSet rs=CrudUtil.executeQuery("Select * from Receipt");
        while(rs.next()){
            Receipt res=new Receipt(rs.getString(1),rs.getString(2),rs.getString(3)
                    ,rs.getString(4) ,rs.getBigDecimal(5), rs.getInt(6),rs.getDate(7));
            allreceipts.add(res);
        }
        return allreceipts;
    }

    @Override
    public boolean UpdateReceiptQty(String receiptid) throws Exception {
        return CrudUtil.executeUpdate("Update Receipt set ReceiptID=?",receiptid );
    }
    
    
}
