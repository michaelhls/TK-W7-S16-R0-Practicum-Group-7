package Stack;

// Contoh implementasi sederhana riwayat pergantian teks, dengan implementasi redo and undo dengan memanfaatkan data struktur Stack.
import java.util.Stack;

// Cara kerja sederhana Stack dari implementasi riwayat pergantian teks ini dapat dilihat pada contoh skenario sederhana berikut:
//
// -> text
// redo: []
// undo: ["text"]
// 
// -> texttext
// redo: []
// undo: ["text", "texttext"]
// 
// CTRL+Z (undo)
// 
// -> text
// redo: ["texttext"]
// undo: ["text"]
// 
// CTRL+Y (redo)
// 
// -> texttext
// redo: []
// undo: ["text", "texttext"]
public final class TextHistory {
  // Stack untuk operasi-operasi redo. Biasanya kosong apabila pengguna tidak pernah menggunakan undo.
  // Akan bertambah seiring dengan setiap operasi undo yang sukses dan langsung kosong kembali apabila
  // pengguna langsung memodifikasi/menambahkan teks.
  private final Stack<String> redo;

  // Stack untuk operasi-operasi undo. Elemen teratas atau top adalah isi dari teks saat ini.
  // Akan bertambah seiring dengan setiap operasi redo atau modifikasi/tambahan teks yang sukses.
  private final Stack<String> undo;

  // Proses inisialisasi properti-properti Stack.
  public TextHistory() {
    this.redo = new Stack<>();
    this.undo = new Stack<>();
  }

  // Metode untuk memodifikasi satu teks secara penuh.
  public void setText(final String text) {
    // Langsung tambahkan teks ke top dari Stack undo, agar kita dapat pop() Stack tersebut apabila pengguna ingin undo. 
    this.undo.push(text);

    // Langsung hapus riwayat redo. Setelah ini, setiap operasi redo tidak akan mengeluarkan efek apapun sampai pengguna
    // menggunakan operasi undo selanjutnya.
    this.redo.clear();
  }

  // Metode untuk menambahkan teks baru ke teks saat ini.
  // Contoh:
  // "hello" -> "hellotext"
  // "hello" -> "hellohello"
  public void addText(final String text) {
    this.setText(this.getText() + text);
  }

  // Metode untuk mengeluarkan teks saat ini.
  // Ini ekuivalen dengan elemen terakhir atau top pada Stack undo.
  // Apabila elemen tersebut tidak ada karena Stack undo saat ini kosong, maka
  // langsung keluarkan String yang kosong.
  public String getText() {
    return this.undo.isEmpty() ? "" : this.undo.peek();
  }

  // Operasi redo.
  public void redo() {
    if (!this.redo.isEmpty()) {
      this.undo.push(this.redo.pop());
    }
  }
  
  // Operasi undo.
  public void undo() {
    if (!this.undo.isEmpty()) {
      this.redo.push(this.undo.pop());
    }
  }
}