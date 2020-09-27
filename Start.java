
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


class project {

    
    
   
    
    private static void WriteLogin(){
        Scanner input =new Scanner (System.in);
        try{
                    
		
		FileWriter w= new FileWriter("Login.txt");
		
		
		
		System.out.print("Initializing sofware for the 1st time.\nSelecet an admin name and password.\nUser Name -");
		String name= input.nextLine();
                
                System.out.print("Password- ");
                
                String pass = input.nextLine();
		w.write(name.trim()+","+pass.trim()+"\n");
                w.close();
        }
        catch(Exception e){
            System.out.println("Error- "+ e.getMessage());
        }
        
        
        
    }
    private static void CreateLoginFile(){
     
         try{
        File f1 = new File("Login.txt");
      boolean b = f1.createNewFile();
      if (b) {
        WriteLogin();
      }
      
    }
    catch(Exception e) {
      System.out.println("Error- "+e.getMessage());
    }
    
    }  
    private static void CreateStudentFile(){
       
		
    try{
        File f1 = new File("Student.txt");
      boolean b = f1.createNewFile();
      if (b) {
        
      }
    }
    catch(Exception e) {
      System.out.println("Error- "+e.getMessage());
    }
 
    }
    private static void CreateFacultyFile(){
         try{
        File f1 = new File("Faculty.txt");
      boolean b = f1.createNewFile();
      if (b) {
        
      }
    }
    catch(Exception e) {
      System.out.println("Error- "+e.getMessage());
    }
         
    }
    private static void CreateStudentLoginFile() {
        try{
        File f1 = new File("StudentLogin.txt");
      boolean b = f1.createNewFile();
    }
    catch(Exception e) {
      System.out.println("Error- "+e.getMessage());
    }
    }  
    private static void CreateFacultytLoginFile() {
        try{
        File f1 = new File("FacultyLogin.txt");
      boolean b = f1.createNewFile();
    }
    catch(Exception e) {
      System.out.println("Error- "+e.getMessage());
    }
    }  
	
	private static void CreateMarkAllFile() {
        try{
        File f1 = new File("MarkAll.txt");
      boolean b = f1.createNewFile();
    }
    catch(Exception e) {
      System.out.println("Error- "+e.getMessage());
    }
    }  


    public static void main(String[] args) {
		
        CreateLoginFile();
        CreateStudentLoginFile();
        CreateStudentFile();
        CreateFacultyFile();
		CreateFacultytLoginFile();
		CreateMarkAllFile();
         
        int log;
        
        System.out.println("Please Enter your choice(type the choice's number): \n1. Login as Admin\n2. Login as Student\n3. Login as Faculty\n4. Exit");
        Scanner input = new Scanner(System.in);
        log = input.nextInt();
        switch(log){
            case 1: LoginAdmin la = new LoginAdmin();
                break;
            case 2: LoginStudent ls = new  LoginStudent();
                break;
            case 3: LoginFaculty lf = new  LoginFaculty();
                break;
            case 4: System.out.println("Process Terminating");
                break;
            default: System.out.println("No valid function exists for choice- "+ log);
                break;
                }
        
    }

    

 
   
}
