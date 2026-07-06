package Sesi10;

public class no7 {

    public static void main(String[] args) {
        try {
            throw new Exception("Here's my Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("e.getMessage():" + e.getMessage());
            System.out.println("e.toString():" + e.toString());
            System.out.println("e.printStackTrace():");
            e.printStackTrace();
        }
    }
}

/*
 * (analisa: Program ThrowExample2 menyimpulkan bahwa instansiasi kesalahan umum
 * menggunakan klausa
 * throw new Exception("Pesan") di dalam blok try akan langsung menghentikan
 * alur normal dan melempar
 * objek tersebut untuk ditangkap oleh blok catch (Exception e).)
 */