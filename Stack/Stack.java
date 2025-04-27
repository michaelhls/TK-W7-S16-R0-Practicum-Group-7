package Stack;

import java.util.ArrayList;

// Implementasi sederhana dari data struktur Stack menggunakan ArrayList.
public final class Stack {
  // ArrayList yang dipakai oleh data struktur queue ini.
  private final ArrayList<String> list;

  // Indeks elemen terakhir atau top. Mula-mula, indeks ini akan di-set ke -1.
  private int top;

  // Proses inisialisasi properti ArrayList list dan indeks top ke -1 dengan memanggil metode clear().
  public Stack() {
    this.list = new ArrayList<>();
    this.clear();
  }

  // Dengan mengganti indeks top ke -1 kembali, seakan-akan kita menghapus setiap elemen dalam Stack ini.
  public void clear() {
    this.top = -1;
  }

  // Menambahkan sebuah elemen baru ke top (akhir) Stack kita.
  public void push(final String text) {
    // Apabila indeks top kita kurang dari kapasitas ArrayList Stack kita, maka kita bisa langsung menggunakan metode set()
    // karena masih masuk dalam kapasitas ArrayList kita.
    if (++this.top < this.list.size()) {
      this.list.set(this.top, text);
    } else {
      // Apabila tidak, mau nggak mau kita harus pakai metode add() untuk menambahkan elemen baru serta memperbesar kapasitas atau size dari ArrayList kita.
      this.list.add(text);
    }
  }
  
  // Mengeluarkan elemen top (akhir) setelah menghapus elemen tersebut dari Stack.
  // Proses penghapusan ini bisa diakalkan dengan mengurangi indeks top.
  // Apabila indeks top saat ini -1 atau Stack saat ini kosong, maka kita langsung keluarkan null.
  public String pop() {
    return this.top == -1 ? null : this.list.get(this.top--);
  }

  // Mengeluarkan elemen top (akhir) dari Stack kita tanpa menghapus elemen tersebut dari Stack (seperti di metode pop()).
  // Apabila indeks top saat ini -1 atau Stack saat ini kosong, maka kita langsung keluarkan null.
  public String getTop() {
    return this.top == -1 ? null : this.list.get(this.top);
  }
}