package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entity.Node;
import entity.Produk;

public class StrukturProduk {
  public Node HEAD;

  public boolean isEmpty() {
    return HEAD == null;
  }

  // Di dalam kelas StrukturProduk
  public int getSize() {
    int count = 0;
    Node temp = HEAD;
    while (temp != null) {
      count++;
      temp = temp.getNext();
    }
    return count;
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

  // Mohamad Faiz Khairan
  // fitur Tambahkan Produk
  // Ganti method tambahProduk menjadi tambahMid tanpa parameter posisi
  public void tambahMid(Produk data) {
    Node newNode = new Node(data);
    int size = getSize();
    int mid = size / 2 + 1;

    if (isEmpty() || mid <= 1) {
      tambahHead(data);
    } else {
      Node curNode = HEAD;
      Node prevNode = null;
      int index = 1;
      while (curNode != null && index < mid) {
        prevNode = curNode;
        curNode = curNode.getNext();
        index++;
      }
      if (prevNode != null) {
        prevNode.setNext(newNode);
        newNode.setNext(curNode);
      } else {
        tambahTail(data);
      }
      System.out.println("Produk ditambahkan di tengah.");
    }
  }

  // fahri rizqon arsiansyah
  // fitur tampilkan produk
  public void tampilkanProduk() {
    if (isEmpty()) {
      System.out.println("Daftar produk kosong.");
    } else {
      Node curNode = HEAD;
      int posisi = 1;
      while (curNode != null) {
        Produk p = curNode.getData();
        System.out.println(posisi + ". " + p.getKategori() + " - " + p.getNama() +
            " | Stok: " + p.getStok() + " | Harga: Rp" + p.getHarga());
        curNode = curNode.getNext();
        posisi++;
      }
    }
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

  // andyka khaerulana
  // fituh hapus produk
  public void hapusProduk(int posisi) {
    if (isEmpty()) {
      System.out.println("List kosong.");
      return;
    }
    if (posisi == 1) {
      HEAD = HEAD.getNext();
      System.out.println("Produk posisi 1 berhasil dihapus.");
      return;
    }
    Node curNode = HEAD;
    Node prevNode = null;
    int index = 1;
    while (curNode != null && index < posisi) {
      prevNode = curNode;
      curNode = curNode.getNext();
      index++;
    }
    if (curNode != null) {
      prevNode.setNext(curNode.getNext());
      System.out.println("Produk posisi " + posisi + " berhasil dihapus.");
    } else {
      System.out.println("Posisi tidak ditemukan.");
    }
  }

  // Mohamad Faiz Khairan
  // Fitur Simpan ke file
  public void simpanKeFile(String filename) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
      Node curNode = HEAD;
      while (curNode != null) {
        bw.write(curNode.getData().toFileString());
        bw.newLine();
        curNode = curNode.getNext();
      }
      System.out.println("Data berhasil disimpan ke " + filename);
    } catch (IOException e) {
      System.out.println("Gagal menyimpan file: " + e.getMessage());
    }
  }

  // andyka khaerulana
  // fitur cariProduk
  public void cariProduk(String keyword) {
    if (isEmpty()) {
      System.out.println("Daftar produk kosong.");
      return;
    }

    Node curNode = HEAD;
    int posisi = 1;
    boolean ditemukan = false;

    while (curNode != null) {
      Produk p = curNode.getData();
      if (p.getKategori().equalsIgnoreCase(keyword) || p.getNama().toLowerCase().contains(keyword.toLowerCase())) {
        System.out.println("Posisi: " + posisi + " | [" + p.getKategori() + "] " + p.getNama() +
            " | Stok: " + p.getStok() + " | Harga Satuan: Rp" + p.getHarga() + " | Total: Rp"
            + (p.getHarga() * p.getStok()));
        ditemukan = true;
      }
      curNode = curNode.getNext();
      posisi++;
    }

    if (!ditemukan) {
      System.out.println("Produk \"" + keyword + "\" tidak ditemukan.");
    }
  }

  // Fahri rizqon arsiansyah
  // Fitur muatDariFile
  public void muatDariFile(String filename) {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = br.readLine()) != null) {
        Produk p = Produk.fromFileString(line);
        tambahTail(p);
      }
      System.out.println("Data berhasil dimuat dari " + filename);
    } catch (IOException e) {
      System.out.println("File tidak ditemukan. Memulai dari data kosong.");
    }
  }
}
