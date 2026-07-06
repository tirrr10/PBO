package Sesi11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "D:\\students.csv"; // Sesuaikan dengan path file Anda
        String line;
        String csvSplitBy = ",";
        int indeks = 0;
        int jumlahBarisData = 0;

        System.out.println("NIM, NAMA, UMUR, PRODI");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                indeks++;
                if (indeks > 1) { // Melewati header (NIM, NAMA, dll)
                    String[] student = line.split(csvSplitBy);
                    System.out.println(student[0] + ", " + student[1] + ", " + student[2] + ", " + student[3]);
                    jumlahBarisData++;
                }
            }
            System.out.println("-----------------------------------");
            System.out.println("Total jumlah baris data: " + jumlahBarisData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}