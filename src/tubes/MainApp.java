package tubes;

import java.util.Scanner;

public class MainApp {
     public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    StrukturProduk list = new StrukturProduk();
    list.muatDariFile("produk.txt");

    int pilihan;
    do {
      System.out.println("\n=== MENU TOKO KELONTONG ===");
      System.out.println("1. Tambah Produk Sembako");
      System.out.println("2. Tambah Produk Makanan dan Minuman Ringan");
      System.out.println("3. Tambah Produk Alat kebutuhan Mandi Mencuci dan lain-lain");
      System.out.println("4. Tampilkan Produk");
      System.out.println("5. Update Produk");
      System.out.println("6. Hapus Produk");
      System.out.println("7. Cari Produk");
      System.out.println("8. Simpan ke File");
      System.out.println("9. Keluar");
      System.out.print("Pilih menu: ");
      pilihan = input.nextInt();
      input.nextLine();

      switch (pilihan) {
        case 1:
          list.tambahHead(inputProduk(input));
          break;
        case 2:
          list.tambahTail(inputProduk(input));
          break;
        case 3:
          Produk bebas = inputProduk(input);
          int size = list.getSize();
          int mid = size / 2 + 1;
          list.tambahMid(bebas);
          System.out.println("Produk ditambahkan di tengah");
          break;
        case 4:
          list.tampilkanProduk();
          break;
        case 5:
          System.out.print("Posisi produk yang ingin diupdate: ");
          int upos = input.nextInt(); input.nextLine();
          list.updateProduk(upos, inputProduk(input));
          break;
        case 6:
          System.out.print("Posisi yang ingin dihapus: ");
          int dpos = input.nextInt();
          list.hapusProduk(dpos);
          break;
        case 7:
          System.out.print("Masukkan kategori/nama produk: ");
          String keyword = input.nextLine();
          list.cariProduk(keyword);
          break;
        case 8:
          list.simpanKeFile("produk.txt");
          break;
        case 9:
          System.out.println("Keluar program.");
          break;
        default:
          System.out.println("Pilihan tidak valid.");
      }
    } while (pilihan != 9);
    input.close();
  }

  public static Produk inputProduk(Scanner input) {
    System.out.print("Kategori: ");
    String kategori = input.nextLine();
    System.out.print("Nama: ");
    String nama = input.nextLine();
    System.out.print("Stok: ");
    int stok = input.nextInt();
    System.out.print("Harga: ");
    double harga = input.nextDouble();
    input.nextLine();
    return new Produk(kategori, nama, stok, harga);
    }
}
