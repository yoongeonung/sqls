package jp.ac.hal.yoongeonung.notify;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class TokenKey {
    @Value("${token-key}")
    private String token;

    private static TokenKey tokenKey = new TokenKey();

    private TokenKey() {
    }

    // singleton
    public TokenKey getInstance() {
        if (tokenKey == null) {
            tokenKey = new TokenKey();
        }
        return tokenKey;
    }
}
