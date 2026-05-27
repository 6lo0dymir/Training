package threadqa_testing.utils;

import java.io.*;
import java.util.*;

public class ConfigReader {
    private final Properties properties = new Properties();

    public ConfigReader(String propertiesName) {
        String fileName = switch (propertiesName) {
            case "Creds" -> "Creds.properties";
            default -> throw new IllegalArgumentException(
                    "Неизвестное имя конфигурации. Используйте 'Creds.properties'."
            );
        };

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Файл не найден в classpath: " + fileName);
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при загрузке файла: " + fileName, e);
        }
    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getLogin(){return properties.getProperty("LOGIN");}
    public String getPassword(){return properties.getProperty("PASSWORD");}
    public String getInvalidLogin(){return properties.getProperty("INVALIDLOGIN");}
    public String getInvalidPassword(){return properties.getProperty("INVALIDPASSWORD");}
}
