import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class notepad {
    public static void main(String[] args) throws IOException{
        Scanner inp = new Scanner(System.in);
        System.out.println("*****************NOTEPAD*******************");
        String metin = inp.nextLine();

        File notlar = new File("notlar.txt");

        if(notlar.exists()){
            System.out.println("Dosya mevcut.");
        }
        else{
            notlar.createNewFile();
            System.out.println("Yeni dosya olusturuldu.");
        }

        try{
            FileWriter fileWriter = new FileWriter("notlar.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(metin);
            printWriter.close();
        }
        catch (IOException e){
            e.getStackTrace();
        }
        try {
            FileReader fileReader = new FileReader("notlar.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String okunanMetin = bufferedReader.readLine();

            bufferedReader.close();
        }
        catch(IOException e){
            e.getStackTrace();
        }
    }
}
