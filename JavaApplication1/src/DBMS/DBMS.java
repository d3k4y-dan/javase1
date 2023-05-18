package DBMS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author USER
 */
public class DBMS {
    
    private static final String url="jdbc:mysql://localhost:3306/burgershop";
    private static final String un="root";
    private static final String pw="123";
    private static final String driver="com.mysql.jdbc.Driver";
    private static Connection con;
    
    private DBMS(){}
    
    public static synchronized Connection getConnection(){
        
        try {
            
            if(con==null){
            
            Class.forName(driver);
            con=DriverManager.getConnection(url, un, pw);
            
            }
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
        
        return con;
        
    }
    
    public static void iud(String q){
        
        try {
            
            con=getConnection();
            Statement s=con.createStatement();
            s.executeUpdate(q);
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
        
    }
    
    public static ResultSet search(String q){
        
        ResultSet rs=null;
        
        try {
            
            rs=getConnection().createStatement().executeQuery(q);
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
        
        return rs;
    
    } 
    
}