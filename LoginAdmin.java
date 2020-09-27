

import java.io.File;
import java.util.Scanner;

public class LoginAdmin extends Login {
    
   
     public boolean vertifyloin(String uname, String pass, String filepath){
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
                
                if(tempuname.trim().equals(uname.trim()) && temppass.trim().equals(pass.trim())){
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
    LoginAdmin(){
        
		super("Admin");
        int c;
        
        Scanner input = new Scanner(System.in);
        System.out.print("UserName-\t ");
        String uname = input.nextLine();
        System.out.print("Password-\t ");
        String pass = input.nextLine();
        String filepath = "Login.txt";
        do{
        boolean b = vertifyloin(uname,pass,filepath);
        
        if(!b){
            
            System.out.println("Invalid usernanme of password!\nPress Enter to try again.\nIf u want to quit press '0' then Enter\n");
            c = input.nextInt();
        }
         else{
            System.out.println("Login Sucessful");
            Admin a = new Admin();
            
             break;
            
        }
      
        }while(c != 0);
    }
    
}
