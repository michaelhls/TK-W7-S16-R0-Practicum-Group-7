package Queue;

/**
 * Class untuk merepresentasikan pengunjung wahana.
 */
public class Pengunjung {
    private String nama;
    private String idPemesanan; // Bisa ditambahkan detail lain seperti ID tiket

    public Pengunjung(String nama) {
        this.nama = nama;
        // Generate ID sederhana untuk contoh
        this.idPemesanan = "TKT" + (int)(Math.random() * 10000);
    }

    public String getNama() {
        return nama;
    }

    public String getIdPemesanan() {
        return idPemesanan;
    }

    @Override
    public String toString() {
        // Representasi string dari objek Pengunjung
        return "Pengunjung [Nama: " + nama + ", ID Tiket: " + idPemesanan + "]";
    }
}