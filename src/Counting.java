import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.*;

public class Counting {
    public static void main(String args[]) {

        BufferedReader in = null;
        try {

            BufferedReader br = new BufferedReader(new FileReader("test1130.txt"));
            FileOutputStream output = new FileOutputStream("convert.txt");
            while(true) {
                String line = br.readLine();
                if (line==null) break;
                //System.out.print(line);
                //System.out.println(line);
                output.write(line.getBytes());
            }



            br.close();
            output.close();




            in = new BufferedReader(new FileReader("convert.txt"));



            String read = null;
            while ((read = in.readLine()) != null) {
                String[] splited = read.split("\\W");


                int [] arr = new int [splited.length];

                for(int i = 0; i < splited.length ; i++){
                    for(int j = 0 ; j < splited.length ; j++){
                        if(splited[i].equals(splited[j]))
                            arr[i]++;
                    }
                }

                for(int i = 0; i < splited.length ; i++){
                    for(int j = i+1 ; j < splited.length ; j++){
                        if(splited[i].equals(splited[j]))
                            arr[j] = 0;
                    }
                    if(arr[i] != 0)
                        System.out.println(splited[i] + " : " +arr[i]);
                }
            }
        } catch (IOException e) {
            System.out.println("There was a problem: " + e);
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }
    }

}