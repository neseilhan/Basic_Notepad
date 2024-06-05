import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

            // ------ OPSİYONEL --------
            ArrayList<String> metinListesi = new ArrayList<>(); //saklamak icin bir arrayList olustur
            while (okunanMetin != null) { //dosyadan okunan verileri boş degilse arrayList'e ekle
                metinListesi.add(okunanMetin);
                okunanMetin = bufferedReader.readLine();
            }
            for (String satir : metinListesi) {
                System.out.println(satir);
            }
            bufferedReader.close();
        }
        catch(IOException e){
            e.getStackTrace();
        }
    }
}
