import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("input.md");
        FileWriter fw = new FileWriter("output.md");
        Scanner sc = new Scanner(fr);
        String s;
        while (sc.hasNextLine()) {
            s = sc.nextLine();
            double a = 0.0;
            double b = 0.0;
            char sym = ' ';
            int m = 0;
            boolean t = true;
            for (String s2 : s.split(" ")) {
                m++;
                if (m == 1) {
                    try {
                        a = Double.valueOf(s2);
                    } catch (Exception e) {
                        fw.write(s + " = Error! Not number\n");
                        t = false;
                        break;
                    }
                }
                if (m == 3) {
                    try {
                        b = Double.valueOf(s2);
                    } catch (Exception e2) {
                        fw.write(s + " = Error! Not number\n");
                        t = false;
                        break;
                    }
                }
            }
            if (t) {
                m = 0;
                for (String s3 : s.split(" ")) {
                    m++;
                    if (m == 2) {
                        try {
                            sym = result(s3, sym);
                        } catch (Exception e3) {
                            fw.write(s + " = Operation Error!\n");
                        }
                    }
                }
            }
            if (t) {
                if (sym == '+') fw.write(String.format("%s + %s = %s\n", a, b, (a + b)));
                if (sym == '-') fw.write(String.format("%s - %s = %s\n", a, b, (a - b)));
                if (sym == '*') fw.write(String.format("%s * %s = %s\n", a, b, (a * b)));
                if (sym == '/') {
                    if (b == 0) {
                        fw.write(s + " = Error! Division by zero\n");
                    } else {
                        fw.write(String.format("%s / %s = %s\n", a, b, (a / b)));
                    }
                }
            }
        }
        sc.close();
        fr.close();
        fw.close();


    }

    public static char result(String n, char sym) throws Exception {
        if (n.equals("+") || n.equals("-") || n.equals("*") || n.equals("/")) {
            sym = n.charAt(0);
            return sym;
        } else throw new Exception("Operation Error!");
    }
}