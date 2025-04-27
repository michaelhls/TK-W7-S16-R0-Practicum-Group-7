package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class untuk mengelola antrean wahana menggunakan Queue berbasis LinkedList.
 */
public class AntreanWahana {
    // Menggunakan LinkedList sebagai implementasi Queue
    private Queue<Pengunjung> antrean;
    private String namaWahana; // Tetap private

    public AntreanWahana(String namaWahana) {
        this.namaWahana = namaWahana;
        this.antrean = new LinkedList<>(); // Inisialisasi antrean
        System.out.println("Antrean untuk wahana '" + namaWahana + "' telah dibuka.");
    }

    /**
     * Menambahkan pengunjung baru ke akhir antrean.
     * @param namaPengunjung Nama dari pengunjung yang akan ditambahkan.
     */
    public void tambahPengunjung(String namaPengunjung) {
        Pengunjung pengunjungBaru = new Pengunjung(namaPengunjung);
        antrean.offer(pengunjungBaru); // offer() lebih aman, tidak melempar exception jika gagal
        System.out.println("-> " + pengunjungBaru.getNama() + " (ID: " + pengunjungBaru.getIdPemesanan() + ") telah ditambahkan ke antrean " + namaWahana + ".");
    }

    /**
     * Melayani (mengeluarkan) pengunjung dari depan antrean.
     * @return Pengunjung yang dilayani, atau null jika antrean kosong.
     */
    public Pengunjung layaniPengunjungBerikutnya() {
        Pengunjung pengunjungDilayani = antrean.poll(); // poll() mengembalikan null jika antrean kosong
        if (pengunjungDilayani != null) {
            System.out.println("<- Melayani: " + pengunjungDilayani.getNama() + " (ID: " + pengunjungDilayani.getIdPemesanan() + ") untuk naik wahana " + namaWahana + ".");
        } else {
            System.out.println("Antrean " + namaWahana + " kosong, tidak ada pengunjung untuk dilayani.");
        }
        return pengunjungDilayani;
    }

    /**
     * Menampilkan semua pengunjung yang sedang dalam antrean.
     */
    public void tampilkanAntrean() {
        System.out.println("\n===== Daftar Antrean Wahana: " + namaWahana + " =====");
        if (antrean.isEmpty()) {
            System.out.println("Antrean saat ini kosong.");
        } else {
            int nomor = 1;
            // Iterasi tanpa mengubah antrean
            for (Pengunjung p : antrean) {
                System.out.println(nomor + ". " + p.getNama() + " (ID: " + p.getIdPemesanan() + ")");
                nomor++;
            }
            // Menampilkan siapa yang berikutnya tanpa mengeluarkan
            Pengunjung berikutnya = antrean.peek(); // peek() melihat elemen depan tanpa menghapus
             if (berikutnya != null) {
                 System.out.println("   (Berikutnya dilayani: " + berikutnya.getNama() + ")");
             }
        }
        System.out.println("=========================================\n");
    }

    /**
     * Memeriksa apakah antrean kosong.
     * @return true jika antrean kosong, false jika tidak.
     */
     public boolean isAntreanKosong() {
         return antrean.isEmpty();
     }

    /**
     * [FIXED] Mengembalikan nama wahana.
     * @return Nama wahana.
     */
    public String getNamaWahana() {
        return this.namaWahana;
    }
}