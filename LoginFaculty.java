
import java.io.File;
import java.util.Scanner;


public class LoginFaculty extends Login{
   
     public boolean vertifyloin(String uid, String pass, String filepath){
        boolean sucessful = false;
        String tempuname = "";
        String temppass = "";
        Scanner filescan;
        try{
            filescan = new Scanner(new File(filepath));
            filescan.useDelimiter("[,.\n]");
            
            while(filescan.hasNext() && !sucessful){
                tempuname = filescan.next();
                temppass = filescan.next();
                
                if(tempuname.trim().equals(uid.trim()) && temppass.trim().equals(pass.trim())){
                     sucessful = true;
                }
                
            }
            filescan.close();
        }
        catch(Exception e){
            System.out.println("Error- "+e.getMessage());
        }
        
        return sucessful;
    }
    LoginFaculty(){
         
		 super("Facuty");
		
        int c;
        do{
        Scanner input = new Scanner(System.in);
        System.out.print("User Id-\t ");
        String uid = input.nextLine();
        System.out.print("Password-\t ");
        String pass = input.nextLine();
        String filepath = "FacultyLogin.txt";
        
        boolean b = vertifyloin(uid,pass,filepath);
        
        if(!b){
            
            System.out.println("Invalid usernanme of password!\nPress Enter to try again.\nIf u want to quit press '0' then Enter\n");
            c = input.nextInt();
        }
         else{
            System.out.println("Login Sucessful");
            Faculty f = new Faculty();
            System.out.println("Welcome. Here is your student information-");
            System.out.println(f.GetMyInfo(uid));
			f.givechoice();
             break;
            
        }
      
        }while(c != 0);
    }
    
}
