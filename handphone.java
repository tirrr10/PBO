package Sesi2;

public class handphone {
    String jenis_hp;
    int tahun_pembuatan;

    public void setDataHP(String jenis_hp, int tahun_pembuatan) {
        this.jenis_hp = jenis_hp;
        this.tahun_pembuatan = tahun_pembuatan;
    }

    // perbaikan = menambah return value
    public String getJenisHP() {
        return jenis_hp;
    }

    public int getTahunPembuatan() {
        return tahun_pembuatan;
    }

    public static void main(String[] args) {
        handphone hp = new handphone();

        // perbaikan = memberikan nilai konkret saat memanggil method
        hp.setDataHP("Samsung", 2023);

        // perbaikan = menambahkan system.out.println agar hasilnya terlihat
        System.out.println("Jenis HP: " + hp.getJenisHP());
        System.out.println("Tahun: " + hp.getTahunPembuatan());
    }
}