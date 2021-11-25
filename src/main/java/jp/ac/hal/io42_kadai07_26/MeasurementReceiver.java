package jp.ac.hal.io42_kadai07_26;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class MeasurementReceiver {
    private static final String PYTHON_PATH = "Python/hello.py";

    public MeasurementDTO receive() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("python", PYTHON_PATH);
        Process process = processBuilder.start();
        int i = process.waitFor();
        if (i != 0) {
            System.out.println("Boooooooo");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String[] strs = br.readLine().split(" ");
        return new MeasurementDTO(strs[0], strs[1]);
    }
}
