public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        KhachHang myBeer = new KhachHang();
        myBeer.nhanbia = "bia cua toi.";
        myBeer.ganNhanBia("Hanoi");

        System.out.println("Bia : " + myBeer.layNhanBia());
    }
}
