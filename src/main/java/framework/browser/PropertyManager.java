package framework.browser;

import framework.utils.LoggerMes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    public static final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";
    public static FileInputStream fileInputStream;
    private static final Properties prop = new Properties();

    public static Properties getProperties() {
        LoggerMes.log("get browser property");
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
        } catch (IOException e) {
            System.out.println(e);
        }
        return prop;
    }
}
