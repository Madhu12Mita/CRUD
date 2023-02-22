// Program to perform the CRUD operations to a file

// importing the required packages
import java.io.*;
import java.util.*;
class MyFile
{
    /**
     * create a File class Object so that it is accessible to every method
     */
    File file;

    /**
     * Creates a file if doesn't exist
     * @param filename String
     */
    MyFile(String filename)
    {
        try {
            // File object is created for the passed fielname
            this.file = new File(filename);
            // checks if file already exits , if no creates new file
            if (this.file.createNewFile()) {
                System.out.println("file created");
            }
            // if file is present it doesnot create duplicate file
            else {
                System.out.println("File exists");
            }
        } catch (IOException e) {
            System.out.println("Error in creating file");
        }
    }

    /**
     * This method updates a line in a file at the given index
     * @param new_text String
     * @param index int
     * @return boolean value to indicate the success of operation
     */
    public boolean UpdateLine(String new_text, int index)
    {
        try
        {
            // to check if file exists or not
            if(this.file.exists())
            {
                Scanner sc=new Scanner(this.file);
                ArrayList<String> text=new ArrayList<>();
                while(sc.hasNextLine())
                {
                    text.add(sc.nextLine());
                }
                System.out.println(text);
                Scanner s=new Scanner(System.in);
                System.out.println("Enter the line number to be updated: ");
                int index=s.nextInt();
                if(index<text.size())
                {
                    text.set(index,new_text);
                    StringBuilder str= new StringBuilder();
                    for(String i:text)
                    {
                        str.append(i+"\n");
                    }
                    FileWriter fwrite=new FileWriter(this.file);
                    fwrite.write(String.valueOf(str));
                    fwrite.close();
                }
                else
                {
                    System.out.println("Index out of bounds");
                }
            }
            else
            {
                System.out.println("File doesn't exist");
            }

        }
        catch(IOException e)
        {
            System.out.println("Update error");
        }
    }

    /**
     * this method overwrites the file with the given content
     * @param new_text String
     * @return boolean value to indicate the success of operation
     */
    public boolean WriteFile(String new_text)
    {
        try
        {
            // if file is not present , it creates a new file
            if(!this.file.exists())
            {
                System.out.println("File doesn't exist");
                return false;
            }
            Scanner sc=new Scanner(System.in);
            // writing to new file
            FileWriter fwrite =new FileWriter(f1.getName(),true);
            BufferedWriter bw= new BufferedWriter(fwrite);
            System.out.println("Enter the text");
            String text=sc.nextLine();
            bw.write(text);
            bw.newLine();
            bw.close();
            System.out.println("Written");
            return true;
        }
        catch(IOException e)
        {
            System.out.println("Write Exception");
        }
    }

    /**
     * This method writes the content at the given line
     * @param content
     * @param index
     * @return
     */
    public boolean WriteLine(String content,int index)
    {

    }

    /**
     * this methods reads the line at given index line and prints the same
     * @param index int
     * @return boolean value to indicate the success of operation
     */
    public boolean readLine(int index)
    {

    }

    /**
     * this method deletes the file
     * @return boolean value to indicate the success of operation
     */
    public boolean deleteFile()
    {
        if (this.file.delete())
        {
            System.out.println("File deleted successfully");
            return true;
        }
        else
        {
            System.out.println("Failed to delete the file");
            return false;
        }
    }

    /**
     * this method inserts a line at given index
     * @param new_line String
     * @param index int
     * @return boolean value to indicate the success of operation
     */
    public boolean WriteLine(String new_line,int index)
    {

    }

    /**
     * This method deletes the line at the given line index
     * @param index int
     * @return boolean value to indicate the success of operation
     */
    public boolean deleteLine(int index)
    {

    }

    /**
     *  this method reads the line and prints the same
     * @return boolean value to indicate the success of operation
     */
    public boolean readFile()
    {
        try
        {
            // if file is not present , it creates a new file
            if(!this.file.exists())
            {
                System.out.println("File doesn't exist");
                return false;
            }
            Scanner sc=new Scanner(System.in);
            // writing to new file
            FileWriter fwrite =new FileWriter(this.file.getName(),true);
            BufferedWriter bw= new BufferedWriter(fwrite);
            System.out.println("Enter the text");
            String text=sc.nextLine();
            bw.write(text);
            bw.newLine();
            bw.close();
            System.out.println("Written");
            return true;
        }
        catch(IOException e)
        {
            System.out.println("Write Exception");
        }
    }
}
//starting point of execution
public class Main
{
    public static void main(String[] args)
    {
        //menu-driven code
        while(true)
        {

        }
    }
}
