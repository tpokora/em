package org.tpokora.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties()
public class FirebaseProperties {

    public static final String SERVER_KEY = "serverkey";
    public static final String CLIENT_TOKEN = "clienttoken";

    private final Map<String, String> firebase = new HashMap<>();

    public Map<String, String> getFirebase() {
        return firebase;
    }

    public String getValue(String key) {
        return this.firebase.get(key);
    }

    public String setValue(String key, String value) {
        return this.firebase.put(key, value);
    }
}
