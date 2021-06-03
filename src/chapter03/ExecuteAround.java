//: chapter03/ExecuteAround.java

package chapter03;

import com.simple.interfaces.BufferedReaderProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
    private static String processFileLimited() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("../com/resources/chapter03/data.txt"))) {
            return br.readLine();
        }
    }

    private static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("../com/resources/chapter03/data.txt"))) {
            return p.process(br);
        }
    }

    public static void main(String... args) throws IOException {
        // method we want to refactor to make more flexible
        String result = processFileLimited();
        System.out.println(result);
        System.out.println("---");
        String oneLine = processFile(BufferedReader::readLine);
        System.out.println(oneLine);
        String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(twoLines);
    }
}
