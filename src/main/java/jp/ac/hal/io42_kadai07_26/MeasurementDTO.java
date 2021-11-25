package jp.ac.hal.io42_kadai07_26;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MeasurementDTO {
    private String temperature;
    private String humidity;

    @Override
    public String toString() {
        return "temperature='" + temperature + '\'' +
                " humidity='" + humidity + '\'';
    }
}
