



import java.io.File;
import java.util.Scanner;

public class LoginStudent extends Login{
    
    
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
    LoginStudent(){
         
		 super("Student");
		
        int c;
        do{
        Scanner input = new Scanner(System.in);
        System.out.print("User Id-\t ");
        String uid = input.nextLine();
        System.out.print("Password-\t ");
        String pass = input.nextLine();
        String filepath = "StudentLogin.txt";
        
        boolean b = vertifyloin(uid,pass,filepath);
        
        if(!b){
            
            System.out.println("Invalid usernanme of password!\nPress Enter to try again.\nIf u want to quit press '0' then Enter\n");
            c = input.nextInt();
        }
         else{
            System.out.println("Login Sucessful");
            Student s = new Student();
            System.out.println("Welcome. Here is your student information-");
            System.out.println(s.GetMyInfo(uid));
            
             break;
            
        }
      
        }while(c != 0);
    }
    
   

}
