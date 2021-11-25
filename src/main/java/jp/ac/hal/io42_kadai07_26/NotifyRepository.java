package jp.ac.hal.io42_kadai07_26;

import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Repository
public class NotifyRepository {

    private static final MultiValueMap<String, String> storage = new LinkedMultiValueMap<>();

    public void add(String key, String value) {
        if (!key.isEmpty() && !value.isEmpty()){
            storage.add(key, value);
        }
    }

    public MultiValueMap<String, String> getStorage() {
        return storage;
    }

    public void clear() {
        storage.clear();
    }

}
