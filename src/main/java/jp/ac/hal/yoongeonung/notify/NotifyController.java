package jp.ac.hal.yoongeonung.notify;

import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class NotifyController {
    // 103 *(60 * 1000) 1h 43m
    private static final long SLEEP_TIME = 103 *(60 * 1000);
    // switch
    private static boolean power = true;
    private static boolean button = false;

    public static void main(String[] args) throws InterruptedException {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        List<String> tuesdayTable = TimeTable.newTuesday();
        List<String> wednesdayTable = TimeTable.newWednesday();


        while (power) {
            LocalDateTime time = LocalDateTime.now();
            LocalTime now = LocalTime.now();
            if (time.getDayOfWeek() == java.time.DayOfWeek.TUESDAY || time.getDayOfWeek() == java.time.DayOfWeek.FRIDAY) {
                if (time.getDayOfWeek() == DayOfWeek.TUESDAY) {
                    addMessages(params, tuesdayTable, now);
                }else {
                    addMessages(params, wednesdayTable, now);
                }
                if (!params.isEmpty() && button) {
                    connectLine(params);
                    button = false;
                }
            }
        }
    }

    private static void sleep() throws InterruptedException {
        System.out.println("===========sleep============");
        Thread.sleep(SLEEP_TIME);
    }



    private static void addMessages(MultiValueMap<String, String> params, List<String> weekTable, LocalTime now) throws InterruptedException {
        if (LocalTime.of(now.getHour(), now.getMinute(), now.getSecond()).equals(LocalTime.of(9, 15, 1))) {
            params.add("message", weekTable.get(0));
            button = true;
        } else if (LocalTime.of(now.getHour(), now.getMinute(), now.getSecond()).equals(LocalTime.of(11, 0, 1))) {
            params.add("message", weekTable.get(1));
            button = true;
        } else if (LocalTime.of(now.getHour(), now.getMinute(), now.getSecond()).equals(LocalTime.of(12, 45, 1))) {
            params.add("message", weekTable.get(2));
            button = true;
            power = false;
        }
    }

    private static void connectLine(MultiValueMap<String, String> params) throws InterruptedException {
        if (!params.isEmpty()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization","Bearer wBle3lLBgQC5Xm7pfj6720Qyu8230OgpCwQpJArllDD");
            headers.add("Content-Type", "application/x-www-form-urlencoded");

            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange("https://notify-api.line.me/api/notify", HttpMethod.POST, entity, String.class);
        }
        if (power) sleep();
    }
}
