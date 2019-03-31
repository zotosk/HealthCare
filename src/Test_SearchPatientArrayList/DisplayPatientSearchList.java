package Test_SearchPatientArrayList;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package SearchPatientArrayList;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JFrame;
//
///**
// *
// * @author Cost
// */
//
//class PatientsSearch{
//    
//    private int Id;
//    private String Fname;
//    private String Lname;
//    //private int Age;
//    
//    //public PatientsSearch(int id,String fname,String lname,int age){
//    public PatientsSearch(int id,String fname,String lname){
//        this.Id = id;
//        this.Fname = fname;
//        this.Lname = lname;
//        //this.Age = age;
//    }
//
//    PatientsSearch(String string, String string0) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//    
//    public int getId(){
//        return this.Id;
//    }
//    
//    public String getFname(){
//        return this.Fname;
//    }
//    
//    public String getLname(){
//        return this.Lname;
//    }
////    
////    public int getAge(){
////        return this.Age;
////    } 
//}
//
//public class DisplayPatientSearchList extends JFrame{
//    
//      public DisplayPatientSearchList(){
//        
//        super("Patient Search");      
//        setLocationRelativeTo(null);       
//        setSize(700,450);
//        setLocation(435, 240);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       
//        setVisible(true);
//    }
// // merge database with <ArrayList> , creating a function
//    static ArrayList<PatientsSearch> getPatients(){
//        TestDbCon dbCon = new TestDbCon();
//        Connection con = dbCon.getDbConnection();
//        
//        ArrayList<PatientsSearch> patientsSearch = new ArrayList<>();      
//        //Connection con = getConnection();       
//        Statement st;        
//        ResultSet rs;      
//        PatientsSearch getSqlResults = null;    
//        
//        try {          
//            st = con.createStatement();
//            rs = st.executeQuery("SELECT * FROM patients");
//            
//            while(rs.next()){               
//                getSqlResults = new PatientsSearch(
//                        rs.getInt("id"),
//                        rs.getString("fname"),
//                        rs.getString("lname")
//                        //rs.getInt("age")
//                );
//                patientsSearch.add(getSqlResults);
//            }            
//        } catch (SQLException ex) {
//            Logger.getLogger(DisplayPatientSearchList.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return patientsSearch;      
//    }
//}