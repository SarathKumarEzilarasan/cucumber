package utils;

import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadQaProps {
    static JSONObject configData;
    static JSONObject data;
    static ReadQaProps readQaProps;
    static JSONParser parser = new JSONParser();

    private ReadQaProps() {

    }

    public static ReadQaProps _init() {
        if (readQaProps == null){
            PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/log4j2.properties");
            return new ReadQaProps();
        }
        else
            return readQaProps;
    }

    public static void config() {
        try {
            _init();
            configData = (JSONObject) parser.parse(
                    new FileReader("src/test/resources/config.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
//        return configData;
    }

    public static String getValue(Object property) {
        return data.get(property).toString();
    }

    public static String getConfig(Object property) {
        return configData.get(property).toString();
    }
}
