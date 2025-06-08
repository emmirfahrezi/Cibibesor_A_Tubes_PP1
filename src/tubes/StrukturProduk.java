package tubes;

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

  // Mohamad Faiz Khairan
  // fitur Tambahkan Produk
  public void tambahProduk(Produk data, int posisi) {
    Node newNode = new Node(data);
    if (isEmpty() || posisi <= 1) {
      tambahHead(data);
    } else {
      Node curNode = HEAD;
      Node prevNode = null;
      int index = 1;
      while (curNode != null && index < posisi) {
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
      System.out.println("Produk ditambahkan di posisi ke-" + posisi);
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
}
