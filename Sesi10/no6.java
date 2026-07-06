package Sesi10;

public class no6 {

    static void demo() {
        NullPointerException t;
        t = new NullPointerException("Coba Throw");
        throw t;

        // Baris ini tidak lagi dikerjakan;
        // System.out.println("Ini tidak lagi dicetak");
    }

    public static void main(String[] args) {
        try {
            demo();
            System.out.println("Selesai");
        } catch (NullPointerException e) {
            System.out.println("Ada pesan error: " + e);
        }
    }
}
/*
 * (analisa: penggunaan kata kunci throw berfungsi untuk melempar exception
 * (NullPointerException) secara
 * sengaja dan paksa keluar dari sebuah method (demo()), yang mengakibatkan
 * baris kode di bawah throw tersebut
 * menjadi tidak terjangkau (unreachable). Ketika method tersebut dipanggil di
 * dalam blok try pada method main(),
 * pelemparan error ini langsung menghentikan sisa eksekusi di dalam blok try
 * (sehingga kalimat "Selesai" tidak dicetak)
 * dan alur program langsung dialihkan ke blok catch yang bersesuaian untuk
 * menangani error tersebut dengan aman agar program tidak crash.)
 */