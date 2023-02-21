import java.io.*;
import java.util.*;
class CreateFile
{
    public void create(String filename)
    {
        try
        {
            File f=new File(filename);
            if(f.createNewFile())
            {
                System.out.println("file created");
            }
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
class Update
{
    public void write(String filename)
    {
        try
        {
            File f1=new File(filename);
            if(!f1.exists())
            {
                f1.createNewFile();
            }
            Scanner sc=new Scanner(System.in);
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
class Reader
{
    public void read(String filename)
    {
        try
        {
            File f=new File(filename);
            if(f.exists())
            {
                Scanner sc=new Scanner(f);
                while(sc.hasNextLine())
                {
                    System.out.println(sc.nextLine());
                }
            }
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
class DeleteFile
{
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
class UpdateLine
{
    public void update(String filename)
    {
        try
        {
            File f=new File(filename);
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
                System.out.println("Enter the new text to be updated");
                String new_text=sc.nextLine();
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
        catch(IOException e)
        {
            System.out.println("Update error");
        }
    }

}
public class Main
{
    public static void main(String[] args)
    {
        while(true)
        {
            System.out.println("1.Create a file\n2.Read a file\n3.Update to particular line in a file\n4.Update a file\n5.Delete the file\n6.End");
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your choice: ");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Creating File");
                    System.out.println("Enter filename");
                    String filename=sc.next();
                    CreateFile c=new CreateFile();
                    c.create(filename);
                    break;
                case 2:
                    Reader r= new Reader();
                    System.out.println("Enter filename");
                    String rfile=sc.next();
                    r.read(rfile);
                    break;
                case 3:
                    UpdateLine u=new UpdateLine();
                    System.out.println("Enter filename");
                    String ufile=sc.next();
                    u.update(ufile);
                    break;
                case 4:
                    System.out.println("Enter filename");
                    String file=sc.next();
                    Update w=new Update();
                    w.write(file);
                    break;
                case 5:
                    DeleteFile d= new DeleteFile();
                    System.out.println("Enter filename");
                    String dfile=sc.next();
                    d.deleteFile(dfile);
                    break;
                case 6:
                    System.exit(0);
            }
        }

    }

}