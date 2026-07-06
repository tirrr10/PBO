package Sesi10;

/* 
public class no1 {
    public static void main(String[] args) {
        int a[] = new int[5];
        a[5] = 100;
    }
}
    (Mengapa terjadi error? karna baris a[5] = 100; mencoba mengisi data ke indeks '5'. karna indeks
    maksimalnya adalah '4'. program akan langsung berhenti dan melempar(throw) sebuah exception.)
*/

// perbaikan kode//
public class no1 {
    public static void main(String[] args) {
        int a[] = new int[5];
        try {
            a[5] = 100;
        } catch (Exception e) {
            System.out.println("Terjadi pelanggaran memory");
        }
    }
}