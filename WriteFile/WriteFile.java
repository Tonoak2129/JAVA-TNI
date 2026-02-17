package WriteFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
    public static void main(String[] args) throws IOException {

        FileWriter filename = new FileWriter("src/WriteFile/users2.txt",true); //ใส่ true เพื่อให้เขียนต่อท้าย
        PrintWriter writer = new PrintWriter(filename);

        writer.println("JAVA");

        writer.close();
    }
}
