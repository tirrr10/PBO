package Sesi10;

class Propagate {

    public static void main(String[] args) {
        try {
            // Skenario 1 (Kondisi Awal):
            System.out.println(reverse("This is a string"));

            // Skenario 2 (Sesuai Perintah: Hapus isi/kosongkan string):
            // System.out.println(reverse(""));
        } catch (Exception e) {
            System.out.println("The String was blank");
        } finally {
            System.out.println("All done");
        }
    }

    public static String reverse(String s) throws Exception {
        if (s.length() == 0) {
            throw new Exception();
        }

        String reverseStr = "";
        for (int i = s.length() - 1; i >= 0; --i) {
            reverseStr += s.charAt(i);
        }
        return reverseStr;
    }
}