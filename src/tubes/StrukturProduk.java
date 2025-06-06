package tubes;

import java.io.*;

public class StrukturProduk {
    public Node HEAD;

    public boolean isEmpty() {
    return HEAD == null;
  }

  // hikmat pandu raharja
  // fitur update produk
  public void updateProduk(int posisi, Produk dataBaru) {
    Node curNode = HEAD;
    int index = 1;
    while (curNode != null && index < posisi) {
      curNode = curNode.getNext();
      index++;
    }
    if (curNode != null) {
      curNode.setData(dataBaru);
      System.out.println("Produk di posisi " + posisi + " berhasil diperbarui.");
    } else {
      System.out.println("Posisi tidak ditemukan.");
    }
  }
}
