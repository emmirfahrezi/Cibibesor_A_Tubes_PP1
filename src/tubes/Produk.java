package tubes;

public class Produk {
  private String kode;
  private String nama;
  private int stok;
  private double harga;

  public Produk(String kode, String nama, int stok, double harga) {
    this.kode = kode;
    this.nama = nama;
    this.stok = stok;
    this.harga = harga;
  }

  public String getKode() { 
    return kode; 
  }

  public void setKode(String kode) { 
    this.kode = kode; 
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
    return kode + ";" + nama + ";" + stok + ";" + harga;
  }

  public static Produk fromFileString(String line) {
    String[] parts = line.split(";");
    return new Produk(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3]));
  }
}
