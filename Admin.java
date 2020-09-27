

import java.io.File;
import java.util.Scanner;


public class Admin {
    
    Admin(){
        Part2();
    }
    
     public static void Part2(){
        int choice;
        Student s = new Student();
		Faculty f = new Faculty();
        
        
        
        
        do{
        System.out.println("Please Enter your choice(type the choice's number): \n1. Add Studnet\n2. Student Admission Time Info\n3. Show Evaluated Student's Info\n4. Search Student-\n5. Check Student's Password\n6. Add Faculty\n7. Display All Faculties\n8. Search Faculty-\n9. Check Faculty's Password\n0. Exit");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        switch(choice){
            case 1: s.AddtoFile();
                break;
            case 2: System.out.println("Without Marks\n"+s.Info()); 
                break;
			case 3:System.out.println("Evaluated student's info\n"+s.AllDisplayStudent()); 
                break;
            case 4: 
                System.out.println("Search by-\n\t1. ID\n\t2. Name\n\t3. Department\n\t4. Mid Term Marks\n\t5. Final Marks\n\t6. CGPA\n\t7. Exit");
                int c = input.nextInt();
                System.out.println(s.SearchUser(c));
                break;
            case 5: System.out.print("Check Student's Password For-\nID- ");
                    int id = input.nextInt();
                    System.out.println(s.CheckPass(String.valueOf(id)));
                    break;
		    case 6: f.AddtoFile();
                break;
            case 7: System.out.println(f.AllDisplayStudent()); 
                break;
            case 8: 
                System.out.println("Search by-\n\t1. ID\n\t2. Name\n\t3. Department\n\t4. Salary\n\t7. Exit");
                int cf = input.nextInt();
                System.out.println(f.SearchUser(cf));
                break;
            case 9: System.out.print("Check Faculty's Password For-\nID- ");
                    int idf = input.nextInt();
                    System.out.println(f.CheckPass(String.valueOf(idf)));
                    break;
            case 0: System.out.println("Process Terminating");
                break;
                
            default: System.out.println("No valid function exists for choice- "+ choice);
                break;
                }
        
       
        }while(choice != 0);
        
    }
     
   

   
    
}
