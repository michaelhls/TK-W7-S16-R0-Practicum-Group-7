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

          text.setText(scanner.nextLine());

          continue;
        }

        // Tambah teks
        case "2": {
          System.out.print("Teks baru: " + text.getText());

          text.addText(scanner.nextLine());

          continue;
        }

        // Undo
        case "3": {
          text.undo();

          continue;
        }

        // Redo
        case "4": {
          text.redo();

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