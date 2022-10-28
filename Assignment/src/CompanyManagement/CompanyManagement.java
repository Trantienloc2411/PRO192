package CompanyManagement;

import Nhanvien_object.Employee;
import java.util.ArrayList;

public class CompanyManagement {
    private ArrayList <Employee> empList = new ArrayList<>();

    public CompanyManagement(String path, String path1) {
            File f = new File(path);
            File f1 = new File(path1);
            if(!f.exists()) return;
            FileReader fr = new FileReader(f); //read
            BufferedReader bf = new BufferedReader(fr); //readLine
            String details, PL;
           
            while ((PL = bf.readLine()) != null){
                String code, typeCode;
                empList = new ArrayList<Employee>();
                
            }
            while((details = bf.readLine()) != null){
                StringTokenizer stk = new StringTokenizer(details, ",");
                int No = Integer.parseInt(stk.nextToken());
                String code = stk.nextToken();
                String name = stk.nextToken();
                String teamName = stk.nextToken();
                double expYear = Double.parseDouble(stk.nextToken());
                int baseSal = Integer.parseInt(stk.nextToken());
                empList = new ArrayList<Employee>();
                
                if (code.startsWith("D")) {
                    
                }
    }
    public void getEmployeeFromFile(String path, String path1){
        
    }
    
    
}
