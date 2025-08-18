public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Bia myBeer = new Bia();
        myBeer.nhanbia = "Bia cua toi";
        myBeer.ganNhanBia("Hanoi");

        System.out.println("Bia : " + myBeer.layNhanBia());


        
    }
}
