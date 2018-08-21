/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pharmacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lk.ijse.pharmacy.db.DBConnection;

/**
 *
 * @author mcs
 */
public class CrudUtil {
    private  static  PreparedStatement getPreparedStatement(String sql,Object...args)throws  Exception{
         Connection connection=DBConnection.getInstance().getConnection();
         PreparedStatement prst=connection.prepareStatement(sql);
         for(int i=0;i < args.length;i++){
            prst.setObject(i+1, args[i]);
             
         }
        return prst;
        
    }
    public  static ResultSet executeQuery(String Sql,Object...args)throws Exception{
        return getPreparedStatement(Sql, args).executeQuery();
        
    }
    public static  boolean executeUpdate(String sql,Object...args)throws  Exception{
        return getPreparedStatement(sql, args).executeUpdate()>0;
        
    }
}
