package tubes;

public class Node {
    private Produk produk;
    private Node next;

    public Node(Produk produk) {
        this.produk = produk;
        this.next = null;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
