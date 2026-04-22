package Sesi4;

class BankBNI extends Bank {
    @Override
    void sukuBunga() {
        System.out.println("Suku Bunga dari BNI adalah : 4%");
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        // Logika Overriding: bankTujuan diset otomatis menjadi "BNI"
        super.transferUang(jumlah, rekeningTujuan, "BNI");
    }
}

class BankBCA extends Bank {
    @Override
    void sukuBunga() {
        System.out.println("Suku Bunga dari BCA adalah : 4.5%");
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        // Logika Overriding: bankTujuan diset otomatis menjadi "BCA"
        super.transferUang(jumlah, rekeningTujuan, "BCA");
    }
}