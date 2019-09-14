import java.io.*;
import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
public class Test {


    static int table[]=new int[10000];
    static int m=0;

  int insert(int key,int m)
  {
  	int probe=key%m;//hash function
  	int c=0;
  	while(table[probe]!=-1)
  	{
  		System.out.println("Collision occured at index:"+probe);
  		probe=(probe+1)%m; //updating hash function linearly for collision resolution
  		c++;
  	}

  	if(c!=0)
  	System.out.println("Collision resolved at index: "+probe);//collision resolved
  	table[probe]=key;//insert key at probe
    return probe;

  }


   public static void main(String args[])throws IOException
  {
     Scanner sc=new Scanner(System.in);
     String word[]=new String[10000];
      String hash[]=new String[10000];
     int hashCode[]=new int[10000];
     Test ob=new Test();

     System.out.println("Enter the number of words");
     m=sc.nextInt();

     for(int i=0;i<m;i++)
     {
       table[i]=-1;
     }

    System.out.println("Enter the words");

     for(int i=0;i<m;i++)
     {
        word[i]=sc.next();
        hashCode[i]=Math.abs(word[i].hashCode());
        int k=ob.insert(hashCode[i],m);
        hash[k]=word[i];

     }
     System.out.println("List of words hashed : ");
     for(int i=0;i<m;i++)
     {
       System.out.println("Word: "+word[i]+ "\tHashCode: "+hashCode[i]);
     }

     /* ====== File part =======*/



    /* enter filename with extension to open and read its content */

    BufferedReader br = new BufferedReader(new FileReader("hash.txt"));

     String st;
     while ((st = br.readLine()) != null)
       System.out.println(st);

/*


    String line = null;
    try
    {

        FileReader fileReader = new FileReader(fname);


        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null)
        {
            System.out.println(line);
        }


        bufferedReader.close();
    }
    catch(IOException ex)
    {
        System.out.println("Error reading file named '" + fname + "'");
    }

*/
    // write to files
    for(int i=0;i<m;i++)
    {
      BufferedWriter writer = new BufferedWriter(new FileWriter("hash.txt", true));
      writer.append(',');
      writer.append(hash[i]);

      writer.close();
    }

    }
   }
