// Cara compile:
// $ javac Stack/*.java
// $ java Stack/Main

package Stack;

import java.util.Scanner;

public final class Main {
  public static void main(String[] args) {
    final TextHistory text = new TextHistory();
    final Scanner scanner = new Scanner(System.in);

    System.out.println("Pilih angka yang sesuai untuk mengeksekusikan operasi yang diinginkan pada teks." +
                       "\n1. Ganti teks" +
                       "\n2. Tambah teks" +
                       "\n3. Undo" +
                       "\n4. Redo" +
                       "\n5. Keluar");

    while (true) {
      // Tampilkan teks di setiap prompt agar kita tidak perlu cek teksnya secara manual setelah setiap operasi.
      System.out.print("\"" + text.getText() + "\" > ");
      
      switch (scanner.nextLine()) {
        // Ganti teks
        case "1": {
          System.out.print("Teks baru: ");

          final String newText = scanner.nextLine();

          final long start = System.nanoTime();
          text.setText(newText);
          final long end = System.nanoTime();

          System.out.println("Selesai dalam " + (end - start) + " ns");

          continue;
        }

        // Tambah teks
        case "2": {
          System.out.print("Teks baru: " + text.getText());

          final String newText = scanner.nextLine();

          final long start = System.nanoTime();
          text.addText(newText);
          final long end = System.nanoTime();

          System.out.println("Selesai dalam " + (end - start) + " ns");

          continue;
        }

        // Undo
        case "3": {
          final long start = System.nanoTime();
          text.undo();
          final long end = System.nanoTime();

          System.out.println("Selesai dalam " + (end - start) + " ns");

          continue;
        }

        // Redo
        case "4": {
          final long start = System.nanoTime();
          text.redo();
          final long end = System.nanoTime();

          System.out.println("Selesai dalam " + (end - start) + " ns");

          continue;
        }

        // Keluar
        case "5": {
          scanner.close();
          
          return;
        }
      }
    }
  }
}