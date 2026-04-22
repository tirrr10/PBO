package Sesi3;

import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nim;
    String nama;
    double nilai;
    String grade;
    String status;

    public Mahasiswa(String nim, String nama, double nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
        tentukanGrade();
    }

    private void tentukanGrade() {
        if (nilai >= 80 && nilai <= 100) {
            grade = "A";
            status = "Lulus";
        } else if (nilai >= 70) {
            grade = "B";
            status = "Lulus";
        } else if (nilai >= 60) {
            grade = "C";
            status = "Lulus";
        } else if (nilai >= 50) {
            grade = "D";
            status = "Tidak Lulus";
        } else if (nilai >= 0 && nilai <= 50) {
            grade = "E";
            status = "Tidak Lulus";
        } else {
            grade = "Error";
            status = "Input nilai anda salah.";
        }
    }
}

public class nilai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();

        System.out.println("Masukkan jumlah data mahasiswa: ");
        int jumlah = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData ke-" + (i + 1));
            System.out.println("NIM     : ");
            String nim = input.nextLine();
            System.out.println("Nama    : ");
            String nama = input.nextLine();
            System.out.println("Nilai   : ");
            double nilai = input.nextDouble();
            input.nextLine();

            Mahasiswa mhs = new Mahasiswa(nim, nama, nilai);
            if (mhs.grade.equals("Error")) {
                System.out.println(mhs.status);
                i--;
            } else {
                listMahasiswa.add(mhs);
            }
        }

        System.out.println("\n====================");
        double totalNilai = 0;
        int lulus = 0, tidakLulus = 0;
        int jmlA = 0, jmlB = 0, jmlC = 0, jmlD = 0, jmlE = 0;
        StringBuilder namaLulus = new StringBuilder();
        StringBuilder namaTidakLulus = new StringBuilder();
        StringBuilder namaA = new StringBuilder(),
                namaB = new StringBuilder(),
                namaC = new StringBuilder(),
                namaD = new StringBuilder(),
                namaE = new StringBuilder();

        for (Mahasiswa mhs : listMahasiswa) {
            System.out.println("NIM     : " + mhs.nim);
            System.out.println("Nama    : " + mhs.nama);
            System.out.println("Nilai   : " + mhs.nilai);
            System.out.println("Grade   : " + mhs.grade);
            System.out.println("====================");

            totalNilai += mhs.nilai;

            // logika statistik
            if (mhs.status.equals("Lulus")) {
                lulus++;
                namaLulus.append(mhs.nama).append(", ");
            } else {
                tidakLulus++;
                namaTidakLulus.append(mhs.nama).append(", ");
            }

            switch (mhs.grade) {
                case "A":
                    jmlA++;
                    namaA.append(mhs.nama).append(", ");
                    break;
                case "B":
                    jmlB++;
                    namaB.append(mhs.nama).append(", ");
                    break;
                case "C":
                    jmlC++;
                    namaC.append(mhs.nama).append(", ");
                    break;
                case "D":
                    jmlD++;
                    namaD.append(mhs.nama).append(", ");
                    break;
                case "E":
                    jmlE++;
                    namaE.append(mhs.nama).append(", ");
                    break;
            }
        }

        // menampilkap rekap
        System.out.println("Jumlah Mahasiswa : " + listMahasiswa.size());
        System.out.println("Jumlah Mahasiswa yang Lulus : " + lulus + " yaitu " + bersihkanKoma(namaLulus));
        System.out.println(
                "Jumlah Mahasiswa yang Tidak Lulus : " + tidakLulus + " yaitu " + bersihkanKoma(namaTidakLulus));
        if (jmlA > 0)
            System.out.println("Jumlah Mahasiswa dengan nilai A = " + jmlA + " yaitu " + bersihkanKoma(namaA));
        if (jmlB > 0)
            System.out.println("Jumlah Mahasiswa dengan nilai B = " + jmlB + " yaitu " + bersihkanKoma(namaB));
        if (jmlC > 0)
            System.out.println("Jumlah Mahasiswa dengan nilai C = " + jmlC + " yaitu " + bersihkanKoma(namaC));
        if (jmlD > 0)
            System.out.println("Jumlah Mahasiswa dengan nilai D = " + jmlD + " yaitu " + bersihkanKoma(namaD));
        if (jmlE > 0)
            System.out.println("Jumlah Mahasiswa dengan nilai E = " + jmlE + " yaitu " + bersihkanKoma(namaE));

        double ratarata = totalNilai / listMahasiswa.size();
        System.out.printf("Rata-rata nilai mahasiswa adalah : %.2f\n", ratarata);
    }

    private static String bersihkanKoma(StringBuilder sb) {
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 2);
        }
        return "-";
    }
}
