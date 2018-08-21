/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pharmacy.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.pharmacy.dao.CrudUtil;
import lk.ijse.pharmacy.dao.custom.MedicineDAO;
import lk.ijse.pharmacy.entity.Medicine;

/**
 *
 * @author mcs
 */
public class MedicineDAOImpl implements MedicineDAO{

    @Override
    public boolean save(Medicine entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into Medicine values(?,?,?,?)",entity.getMID(),entity.getDescription(),entity.getQty(),entity.getApproval());
    }

    @Override
    public boolean update(Medicine entity) throws Exception {
        return CrudUtil.executeUpdate("Update Medicine set  Description=?, Qty=?, Approval=? where MID=?",entity.getDescription(),entity.getQty(),entity.getApproval(),entity.getMID());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from Medicine where MID=?",id);
    }

    @Override
    public Medicine find(String id) throws Exception {
        ResultSet rs=CrudUtil.executeQuery("Select * from Medicine where MID=?",id);
        rs.next();
        Medicine med=new Medicine(rs.getString(1), rs.getString(2),rs.getInt(3),rs.getString(4));
        return med;
    }

    @Override
    public ArrayList<Medicine> getAll() throws Exception {
        ArrayList<Medicine>med=new ArrayList<>();
        ResultSet rs=CrudUtil.executeQuery("Select * from Medicine");
        while(rs.next()){
        Medicine medi=new Medicine(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
        med.add(medi);
    }
        return med;
    }

    @Override
    public boolean UpdateQty(int qty, String id) throws Exception {
        return CrudUtil.executeUpdate("Update medicine set Qty=Qty-? where mid=? ",qty,id);
    }
    
}
