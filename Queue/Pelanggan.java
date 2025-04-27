package Queue; 

/**
 * Class untuk merepresentasikan pelanggan dalam antrean layanan.
 */
public class Pelanggan {
    private String nama;
    private int nomorAntrean; // Menggunakan nomor antrean sederhana

    // Constructor diubah untuk menerima nomor antrean saat dibuat
    public Pelanggan(String nama, int nomorAntrean) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama pelanggan tidak boleh kosong.");
        }
        this.nama = nama;
        this.nomorAntrean = nomorAntrean;
    }

    public String getNama() {
        return nama;
    }

    public int getNomorAntrean() {
        return nomorAntrean;
    }

    @Override
    public String toString() {
        // Representasi string dari objek Pelanggan
        return "Pelanggan [Nama: " + nama + ", Nomor Antrean: " + nomorAntrean + "]";
    }
}