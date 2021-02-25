package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {

    public String getElement(String elementKey) throws FileNotFoundException, IOException {

        Properties prop = new Properties();
        FileInputStream istream = new FileInputStream("/home/ashwin/IdeaProjects/Gmail-Cucumber/src/test/java/resources/global.properties");
        prop.load(istream);
        String keyValue = prop.getProperty(elementKey);
        return keyValue;
    }
}
