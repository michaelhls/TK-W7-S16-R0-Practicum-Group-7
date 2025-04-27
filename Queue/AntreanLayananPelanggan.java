package Queue; // Gunakan nama package yang sama

import java.util.LinkedList;
import java.util.Queue;


/**
 * Class untuk mengelola antrean layanan pelanggan menggunakan Queue berbasis LinkedList.
 */
public class AntreanLayananPelanggan {
    // Menggunakan LinkedList sebagai implementasi Queue untuk Pelanggan
    private Queue<Pelanggan> antrean;
    private int nomorAntreanTerakhir; // Counter untuk nomor antrean berikutnya

    public AntreanLayananPelanggan() {
        this.antrean = new LinkedList<>(); // Inisialisasi antrean
        this.nomorAntreanTerakhir = 0; // Mulai nomor antrean dari 0 (akan jadi 1 saat pertama kali tambah)
        System.out.println("Sistem Antrean Layanan Pelanggan telah dibuka.");
    }

    /**
     * Menambahkan pelanggan baru ke akhir antrean.
     * @param namaPelanggan Nama dari pelanggan yang akan ditambahkan.
     * @return Nomor antrean yang didapatkan pelanggan.
     * @throws IllegalArgumentException jika nama pelanggan kosong.
     */
    public int tambahPelanggan(String namaPelanggan) {
        // Validasi nama bisa dilakukan di sini atau di class Pelanggan
        if (namaPelanggan == null || namaPelanggan.trim().isEmpty()) {
             System.out.println("Gagal menambahkan: Nama pelanggan tidak boleh kosong.");
             return -1; // Indikasi gagal
             // atau throw new IllegalArgumentException("Nama pelanggan tidak boleh kosong.");
        }

        int nomorBaru = ++nomorAntreanTerakhir; // Increment dulu baru pakai
        Pelanggan pelangganBaru = new Pelanggan(namaPelanggan, nomorBaru);
        boolean berhasilDitambah = antrean.offer(pelangganBaru); // offer() lebih aman

        if (berhasilDitambah) {
            System.out.println("-> Pelanggan '" + pelangganBaru.getNama() + "' dengan nomor antrean [" + pelangganBaru.getNomorAntrean() + "] telah ditambahkan.");
            return nomorBaru;
        } else {
            System.out.println("Gagal menambahkan pelanggan '" + namaPelanggan + "' ke antrean (Mungkin karena masalah kapasitas?).");
            nomorAntreanTerakhir--; // Batalkan increment jika gagal
            return -1; // Indikasi gagal
        }
    }

    /**
     * Melayani (mengeluarkan) pelanggan dari depan antrean.
     * @return Pelanggan yang dilayani, atau null jika antrean kosong.
     */
    public Pelanggan layaniPelangganBerikutnya() {
        Pelanggan pelangganDilayani = antrean.poll(); // poll() mengembalikan null jika antrean kosong
        if (pelangganDilayani != null) {
            System.out.println("<- Melayani: Pelanggan '" + pelangganDilayani.getNama() + "' (Nomor Antrean: " + pelangganDilayani.getNomorAntrean() + ").");
        } else {
            System.out.println("Antrean kosong, tidak ada pelanggan untuk dilayani saat ini.");
        }
        return pelangganDilayani;
    }

    /**
     * Menampilkan semua pelanggan yang sedang dalam antrean.
     */
    public void tampilkanAntrean() {
        System.out.println("\n===== Daftar Antrean Layanan Pelanggan =====");
        if (antrean.isEmpty()) {
            System.out.println("Antrean saat ini kosong.");
        } else {
            int i = 1;
            // Iterasi tanpa mengubah antrean
            for (Pelanggan p : antrean) {
                System.out.println(i + ". Nama: " + p.getNama() + " (Nomor Antrean: " + p.getNomorAntrean() + ")");
                i++;
            }
            // Menampilkan siapa yang berikutnya tanpa mengeluarkan
            Pelanggan berikutnya = antrean.peek(); // peek() melihat elemen depan tanpa menghapus
             if (berikutnya != null) {
                 System.out.println("   (Berikutnya dilayani: " + berikutnya.getNama() + " ["+ berikutnya.getNomorAntrean() +"])");
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
      * Mendapatkan jumlah pelanggan dalam antrean saat ini.
      * @return Jumlah pelanggan dalam antrean.
      */
     public int getJumlahAntrean() {
         return antrean.size();
     }
}