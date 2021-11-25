package jp.ac.hal.io42_kadai07_26.pythontest;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonTest {

    private String fullPath = "src/main/java/jp/ac/hal/io42_kadai07_26/python/hello.py";
    @Test
    void pythonScriptTest() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("python", fullPath);
        Process process = processBuilder.start();
        int i = process.waitFor();
        if (i != 0) {
            System.out.println("Boooooooo");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s = br.readLine();
        System.out.println("s = " + s);

    }
}
