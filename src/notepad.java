import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class notepad {
    public static void main(String[] args) throws IOException {
        Scanner inp = new Scanner(System.in);
        System.out.println("*****************NOTEPAD*******************");

        File notlar = new File("notlar.txt");

        if (notlar.exists()) {
            System.out.println("Dosya mevcut.");
        } else {
            notlar.createNewFile();
            System.out.println("Yeni dosya olusturuldu.");
        }

        try {
            // En son kaydedilen metni oku
            FileReader fileReader = new FileReader("notlar.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String okunanMetin = bufferedReader.readLine();

            // ------ OPSİYONEL --------
            ArrayList<String> metinListesi = new ArrayList<>(); // saklamak için bir arrayList oluştur
            while (okunanMetin!= null) { // dosyadan okunan verileri boş değilse arrayList'e ekle
                metinListesi.add(okunanMetin);
                okunanMetin = bufferedReader.readLine();
            }

            System.out.println("En son kaydedilen metin:");
            for (String satir : metinListesi) {
                System.out.println(satir);
            }

            bufferedReader.close();

            // Kullanıcıdan metin girişi al
            System.out.print("Metin giriniz: ");
            String inputText = inp.nextLine();

            // Metni dosyaya kaydet
            FileWriter fileWriter = new FileWriter("notlar.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(inputText + "\n");
            bufferedWriter.close();

            System.out.println("Metin başarıyla kaydedildi!");
        } catch (IOException e) {
            System.err.println("Hata: " + e.getMessage());
        }
    }
}
