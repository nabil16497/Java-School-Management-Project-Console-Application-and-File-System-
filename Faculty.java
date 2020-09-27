


import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Faculty extends User {
    
    private double salary;
    private String dept;
    private static int numberoffaculty =0;
    
    
 
   public static void givechoice(){
	    int choice;
        Student s = new Student();
		
		
		do{
        System.out.println("Please Enter your choice(type the choice's number):\n1.Add Marks\n2.Display All Students\n3.Exit");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        switch(choice){
            
            case 1: s.AllMarks();
                break;
            case 2: System.out.println(s.AllDisplayStudent()); 
                break;
			case 3: System.out.println("Process Terminating");
                break;
			default: System.out.println("No valid function exists for choice- "+ choice);
                break;
		        }
		}while(choice != 3);
   }
   

     protected void AddAcc() {
        Scanner input =new Scanner (System.in);
        try{
                    
		String output = GetAllFacultyLogin();
                
		FileWriter w= new FileWriter("FacultyLogin.txt");
                uid = String.valueOf(numberoffaculty);
                Random r = new Random();
		int p =r.nextInt((99999 - 10000) + 1) + 10000;
                upass = String.valueOf(p);
                 w.write(output);
		w.write(uid.trim()+","+upass.trim()+"\n");
                w.close();
                System.out.println("Password for "+uid+" = "+upass);
        }
        catch(Exception e){
            System.out.println("Error- "+ e.getMessage());
        }
    }
     
     public String CheckPass(String id) {
        String output = "";
        String tempid = "";
        String temppass = "";
        Scanner filescan;
        try{
            filescan = new Scanner(new File("FacultyLogin.txt"));
            filescan.useDelimiter("[,.\n]");
            
            while(filescan.hasNext()){
                tempid = filescan.next();
                temppass = filescan.next();
                
                if(tempid.trim().equals(id.trim())){
                    output = temppass;
                }  
            }
            filescan.close();
        }
        catch(Exception e){
            System.out.println("Error- "+e.getMessage());
        }
        return output;
    }

    public void AddtoFile(){
        	try{
                    
		String output = GetAllFaculty();
                FacultyCount();
		FileWriter w= new FileWriter("Faculty.txt");
		Scanner input =new Scanner (System.in);   
                    numberoffaculty++;
                    System.out.println("Enter Name and Department, Salary (For Faculty ID- "+ numberoffaculty+")");
                    
		uname = input.next();
		uid = String.valueOf(numberoffaculty);
		dept = input.next();
                salary = input.nextDouble();
                 w.write(output);
		 w.write(uid+","+uname+","+dept+","+salary+"\n");
		
                w.close();
                 AddAcc();
    }
	catch (Exception e) {
       System.out.println("Error- "+e.getMessage());
     }
               
    }
   
     public String GetAllFacultyLogin(){
        
        String output ="";
     try{
         File f1 = new File("FacultyLogin.txt");
         Scanner read = new Scanner(f1);
         while(read.hasNextLine()){
             output += read.nextLine();
             output += "\n";
             
         }
         
         
     }
    catch (Exception e) {
       System.out.println("Error- "+e.getMessage());
     }
       return output;
        
    }
    public String GetAllFaculty(){
        
        String output ="";
     try{
         File f1 = new File("Faculty.txt");
         Scanner read = new Scanner(f1);
         while(read.hasNextLine()){
             output += read.nextLine();
             output += "\n";
             
         }
         
         
     }
    catch (Exception e) {
       System.out.println("Error- "+e.getMessage());
     }
       return output;
        
    }
    
     private static void FacultyCount() {
         String any="";  
         numberoffaculty=0;
         try{
         File f1 = new File("FacultyLogin.txt");
         Scanner read = new Scanner(f1);
         while(read.hasNextLine()){
              any += read.nextLine();
             any += "\n";
             numberoffaculty++;
         }
         
         
     }
    catch (Exception e) {
       System.out.println("Error- "+e.getMessage());
     }
       
        
    }
    
    public String AllDisplayStudent(){
            	String output ="";
     try{
                output = ("_________________________________________________________________\n");
                output += ("|\tId\t|\tName\t|\tDept\t|\tSalary\t|\n");
       
        Scanner filescan;
            
            filescan = new Scanner(new File("Faculty.txt"));
            filescan.useDelimiter("[, , , , \n]");
            output += ("_________________________________________________________________\n");
            while(filescan.hasNext()){
                uid = filescan.next();
                uname = filescan.next();
                dept = filescan.next();
                salary = new Double(filescan.next());
                

                output+= ("|\t"+uid+"\t|\t"+uname+"\t|\t"+dept+"\t|\t"+salary+"\t|\n");
               output += ("_________________________________________________________________\n");
            }
            filescan.close();
  

     }
    catch (Exception e) {
       System.out.println("Error- "+e.getMessage());
     }
       return output;
    }

    public String GetMyInfo(String tempid){
        
        return this.SearchId(tempid);
        
    }

    public String SearchUser(int choice) {
         Scanner input = new Scanner(System.in);
         String temp;
        String output="";
        switch(choice){
            case 1: System.out.println("Enter Id- ");
        String tempid = input.nextLine();
        
                output = SearchId(tempid);
                
                break;
            case 2:   System.out.println("Enter Name- ");
                      temp = input.nextLine();
                output = SearchName(temp);
                break;
            case 3:  System.out.println("Enter Department- ");
                     temp = input.nextLine();
        
                output = SearchDept(temp);
                break;
            case 4: System.out.println("Enter Salary- ");
                    temp = input.nextLine();
                output = SearchSalary(temp);
                break;
            case 5: break;
            default: System.out.println("No valid function exists for choice- "+ choice);
                break;
        }
        
        return output;
        
    }

   protected String SearchId(String tempid) {
        
        
        
        String output= "";
        Scanner filescan;
        try{
            boolean found = false;
            filescan = new Scanner(new File("Faculty.txt"));
            filescan.useDelimiter("[, , , , \n]");
               output = ("_________________________________________________________________\n");
                output += ("|\tId\t|\tName\t|\tDept\t|\tSalary\t|\n");
               output += ("_________________________________________________________________\n");
            while(filescan.hasNext() && !found){
                uid = filescan.next();
                uname = filescan.next();
                dept = filescan.next();
                salary = new Double(filescan.next());
                
                if(tempid.trim().equals(uid.trim())){
                    
                     output+= ("|\t"+uid+"\t|\t"+uname+"\t|\t"+dept+"\t|\t"+salary+"\t|\n");
                output += ("_________________________________________________________________\n");
                    
                }
                
            }
            filescan.close();
        }
        catch(Exception e){
            System.out.println("Error- "+e.getMessage());
        }
        return output;
    }

   protected String SearchName(String temp) {
       
       
       
        String output= "";
        Scanner filescan;
        try{
            
            filescan = new Scanner(new File("Faculty.txt"));
            filescan.useDelimiter("[, , , , \n]");
                          
               output = ("_________________________________________________________________\n");
                output += ("|\tId\t|\tName\t|\tDept\t|\tSalary\t|\n");
                 output += ("_________________________________________________________________\n");
            while(filescan.hasNext()){
                uid = filescan.next();
                uname = filescan.next();
                dept = filescan.next();
                salary = new Double(filescan.next());
               
                if(temp.trim().equals(uname.trim())){
                    
                     output+= ("|\t"+uid+"\t|\t"+uname+"\t|\t"+dept+"\t|\t"+salary+"\t|\n");
               output += ("_________________________________________________________________\n");
                    
                }
                
            }
            filescan.close();
        }
        catch(Exception e){
            System.out.println("Error- "+e.getMessage());
        }
        return output;
    
    }

   protected String SearchDept(String temp) {
     
       String output= "";
        Scanner filescan;
        try{
            
            filescan = new Scanner(new File("Faculty.txt"));
            filescan.useDelimiter("[, , , , \n]");
               output = ("_________________________________________________________________\n");
                output += ("|\tId\t|\tName\t|\tDept\t|\tSalary\t|\n");
                 output += ("_________________________________________________________________\n");
            while(filescan.hasNext()){
                uid = filescan.next();
                uname = filescan.next();
                dept = filescan.next();
                salary = new Double(filescan.next());
               
                
                if(temp.trim().equals(dept.trim())){
                    
                     output+= ("|\t"+uid+"\t|\t"+uname+"\t|\t"+dept+"\t|\t"+salary+"\t|\n");
               output += ("_________________________________________________________________\n");
                    
                }
                
            }
            filescan.close();
        }
        catch(Exception e){
            System.out.println("Error- "+e.getMessage());
        }
        return output;
       
       
       

    }

    private String SearchSalary(String temp) {
      
       
          String output= "";
        Scanner filescan;
        try{
            
            filescan = new Scanner(new File("Faculty.txt"));
            filescan.useDelimiter("[, , , , , , \n]");
               output = ("_________________________________________________________________\n");
                output += ("|\tId\t|\tName\t|\tDept\t|\tSalary\t|\n");
                 output += ("_________________________________________________________________\n");
            while(filescan.hasNext()){
                uid = filescan.next();
                uname = filescan.next();
                dept = filescan.next();
                salary = new Double(filescan.next());
                
                
                if(temp.trim().equals(String.valueOf(salary))){
                    
                     output+= ("|\t"+uid+"\t|\t"+uname+"\t|\t"+dept+"\t|\t"+salary+"\t|\n");
               output += ("_________________________________________________________________\n");
                    
                }
                
            }
            filescan.close();
        }
        catch(Exception e){
            System.out.println("Error- "+e.getMessage());
        }
        return output;
        
    }
}