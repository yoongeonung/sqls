package jp.ac.hal.notify;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class NotiftyService {

    private final MeasurementReceiver measurementReceiver;
    private final Measurement measurement;
    private final NotifyRepository repository;
    private final NetworkConnector networkConnector;

    @Scheduled(fixedRate = 3 * (60 * 1000))
    public void startNotifier() throws IOException, InterruptedException {
        MeasurementDTO dto = measurementReceiver.receive();
        double temp = Double.parseDouble(dto.getTemperature());
        double humidity = Double.parseDouble(dto.getHumidity());
        String message = measurement.tempAlert(temp, humidity);
        System.out.println("message = " + message);
        repository.add("message", message);
        networkConnector.send();
        repository.clear();
    }
}
