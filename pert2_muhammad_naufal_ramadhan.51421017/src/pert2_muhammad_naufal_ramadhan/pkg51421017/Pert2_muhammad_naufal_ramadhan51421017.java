package pert2_muhammad_naufal_ramadhan.pkg51421017;

class Hewan {
    // Encapsulation
    private String nama;
    private int energi; // Atribut energi

    // Konstruktor
    public Hewan(String nama, int energi) {
        this.nama = nama;
        this.energi = energi;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Getter untuk energi
    public int getEnergi() {
        return energi;
    }

    // Setter untuk energi
    public void setEnergi(int energi) {
        this.energi = energi;
    }

    // Metode untuk suara hewan
    public void bersuara() {
        System.out.println("Hewan ini bersuara");
    }

    // Metode untuk berjalan
    public void berjalan() {
        if (energi >= 5) {
            energi -= 5;
            System.out.println(nama + " berjalan dan mengurangi energi. Energi sekarang: " + energi);
        } else {
            System.out.println(nama + " tidak memiliki energi yang cukup untuk berjalan.");
        }
    }

    // Metode untuk makan
    public void makan() {
        energi += 4;
        System.out.println(nama + " makan dan menambah energi. Energi sekarang: " + energi);
    }
}

// Kelas turunan (inheritance)
class Kucing extends Hewan {
    // Konstruktor
    public Kucing(String nama, int energi) {
        super(nama, energi); // Memanggil konstruktor kelas dasar
    }

    // Polymorphism
    @Override
    public void bersuara() {
        System.out.println(getNama() + " berkata: Meow!");
    }
}

// Kelas turunan lainnya
class Anjing extends Hewan {
    // Konstruktor
    public Anjing(String nama, int energi) {
        super(nama, energi); // Memanggil konstruktor kelas dasar
    }

    // Polymorphism
    @Override
    public void bersuara() {
        System.out.println(getNama() + " berkata: Bark!");
    }
}

public class Pert2_muhammad_naufal_ramadhan51421017 {

    public static void main(String[] args) {
        Hewan kucing = new Kucing("Kitty", 10);
        Hewan anjing = new Anjing("Buddy", 8);

        kucing.bersuara();
        anjing.bersuara();

        kucing.berjalan();
        kucing.makan();
        anjing.berjalan();
        anjing.makan();
    }
}
