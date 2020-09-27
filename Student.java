import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;





public class Student extends User{
    
    private double mmarks;
    private double fmarks;
    private double cgpa;
    private String dept;
    private static int numberofstudent1 =0;
	private static int numberofstudent2 =0;
    
   
    
    
    private double CalculateCGPA(double m, double f){
        double cgpa = 0;
        double total = 0.4*m+0.6*f;
        if(total<50)
            cgpa =0.00;
        else if(total>= 50 && total<60)
            cgpa = 2.25;
        else if(total >=60 && total<65)
            cgpa = 2.5;
        else if(total >=65 && total<70)
            cgpa = 2.75;
        else if(total >=70 && total<75)
            cgpa = 3.00;
        else if(total >=75 && total<80)
            cgpa = 3.25;
        else if(total >=80 && total<85)
            cgpa = 3.5;
        else if(total >=85 && total<90)
            cgpa = 3.775;
        else
            cgpa = 4.00;
        return cgpa;
    }
    
     protected void AddAcc() {
        
        try{
            
            String output =GetAllStudentsLogin();
		
                   
		
		FileWriter w= new FileWriter("StudentLogin.txt");
                uid = String.valueOf(numberofstudent1);
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
            filescan = new Scanner(new File("StudentLogin.txt"));
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
                
		String output = GetAllStudents();
                StudentCount();
		FileWriter w= new FileWriter("Student.txt");
		Scanner input =new Scanner (System.in);
		
		
		System.out.println("How many student's information do you want to take?");
		int n= input.nextInt();
                w.write(output);
		for (int i=1;i<=n;i++)
		{   
                    numberofstudent1++;
                 System.out.println("Enter Name and Department (For Student ID- "+ numberofstudent1+")");
                    
		uname = input.next();
		uid = String.valueOf(numberofstudent1);
		dept = input.next();
               
                 
		 w.write(uid+","+uname+","+dept+"\n");
                 AddAcc();
		}
                w.close();
    }
	catch (Exception e) {
       System.out.println("Error- "+e.getMessage());
     }
                
    }
	
	 public void AllMarks(){
		try{	
			String output =ReadAllMarks();
		    MarksCount();
		 FileWriter w= new FileWriter("MarkAll.txt");
		 Scanner input =new Scanner (System.in);
		 w.write(output);
		 Scanner filescan;
		 double qm1;
		 double qm2;
		 double mid;
		 double midat;
		 double midper;
		 double midbonus;
		 
		 double qf1;
		 double qf2;
		 double fin;
		 double finat;
		 double finper;
		 double finbonus;
		 filescan = new Scanner(new File("Student.txt"));
            filescan.useDelimiter("[, , , \n]");
           for(int k=0; k<numberofstudent2; k++)
				{
					uid = filescan.next();
					uname = filescan.next();
					dept = filescan.next();
				}
            while(filescan.hasNext()){
				
				
				
                uid = filescan.next();
                uname = filescan.next();
                dept = filescan.next();
				
				numberofstudent2++;
				System.out.println("Enter Midterm Marks of Quiz1(20),Quiz2(20),Attendance(10),Mid(40), Mid Performace(10), Bonus(5)  (For Student ID- "+ numberofstudent2+")");
				
				qm1= input.nextDouble();
				qm2= input.nextDouble();
				midat= input.nextDouble();
				mid= input.nextDouble();
				midper = input.nextDouble();
				midbonus = input.nextDouble();
				mmarks =(qm1+qm2+midat+mid+midper+midbonus) ;
				mmarks = (mmarks<=100)? mmarks:100;
				
				System.out.println("Enter Finelterm Marks of Quiz1(20),Quiz2(20),Attendance(10),Final(40), Final Performace(10), Bonus(5)  (For Student ID- "+ numberofstudent2+")");
				qf1= input.nextDouble();
				qf2= input.nextDouble();
				finat= input.nextDouble();
				fin= input.nextDouble();
				finper = input.nextDouble();
				finbonus = input.nextDouble();
				fmarks = (qm1+qm2+midat+mid+finper+finbonus);
				fmarks = (fmarks<=100)? fmarks:100;
				cgpa = CalculateCGPA(mmarks,fmarks);
				
				 w.write(uid+","+uname+","+dept+","+mmarks+","+fmarks+","+cgpa+"\n");
			} 
			filescan.close();
			w.close();
		}
			
	catch (Exception e)
	{
       System.out.println("Error- "+e.getMessage());
    }
	
    }	
	 
        
    public String GetAllStudentsLogin(){
        
        String output ="";
     try{
         File f1 = new File("StudentLogin.txt");
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
    
    private static void StudentCount() {
            String any="";
            numberofstudent1=0;
     try{
         File f1 = new File("StudentLogin.txt");
         Scanner read = new Scanner(f1);
         while(read.hasNextLine()){
              any += read.nextLine();
             any += "\n";
              numberofstudent1++;
         }
         
         
     }
    catch (Exception e) {
       System.out.println("Error- "+e.getMessage());
     }
      
    } 
	
	private static void MarksCount() {
            String any="";
            numberofstudent2=0;
     try{
         File f1 = new File("MarkAll.txt");
         Scanner read = new Scanner(f1);
         while(read.hasNextLine()){
              any += read.nextLine();
             any += "\n";
             numberofstudent2++;
         }
         
         
     }
    catch (Exception e) {
       System.out.println("Error- "+e.getMessage());
     }
      
    } 
       
    public String GetAllStudents(){
        
        String output ="";
     try{
         File f1 = new File("Student.txt");
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
    public String AllDisplayStudent(){
            	String output ="";
     try{
		 
                output = ("_________________________________________________________________________________________________\n");
                output += ("|\tId\t|\tName\t|\tDept\t|\tMid\t|\tFinal\t|\tcgpa\t|\n");
				output += ("_________________________________________________________________________________________________\n");
        Scanner filescan;
         
            filescan = new Scanner(new File("MarkAll.txt"));
            filescan.useDelimiter("[, , , , , , \n]");
           
            while(filescan.hasNext()){
                uid = filescan.next();
                uname = filescan.next();
                dept = filescan.next();
                mmarks = new Double(filescan.next());
                fmarks = new Double(filescan.next());
                cgpa = new Double(filescan.next());

                output+= ("|\t"+uid+"\t|\t"+uname+"\t|\t"+dept+"\t|\t"+mmarks+"\t|\t"+fmarks+"\t|\t"+cgpa+"\t|\n");
               output += ("_________________________________________________________________________________________________\n");
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
	
	 public String Info(){
            	String output ="";
     try{
                output = ("_________________________________________________\n");
                output += ("|\tId\t|\tName\t|\tDept\t|\n");
				output += ("_________________________________________________\n");
        Scanner filescan;
            
            filescan = new Scanner(new File("Student.txt"));
            filescan.useDelimiter("[, , , \n]");
           
            while(filescan.hasNext()){
                uid = filescan.next();
                uname = filescan.next();
                dept = filescan.next();
               

                output+= ("|\t"+uid+"\t|\t"+uname+"\t|\t"+dept+"\t|\n");
               output += ("_________________________________________________\n");
            }
            filescan.close();
  

     }
    catch (Exception e) {
       System.out.println("Error- "+e.getMessage());
     }
       return output;
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
            case 4: System.out.println("Enter Mid Term Mark- ");
                    temp = input.nextLine();
                output = SearchMmark(temp);
                break;
            case 5: System.out.println("Enter Final Mark- ");
                     temp = input.nextLine();
                output = SearchFmark(temp);
                break;
            case 6: System.out.println("Enter CGPA- ");
                    temp = input.nextLine();
                output = SearchCGPA(temp);
                break;
            case 7: break;
            default: System.out.println("No valid function exists for choice- "+ choice);
                break;
        }
        
        return output;
        
    }

    protected String SearchId(String tempid) {
        
        
        
        String output= "";
        Scanner filescan;
        try{
            
            filescan = new Scanner(new File("MarkAll.txt"));
            filescan.useDelimiter("[, , , , , , \n]");
               output = ("_________________________________________________________________________________________________\n");
                output += ("|\tId\t|\tName\t|\tDept\t|\tMid\t|\tFinal\t|\tcgpa\t|\n");
                 output += ("_________________________________________________________________________________________________\n");
            while(filescan.hasNext()){
                uid = filescan.next();
                uname = filescan.next();
                dept = filescan.next();
                mmarks = new Double(filescan.next());
                fmarks = new Double(filescan.next());
                cgpa = new Double(filescan.next());
                
                if(tempid.trim().equals(uid.trim())){
                    
                     output+= ("|\t"+uid+"\t|\t"+uname+"\t|\t"+dept+"\t|\t"+mmarks+"\t|\t"+fmarks+"\t|\t"+cgpa+"\t|\n");
               output += ("_________________________________________________________________________________________________\n");
                    
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
            
            filescan = new Scanner(new File("MarkAll.txt"));
            filescan.useDelimiter("[, , , , , , \n]");
               output = ("_________________________________________________________________________________________________\n");
                output += ("|\tId\t|\tName\t|\tDept\t|\tMid\t|\tFinal\t|\tcgpa\t|\n");
                 output += ("_________________________________________________________________________________________________\n");
            while(filescan.hasNext()){
                uid = filescan.next();
                uname = filescan.next();
                dept = filescan.next();
                mmarks = new Double(filescan.next());
                fmarks = new Double(filescan.next());
                cgpa = new Double(filescan.next());
                
                if(temp.trim().equals(uname.trim())){
                    
                     output+= ("|\t"+uid+"\t|\t"+uname+"\t|\t"+dept+"\t|\t"+mmarks+"\t|\t"+fmarks+"\t|\t"+cgpa+"\t|\n");
               output += ("_________________________________________________________________________________________________\n");
                    
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
            
            filescan = new Scanner(new File("MarkAll.txt"));
            filescan.useDelimiter("[, , , , , , \n]");
               output = ("_________________________________________________________________________________________________\n");
                output += ("|\tId\t|\tName\t|\tDept\t|\tMid\t|\tFinal\t|\tcgpa\t|\n");
                 output += ("_________________________________________________________________________________________________\n");
            while(filescan.hasNext()){
                uid = filescan.next();
                uname = filescan.next();
                dept = filescan.next();
                mmarks = new Double(filescan.next());
                fmarks = new Double(filescan.next());
                cgpa = new Double(filescan.next());
                
                if(temp.trim().equals(dept.trim())){
                    
                     output+= ("|\t"+uid+"\t|\t"+uname+"\t|\t"+dept+"\t|\t"+mmarks+"\t|\t"+fmarks+"\t|\t"+cgpa+"\t|\n");
               output += ("_________________________________________________________________________________________________\n");
                    
                }
                
            }
            filescan.close();
        }
        catch(Exception e){
            System.out.println("Error- "+e.getMessage());
        }
        return output;
    }

    private String SearchMmark(String temp) {
      
       
        
        String output= "";
        Scanner filescan;
        try{
            
            filescan = new Scanner(new File("MarkAll.txt"));
            filescan.useDelimiter("[, , , , , , \n]");
               output = ("_________________________________________________________________________________________________\n");
                output += ("|\tId\t|\tName\t|\tDept\t|\tMid\t|\tFinal\t|\tcgpa\t|\n");
                 output += ("_________________________________________________________________________________________________\n");
            while(filescan.hasNext()){
                uid = filescan.next();
                uname = filescan.next();
                dept = filescan.next();
                mmarks = new Double(filescan.next());
                fmarks = new Double(filescan.next());
                cgpa = new Double(filescan.next());
                
                if(temp.trim().equals(String.valueOf(mmarks))){
                    
                     output+= ("|\t"+uid+"\t|\t"+uname+"\t|\t"+dept+"\t|\t"+mmarks+"\t|\t"+fmarks+"\t|\t"+cgpa+"\t|\n");
               output += ("_________________________________________________________________________________________________\n");
                    
                }
                
            }
            filescan.close();
        }
        catch(Exception e){
            System.out.println("Error- "+e.getMessage());
        }
        return output;
    }

    private String SearchFmark(String temp) {
        
        
        String output= "";
        Scanner filescan;
        try{
           
            filescan = new Scanner(new File("MarkAll.txt"));
            filescan.useDelimiter("[, , , , , , \n]");
               output = ("_________________________________________________________________________________________________\n");
                output += ("|\tId\t|\tName\t|\tDept\t|\tMid\t|\tFinal\t|\tcgpa\t|\n");
                 output += ("_________________________________________________________________________________________________\n");
            while(filescan.hasNext()){
                uid = filescan.next();
                uname = filescan.next();
                dept = filescan.next();
                mmarks = new Double(filescan.next());
                fmarks = new Double(filescan.next());
                cgpa = new Double(filescan.next());
                
                if(temp.trim().equals(String.valueOf(fmarks))){
                    
                     output+= ("|\t"+uid+"\t|\t"+uname+"\t|\t"+dept+"\t|\t"+mmarks+"\t|\t"+fmarks+"\t|\t"+cgpa+"\t|\n");
               output += ("_________________________________________________________________________________________________\n");
                    
                }
                
            }
            filescan.close();
        }
        catch(Exception e){
            System.out.println("Error- "+e.getMessage());
        }
        return output;
    }

    private String SearchCGPA(String temp) {
    
        String output= "";
        Scanner filescan;
        try{
            
            filescan = new Scanner(new File("MarkAll.txt"));
            filescan.useDelimiter("[, , , , , , \n]");
               output = ("_________________________________________________________________________________________________\n");
                output += ("|\tId\t|\tName\t|\tDept\t|\tMid\t|\tFinal\t|\tcgpa\t|\n");
                 output += ("_________________________________________________________________________________________________\n");
            while(filescan.hasNext()){
                uid = filescan.next();
                uname = filescan.next();
                dept = filescan.next();
                mmarks = new Double(filescan.next());
                fmarks = new Double(filescan.next());
                cgpa = new Double(filescan.next());
                
                if(temp.trim().equals(String.valueOf(cgpa))){
                    
                     output+= ("|\t"+uid+"\t|\t"+uname+"\t|\t"+dept+"\t|\t"+mmarks+"\t|\t"+fmarks+"\t|\t"+cgpa+"\t|\n");
               output += ("_________________________________________________________________________________________________\n");
                    
                }
                
            }
            filescan.close();
        }
        catch(Exception e){
            System.out.println("Error- "+e.getMessage());
        }
        return output;
    }

  
  private String ReadAllMarks(){
	     
        String output ="";
     try{
         File f1 = new File("MarkAll.txt");
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

}
