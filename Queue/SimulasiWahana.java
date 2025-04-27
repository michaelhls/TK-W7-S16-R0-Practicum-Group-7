package Queue;

import java.util.Scanner;

/**
 * Class utama untuk menjalankan simulasi antrean wahana di taman bermain.
 */
public class SimulasiWahana { // Nama file sesuai error Anda

    public static void main(String[] args) {
        // Membuat objek antrean untuk wahana Roller Coaster
        AntreanWahana antreanRollerCoaster = new AntreanWahana("Roller Coaster");
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        do {
            System.out.println("\n--- Menu Simulasi Antrean Wahana ---");
            // [FIXED] Menggunakan getter untuk mengakses nama wahana
            System.out.println("Wahana: " + antreanRollerCoaster.getNamaWahana());
            System.out.println("1. Tambah Pengunjung ke Antrean");
            System.out.println("2. Layani Pengunjung Berikutnya");
            System.out.println("3. Tampilkan Antrean Saat Ini");
            System.out.println("4. Keluar Simulasi");
            System.out.print("Masukkan pilihan Anda: ");

            try {
                pilihan = Integer.parseInt(scanner.nextLine()); // Baca sebagai string lalu parse

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan nama pengunjung: ");
                        String nama = scanner.nextLine();
                        if (nama != null && !nama.trim().isEmpty()) {
                            antreanRollerCoaster.tambahPengunjung(nama);
                        } else {
                            System.out.println("Nama pengunjung tidak boleh kosong.");
                        }
                        break;
                    case 2:
                        antreanRollerCoaster.layaniPengunjungBerikutnya();
                        break;
                    case 3:
                        antreanRollerCoaster.tampilkanAntrean();
                        break;
                    case 4:
                        System.out.println("Mengakhiri simulasi antrean wahana. Sampai jumpa!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka pilihan menu.");
            }

            // Beri jeda singkat agar output lebih mudah dibaca
            try {
                 // Jangan beri jeda terlalu lama jika ingin interaksi cepat
                 if (pilihan != 4) Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread terinterupsi."); // Pesan error jika sleep gagal
            }

        } while (pilihan != 4);

        scanner.close(); // Tutup scanner
    }
}