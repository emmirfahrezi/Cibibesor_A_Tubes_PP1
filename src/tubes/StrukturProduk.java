package tubes;

public class StrukturProduk {
    private Node head;

    public StrukturProduk() {
        this.head = null;
    }

    public void tambahProduk(Produk produk) {
        Node baru = new Node(produk);
        if (head == null) {
            head = baru;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(baru);
        }
    }

    public void tampilkanProduk() {
        Node current = head;
        while (current != null) {
            System.out.println("Nama: " + current.getProduk().getNama() +
                               ", Harga: " + current.getProduk().getHarga());
            current = current.getNext();
        }
    }
}
