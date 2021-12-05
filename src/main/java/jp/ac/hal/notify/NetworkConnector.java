package jp.ac.hal.notify;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class NetworkConnector {

    private final ObjectProvider<TokenKey> tokenKeyAdapter; // DI
    private final NotifyRepository notifyRepository;

    public void send() {
        HttpHeaders headers = new HttpHeaders();
        TokenKey tokenKey = tokenKeyAdapter.getObject();
        headers.add("Authorization","Bearer " + tokenKey.getToken());
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(notifyRepository.getStorage(), headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange("https://notify-api.line.me/api/notify", HttpMethod.POST, entity, String.class);
    }
}
