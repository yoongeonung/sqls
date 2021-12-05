package jp.ac.hal.notify;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TokenKey {

    @Value("${token-key}")
    private String token;

    private static TokenKey instance = new TokenKey();

    private TokenKey() {
    }

    public static TokenKey getInstance() {
        if (instance == null) {
            return new TokenKey();
        }
        return instance;
    }
}
