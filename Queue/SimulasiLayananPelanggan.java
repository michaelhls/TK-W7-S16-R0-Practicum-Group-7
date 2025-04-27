package Queue; 
import java.util.Scanner;

/**
 * Class utama untuk menjalankan simulasi antrean layanan pelanggan.
 */
public class SimulasiLayananPelanggan {

    public static void main(String[] args) {
        // Membuat objek antrean untuk layanan pelanggan
        AntreanLayananPelanggan antreanLayanan = new AntreanLayananPelanggan();
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        do {
            System.out.println("\n--- Menu Simulasi Antrean Layanan Pelanggan ---");
            System.out.println("Jumlah Pelanggan dalam Antrean: " + antreanLayanan.getJumlahAntrean());
            System.out.println("1. Tambah Pelanggan ke Antrean");
            System.out.println("2. Layani Pelanggan Berikutnya");
            System.out.println("3. Tampilkan Antrean Saat Ini");
            System.out.println("4. Keluar Simulasi");
            System.out.print("Masukkan pilihan Anda: ");

            try {
                // Membaca input sebagai string untuk menghindari masalah newline
                String input = scanner.nextLine();
                pilihan = Integer.parseInt(input);

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan nama pelanggan: ");
                        String nama = scanner.nextLine();
                        // Validasi dasar sudah ada di AntreanLayananPelanggan
                        int nomor = antreanLayanan.tambahPelanggan(nama);
                        if (nomor != -1) {
                            // Pesan sukses sudah dicetak di dalam metode tambahPelanggan
                        }
                        break;
                    case 2:
                        Pelanggan dilayani = antreanLayanan.layaniPelangganBerikutnya();
                        if (dilayani != null) {
                           // Pesan sudah dicetak di dalam metode layaniPelangganBerikutnya
                        }
                        break;
                    case 3:
                        antreanLayanan.tampilkanAntrean();
                        break;
                    case 4:
                        System.out.println("Mengakhiri simulasi antrean layanan pelanggan. Terima kasih!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid (1-4). Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka pilihan menu (1-4).");
            } catch (Exception e) {
                // Menangkap exception lain jika terjadi
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                e.printStackTrace(); // Cetak stack trace untuk debugging jika perlu
            }

            // Beri jeda singkat agar output lebih mudah dibaca (opsional)
            // try {
            //      if (pilihan != 4) Thread.sleep(300);
            // } catch (InterruptedException e) {
            //     Thread.currentThread().interrupt();
            // }

        } while (pilihan != 4);

        scanner.close(); // Tutup scanner
        System.out.println("Scanner ditutup.");
    }
}