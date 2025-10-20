//import UserAndBook.*;

public class Main {
    public static void main(String[] args) {
        String rootfile = "text.txt";

        WriteFile writer = new WriteFile();
        ReadFile reader = new ReadFile();
        FileEdit edit = new FileEdit();

        writer.writeToFile("text.txt", "Hi From Duc Anh !!");
        reader.readFromFile("text.txt");
        
        edit.editFile("text.txt", "hì hì");
        reader.readFromFile("text.txt");
    }
}