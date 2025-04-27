package Queue; 

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class untuk mengelola antrean layanan pelanggan menggunakan Queue berbasis LinkedList.
 * Termasuk pengukuran waktu eksekusi untuk operasi inti.
 */
public class AntreanLayananPelanggan {
    private Queue<Pelanggan> antrean;
    private int nomorAntreanTerakhir;

    public AntreanLayananPelanggan() {
        this.antrean = new LinkedList<>();
        this.nomorAntreanTerakhir = 0;
        System.out.println("Sistem Antrean Layanan Pelanggan telah dibuka.");
    }

    /**
     * Menambahkan pelanggan baru ke akhir antrean dan mengukur waktu eksekusi offer().
     * @param namaPelanggan Nama dari pelanggan yang akan ditambahkan.
     * @return Nomor antrean yang didapatkan pelanggan.
     */
    public int tambahPelanggan(String namaPelanggan) {
        if (namaPelanggan == null || namaPelanggan.trim().isEmpty()) {
            System.out.println("Gagal menambahkan: Nama pelanggan tidak boleh kosong.");
            return -1;
        }

        int nomorBaru = ++nomorAntreanTerakhir;
        Pelanggan pelangganBaru = new Pelanggan(namaPelanggan, nomorBaru);

        long startTime = System.nanoTime();
        boolean berhasilDitambah = antrean.offer(pelangganBaru); // Ukur waktu eksekusi offer()
        long endTime = System.nanoTime();

        long duration = endTime - startTime; 

        if (berhasilDitambah) {
            System.out.println("-> Pelanggan '" + pelangganBaru.getNama() + "' dengan nomor antrean [" + pelangganBaru.getNomorAntrean() + "] telah ditambahkan.");
            System.out.println("   (Waktu eksekusi offer(): " + duration + " ns)"); // Cetak waktu eksekusi
            return nomorBaru;
        } else {
            System.out.println("Gagal menambahkan pelanggan '" + namaPelanggan + "' ke antrean.");
            nomorAntreanTerakhir--;
            return -1;
        }
    }

    /**
     * Melayani (mengeluarkan) pelanggan dari depan antrean dan mengukur waktu eksekusi poll().
     * @return Pelanggan yang dilayani, atau null jika antrean kosong.
     */
    public Pelanggan layaniPelangganBerikutnya() {
        if (antrean.isEmpty()) {
             System.out.println("Antrean kosong, tidak ada pelanggan untuk dilayani saat ini.");
             return null;
        }

        long startTime = System.nanoTime();
        Pelanggan pelangganDilayani = antrean.poll(); // Ukur waktu eksekusi poll()
        long endTime = System.nanoTime();

        long duration = endTime - startTime; 

        if (pelangganDilayani != null) { // Seharusnya tidak null karena sudah dicek isEmpty, tapi untuk keamanan
            System.out.println("<- Melayani: Pelanggan '" + pelangganDilayani.getNama() + "' (Nomor Antrean: " + pelangganDilayani.getNomorAntrean() + ").");
            System.out.println("   (Waktu eksekusi poll(): " + duration + " ns)"); // Cetak waktu eksekusi
        }
        // (Tidak perlu else karena sudah ditangani di awal)

        return pelangganDilayani;
    }

    /**
     * Menampilkan semua pelanggan yang sedang dalam antrean.
     * (Tidak diukur waktunya secara eksplisit di sini, fokus pada offer/poll)
     */
    public void tampilkanAntrean() {
        System.out.println("\n===== Daftar Antrean Layanan Pelanggan =====");
        if (antrean.isEmpty()) {
            System.out.println("Antrean saat ini kosong.");
        } else {
            int i = 1;
            for (Pelanggan p : antrean) {
                System.out.println(i + ". Nama: " + p.getNama() + " (Nomor Antrean: " + p.getNomorAntrean() + ")");
                i++;
            }
            Pelanggan berikutnya = antrean.peek();
             if (berikutnya != null) {
                 System.out.println("   (Berikutnya dilayani: " + berikutnya.getNama() + " ["+ berikutnya.getNomorAntrean() +"])");
             }
        }
        System.out.println("=========================================\n");
    }

    public boolean isAntreanKosong() {
        return antrean.isEmpty();
    }

    public int getJumlahAntrean() {
        return antrean.size();
    }
}