import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {
public static String filePath= "C:\\Users\\PrishaKutty\\Documents\\Eclipse\\LockedMe";

    //This Method adds the file to root directory
	public void addFile() throws IOException
	{
		System.out.println("Please Enter the text file name to add: ");
    	Scanner sc = new Scanner(System.in);
    	String fileName;
    	fileName=sc.next();
    	
    	
    	if (fileName.contains(".txt"))  
    	{  		
    	  //file = new File(fileName.toLowerCase());
    		fileName= fileName.toLowerCase();
    	}
    	else {
    		 
    		// file = new File(fileName.toLowerCase()+".txt");
    		fileName=(fileName.toLowerCase()+".txt");
    		}
    	File file = new File(filePath+"\\"+fileName);
    	try {
    		if (file.exists())
        	{
        		System.out.println("File exists in the same name, try different name");
        		
        	}
    		else {
    		OutputStream out = new FileOutputStream(file);
    		out.close();
    		out.flush();
    		System.out.println("*******************************************************");
        	System.out.println("The text file "+ fileName+ " is added to the Directory");
        	System.out.println("*******************************************************");
    		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
	}
	
	 //This Method Delete the file to root directory
	public void deleteFile()
	{
		System.out.println("Please Enter the file name to delete: ");
    	Scanner sc1 = new Scanner(System.in);
    	String fileName;
    	fileName=sc1.next();
    	System.out.println("The file you selected to delete is "+ fileName);
    	
    	
    	
    	if (fileName.endsWith(".txt"))
    	{
    		fileName= fileName.toLowerCase();
    	}
    	else
    	{
    		
    		fileName=(fileName.toLowerCase()+".txt");
    	}
    File file = new File(filePath+"\\\\"+fileName);
    		 
    	
        try {
			if (file.exists())
			{
				Path path = FileSystems.getDefault().getPath(fileName);
				
		        try {
		            Files.delete(path);
		            System.out.println("*****************************************");
				    System.out.println("File "+ fileName + " deleted successfully");
				    System.out.println("*****************************************");
		             } 
		        catch (NoSuchFileException e) {
		            System.out.println(
		                "No such file/directory exists, please try again");
		        }
		        catch (DirectoryNotEmptyException e) {
		            System.out.println("Directory is not empty.");
		        }
		        catch (IOException e) {
		            System.out.println("Invalid permissions.");
		        }
			}				
					
			else {
				System.out.println("***************************************************************************");
				System.out.println("File "+ fileName+ " does not exist, please enter the file name correctly");
			    System.out.println("Failed to delete the file");
			    System.out.println("****************************************************************************");
			}
        
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	 //This Method Search the file to root directory
	public void SearchFile()
	{
		
		System.out.println("Please Enter the text file name to Search: ");
    	Scanner sc = new Scanner(System.in);
    	
    	String fileName;
    	int flag =0;// flag to notify file not found
    	fileName=sc.next();
    	
    	File file;
    	if (fileName.contains(".txt"))
    	{
    		fileName=fileName.toLowerCase();
    	}
    	else
    	{
    		fileName=fileName.toLowerCase()+".txt";
    	}
    	try {
			    
				file = new File(filePath);
				File[] files = file.listFiles();
				
				
				
			
				List <String> list = new ArrayList<String>();
		          
					for(File f: files)
					{
						list.add(f.getName()); 
					}
		      
				   
					
					for (int i = 0; i < list.size(); i++) 
					{   
						//System.out.println(fileName);
						//System.out.println(list.get(i));
					  if (fileName.equals(list.get(i).toString()))
					   {					
						System.out.println("file "+ fileName+" found");
						flag=1;
						break;
					   }  
					  					 					
				   }
					if (flag==0)
					{
						System.out.println("file NOT found");
					}
			 
    	}
		catch (Exception e) {
		
		e.printStackTrace();}
	}
}
	
	

