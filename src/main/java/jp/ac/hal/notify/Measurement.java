package jp.ac.hal.notify;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Measurement {

    public String tempAlert(double temp, double humidity) {
        String message = "現在の気温は" + temp + ", 湿度は" + humidity + "でございます。";
        if (temp > 30) {
            return message + " 気温が" + temp + "度を超え非常に暑いですのでご注意ください。";
        }
        else if (temp < 5) {
            return message + " 気温が" + temp + "度を下回りとても寒いのでご注意ください。";
        }
        else {
            return message;
        }
    }
}
