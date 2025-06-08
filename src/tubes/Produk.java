package tubes;

public class Produk {
  private String kategori;
  private String nama;
  private int stok;
  private double harga;

  public Produk(String kategori, String nama, int stok, double harga) {
    this.kategori = kategori;
    this.nama = nama;
    this.stok = stok;
    this.harga = harga;
  }

  public String getKategori() { 
    return kategori;
  }

  public void setKategori(String kategori) {
    this.kategori = kategori; 
  }

  public String getNama() { 
    return nama; 
  }
  public void setNama(String nama) { 
    this.nama = nama; 
  }

  public int getStok() {
    return stok; 
  }

  public void setStok(int stok) {
    this.stok = stok;
  }

  public double getHarga() {return harga;
  }
  public void setHarga(double harga) {
    this.harga = harga;
  }

  public String toFileString() {
    return kategori + ";" + nama + ";" + stok + ";" + harga;
  }

  public static Produk fromFileString(String line) {
    String[] parts = line.split(";");
    return new Produk(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3]));
  }
}
