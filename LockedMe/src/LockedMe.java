import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class LockedMe extends FileOperations{
 static	int  userInput;
	//Function with options
			public static int optionsDisplay()
			{   
				System.out.println("-------------------------------------------------");
				System.out.println("Please Select from the following options ");
				System.out.println("*************************************************");
				System.out.println("*       1. Retrieve files in Ascending order    *");
				System.out.println("*       2. Select to see more options           *");
				System.out.println("*       3. Close the Application                *");
				System.out.println("*************************************************");
				System.out.println("-------------------------------------------------");			
					
				   int input=0;
				   Scanner sc = new Scanner(System.in);
					while (sc.hasNextInt() != true)
					{
						System.out.println("Please select the valid option (1/2/3):");
						sc = new Scanner(System.in);
					    			  
						
					}
					
					input = sc.nextInt(); 													
						
												
									
					if (input!= 1 && input!=2 && input !=3 )
					{   int input1=0;
						System.out.println("Please select the valid option (1/2/3):");
						Scanner sc1 = new Scanner(System.in);
						
						input=input1;
						
					}		
				
					
					return input;							
				
			}

	public static void main(String[] args) {
		
		LockedMe lm = new LockedMe();
		
		//Welcome Message
		System.out.println("-------------------------------------------------");
		System.out.println("*******************Welcome***********************");
		System.out.println("*       Project:  LockedMe.com                  *");
		System.out.println("*     Developer:  Arulselvi Amirrthalingam      *");
		System.out.println("*             Software Analyst                  *");
		System.out.println("*             September 18 2022                 *");
		System.out.println("* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   *");		
		System.out.println("*************************************************");
		System.out.println("-------------------------------------------------");
		//End of Welcome Message		
		
		try {
			
			int userInput = lm.optionsDisplay();
			
			
			while(userInput != 3)
			{		
				
			//Retrieves file names in ascending order
				
			if (userInput == 1)
			{ 
				System.out.println("you have selected option " + userInput);
				System.out.println("******************************");
				File file = new File("C:\\Users\\PrishaKutty\\Documents\\Eclipse\\LockedMe");
				File[] files = file.listFiles();
				System.out.println("The list of files in ascending order");
			    System.out.println("------------------------------------");
			    
				for(File f: files)
				{
			      if (f.getName().endsWith(".txt"))	        	      
			    		  {    	       
			    	       System.out.println("       "+ f.getName()+ "       ");
			    	       
			    		  }
			     }
				
				System.out.println("------------------------------------");
				
				userInput = lm.optionsDisplay();
				
				
			}
			else if (userInput == 2)
			{   
				System.out.println("Please Select from the following options ");
				System.out.println("*************************************************");
				System.out.println("*       1. Add a file                           *");
				System.out.println("*       2. Delete a file                        *");
				System.out.println("*       3. Search for file                      *");
				System.out.println("*       4. Navigate to the main context         *");   
				System.out.println("*************************************************");
				
				Scanner sc1 = new Scanner(System.in);
				
				
				FileOperations fo = new FileOperations();
				int fileOptionSelected =0;
				if (sc1.hasNextInt())
				{
				  fileOptionSelected = sc1.nextInt(); 
				  
				}		
				
				
			    if (fileOptionSelected != 1 && fileOptionSelected!=2 && fileOptionSelected!=3 && fileOptionSelected != 4)
			    {
			    	System.out.println("Please select the valid option (1/2/3/4):");
			    }
			    
				
				
				if (fileOptionSelected ==1)
				{
					try {
						fo.addFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(fileOptionSelected == 2)
				{
					fo.deleteFile();
				}
				else if(fileOptionSelected == 3)
				{
					fo.SearchFile();
				}
				if (fileOptionSelected == 4)
				{
					userInput = lm.optionsDisplay();
				}
				
				
				
			}//end of while
			}
			
			

			
			if  (userInput == 3)
			{
				System.out.println("Closing the Application, Thank you");
				System.exit(0);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.exit(0);
		}
		
	
}

}

