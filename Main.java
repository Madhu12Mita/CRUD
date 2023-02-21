// Program to perform the CRUD operations to a file

// importing the required packages
import java.io.*;
import java.util.*;
// Create a file
class CreateFile
{
    // parameters are name of the file you want to create
    public void create(String filename)
    {
        try
        {
            // File object is created for the passed fielname
            File f=new File(filename);
            // checks if file already exits , if no creates new file
            if(f.createNewFile())
            {
                System.out.println("file created");
            }
            // if file is present it doesnot create duplicate file
            else
            {
                System.out.println("File exists");
            }
        }
        catch(IOException e)
        {
            System.out.println("Error in creating file");
        }
    }
}
// updating the entire file
class Update
{
    // parameters are name of the file you want to update
    public void write(String filename)
    {
        try
        {
            File f1=new File(filename);
            // if file is not present , it creates a new file
            if(!f1.exists())
            {
                f1.createNewFile();
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
        }
        catch(IOException e)
        {
            System.out.println("Write Exception");
        }
    }
}
// reading from the file
class Reader
{
    // parameters are name of the file you want to read
    public void read(String filename)
    {
        try
        {
            File f=new File(filename);
            // checks if file exists or not
            if(f.exists())
            {
                Scanner sc=new Scanner(f);
                // reads line to line by checking if line is present or not
                while(sc.hasNextLine())
                {
                    System.out.println(sc.nextLine());
                }
            }
            // if file doesn't exist
            else
            {
                System.out.println("file doesn't exist");
            }
        }
        catch(IOException e)
        {
            System.out.println("Reading error");
        }
    }
}
// delete the file
class DeleteFile
{
    // parameters are name of the file you want to delete

    public void deleteFile(String filename)
    {
        File file= new File(filename);
        if (file.delete())
        {
            System.out.println("File deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file");
        }
    }
}
// update a particular line in a file

class UpdateLine
{
    // parameters are name of the file and the new text you want to update in the given file
    public void update(String filename,String new_text)
    {
        try
        {
            File f=new File(filename);
            // to check if file exists or not
            if(f.exists())
            {
                Scanner sc=new Scanner(f);
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
                    FileWriter fwrite=new FileWriter(filename);
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

}
//starting point of execution
public class Main
{
    public static void main(String[] args)
    {
        //menu-driven code
        while(true)
        {
            System.out.println("1.Create a file\n2.Read a file\n3.Update to particular line in a file\n4.Update a file\n5.Delete the file\n6.End");
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your choice: ");
            int choice=sc.nextInt();
            switch(choice)
            {
                //create a file
                case 1:
                    System.out.println("Creating File");
                    System.out.println("Enter filename");
                    String filename=sc.next();
                    CreateFile c=new CreateFile();
                    c.create(filename);
                    break;
                // reading a file
                case 2:
                    Reader r= new Reader();
                    System.out.println("Enter filename");
                    String rfile=sc.next();
                    r.read(rfile);
                    break;
                //specific line updation
                case 3:
                    Scanner s=new Scanner(System.in);
                    System.out.println("Enter the new text to be updated");
                    String new_text=s.nextLine();
                    UpdateLine u=new UpdateLine();
                    System.out.println("Enter filename");
                    String ufile=sc.next();
                    u.update(ufile,new_text);
                    break;
                //update the entire file
                case 4:
                    System.out.println("Enter filename");
                    String file=sc.next();
                    Update w=new Update();
                    w.write(file);
                    break;
                //deleting the entire file
                case 5:
                    DeleteFile d= new DeleteFile();
                    System.out.println("Enter filename");
                    String dfile=sc.next();
                    d.deleteFile(dfile);
                    break;
                //end of process
                case 6:
                    System.exit(0);
            }
        }

    }

}
