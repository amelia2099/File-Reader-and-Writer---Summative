/*
 * Made by Amelia Kunze
 * March 8, 2016
 * Purpose: to allow the user to find and replace a key word or phrase in a pre-existing text file. 
 */
 
package filereaderandwriter;

/**
 *
 * @author amkun2099
 */

 
import java.io.*;
import java.util.Scanner; 

public class FileReaderAndWriter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //accesses BookExcerpt.txt which exists on the y drive, assings this information to a File variable textFile
        File textFile = new File("y:\\BookExcerpt.txt");  

        FileWriter out;    //Creates FileWriter object 'out'  
        BufferedWriter writeFile;   //Creates BufferedWriter constructor to output text
        
        FileReader in;    
        BufferedReader readFile;  

        Scanner input = new Scanner(System.in);  //Creates new scanner 'input'

       
        String search;
        String replace;
        String lineOfText;
        String story= "";
        
        
        try {
            
            System.out.println("What word or phrase would you like to search for? "); //prompts the user for imput
            search = input.nextLine();  //Scanner assigns user input to string varaible search
            System.out.println("Enter the text with which you would like to replace the above text.");
            replace = input.nextLine();
            
            in = new FileReader(textFile);  //'in' FileReader now reads disgnated text file
            readFile = new BufferedReader (in); //'in' passed to 'readFile' Buffered Reader to improve efficiency
        
            //the while loop will continue to read the document and assign the data to lineOfText as long as there is data on the line
              while ((lineOfText = readFile.readLine())!= null){  
                story = lineOfText; //assigns the text data to story
            }   
             
             readFile.close(); //closes the buffered reader
             in.close();       //closes the file reader
               
            out = new FileWriter(textFile);  //'out' FileWriter now opens output to designated text file (note that data is overwritten)
            writeFile = new BufferedWriter(out); //'out' passed to 'writeFile' Buffered Writer to improve efficiency
             
            //replaceAll method searches through text in string variable to find and replace the data as designated by user
            story = story.replaceAll(search, replace); 
               writeFile.write(story); 
               System.out.println(story); 
                
            writeFile.close(); 
            out.close();       
        
        //exception handler outputs error message at termination if file cannot be created or found (via designated path)         
        } catch (FileNotFoundException e){   
            System.out.println("File does not exist or could not be found.");
            System.err.println("FileNoteFoundException: "+ e.getMessage());  //Fetches and prints specific error message

        //exception handler outputs error message at termination if file cannot be read 
        } catch (IOException e){            
                System.out.println("Problems reading file.");
            System.err.println("IOException: "+ e.getMessage());
        }
    }
    
}
