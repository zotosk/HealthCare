import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HcLogs extends HcLogin{

    private String findFileName;
    private String findDirectoryName;
    
    public void showLogs(String getUserNameCurrent,int countUser){
        
        //**method that gets the username for current loged in user from HcLogin main
        //**using buffering      
        findFileName = "logs.txt"; 
        findDirectoryName = "src/hc_logs";
        final String theCompletePath = findDirectoryName + File.separator + findFileName;                          
        String displayTimeAndDate = new SimpleDateFormat("yyyy-MM-dd - HH:mm:ss |").format(Calendar.getInstance().getTime());                       
        //**write the content in file                        
        try(BufferedWriter bf = new BufferedWriter(new FileWriter(theCompletePath, true))) {  
            String get_user_name_current = displayTimeAndDate + " -- User logged in : " + getUserNameCurrent ;
            bf.write(get_user_name_current);

            for(int i = 0 ; i < countUser; i++){
                i = countUser;
                bf.newLine(); 
            }
            bf.close();                           
        } catch (IOException e) {
            //exception handling
            //System.out.println(e.getMessage());                         
        }
        dispose();      
    }
}
