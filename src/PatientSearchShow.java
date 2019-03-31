import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

class PatientsSearch{
    
    private int pid;
    private String pfname;
    private String plname;
    private String  paddress;
    private String pfatherName;
    private String pinsruance;
      
    //public PatientsSearch(int id,String fname,String lname,int age){
   PatientsSearch(int id,String fname,String lname,String address,String fatherName,String insurance){
        this.pid = id;
        this.pfname = fname;
        this.plname = lname;
        this.paddress = address;
        this.pfatherName = fatherName;
        this.pinsruance = insurance;      
    }
  
    public int getId(){
        return this.pid;
    }
    
    public String getFname(){
        return this.pfname;
    }
    
    public String getLname(){
        return this.plname;
    }

    public String getAddress(){
       return this.paddress;
    }

    public String getFatherName() {
        return this.pfatherName;
    }

    public String getInsurance() {
        return this.pinsruance;
    }
}

public class PatientSearchShow extends JFrame{
    
      public PatientSearchShow(){
        
        super("Patient Search");      
        setLocationRelativeTo(null);       
        setSize(700,450);
        setLocation(435, 240);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       
        setVisible(true);
    }
 // merge database with <ArrayList> , creating a function
    static ArrayList<PatientsSearch> getPatients(){
        DbConnection dbCon = new DbConnection();
        Connection con = dbCon.getDbConnection();
        
        ArrayList<PatientsSearch> patientsSearch = new ArrayList<>();      
        //Connection con = getConnection();       
        Statement st;        
        ResultSet rs;      
        PatientsSearch getSqlResults = null;    
        
        try {          
            st = con.createStatement();
            rs = st.executeQuery("SELECT id,fname,lname,address,father_name,insurance FROM patients ORDER BY fname asc");
            
            while(rs.next()){               
                getSqlResults = new PatientsSearch(
                        rs.getInt("id"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("address"),
                        rs.getString("father_name"),
                        rs.getString("insurance")  //end
                        
                );
                patientsSearch.add(getSqlResults);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(PatientSearchShow.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(con!=null)
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(HcForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            return patientsSearch;      
        }
    }
}
 
    /**
     *
     * @param args
     */
//    public static void main (String args[]){
//        //add into Jtable ,the arraylist that hold that sql data
//        JTable table = new JTable(); // create new Jtable    
//        DefaultTableModel defaultModel = new DefaultTableModel();//new default table model
//        
//        Object[] columnsName = new Object[3];//generate column names
//        
//        columnsName[0] = "ID";// column name ID
//        columnsName[1] = "First Name";
//        columnsName[2] = "Last Name";
//        //columnsName[3] = "Age";
//        
//        defaultModel.setColumnIdentifiers(columnsName);//add the column names
//        
//        
//        Object[] rowData = new Object[3];
//        for(int i = 0; i < getPatients().size(); i++){ 
//            rowData[0] = getPatients().get(i).getId();
//            rowData[1] = getPatients().get(i).getFname();
//            rowData[2] = getPatients().get(i).getLname();
//            //rowData[3] = getUsers().get(i).getAge();              
//            defaultModel.addRow(rowData);
//        }       
//        table.setModel(defaultModel);
//
//        PatientSearchShow window = new PatientSearchShow();        
//        JPanel panel = new JPanel();        
//        panel.setLayout(new BorderLayout());       
//        JScrollPane pane = new JScrollPane(table);      
//        panel.add(pane,BorderLayout.CENTER);     
//        window.setContentPane(panel);
//    }
//}

