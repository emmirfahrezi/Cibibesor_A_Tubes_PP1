package tubes;

import java.io.*;

public class StrukturProduk {
  public Node HEAD;

  public boolean isEmpty() {
    return HEAD == null;
  }

  // Emmir Fahrezi
  // fitur tambah produk di awal
   public void tambahHead(Produk data) {
    Node newNode = new Node(data);
    newNode.setNext(HEAD);
    HEAD = newNode;
    System.out.println("Produk ditambahkan di awal (HEAD).");
  }

  // Emmir Fahrezi
  // fitur tambah produk di akhir
  public void tambahTail(Produk data) {
    Node newNode = new Node(data);
    if (isEmpty()) {
      HEAD = newNode;
    } else {
      Node cur = HEAD;
      while (cur.getNext() != null) {
        cur = cur.getNext();
      }
      cur.setNext(newNode);
    }
    System.out.println("Produk ditambahkan di akhir (TAIL).");
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
