package Sesi7.project;

import java.util.ArrayList;

// 1. Interface
interface Transaksional {
    double hitungPajak(double harga);
}

// 2. Abstract Class & 4. Encapsulation
abstract class Produk {
    private String nama;
    protected double harga;

    public Produk(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public abstract void tampilkanDetail(); // Abstract Method

    public String getNama() {
        return nama;
    }
}

// 3. Inheritance & 5. Polimorfisme
class Laptop extends Produk implements Transaksional {
    public Laptop(String nama, double harga) {
        super(nama, harga);
    }

    public void tampilkanDetail() {
        System.out.println("Produk Elektronik: " + getNama() + " | Harga: Rp" + harga);
    }

    public double hitungPajak(double harga) {
        return harga * 0.1; // Pajak 10%
    }
}

// 6. Generic & 7. Collection
class Keranjang<T extends Produk> {
    private ArrayList<T> items = new ArrayList<>();

    public void tambahItem(T item) {
        items.add(item);
    }

    public void cetakStruk() {
        for (T item : items) {
            item.tampilkanDetail();
        }
    }
}