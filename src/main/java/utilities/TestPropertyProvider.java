package utilities;

import java.io.IOException;
import java.util.Properties;

public class TestPropertyProvider {

    private static TestPropertyProvider propertyProvider = new TestPropertyProvider();
    private Properties properties = new Properties();

    private TestPropertyProvider() {
        try {
            properties.load(TestPropertyProvider.class.getClassLoader().getResourceAsStream("TestProperties.properties"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static TestPropertyProvider getPropertyProvider(){
        return propertyProvider;
    }

    public String getProperty(String expectedKey) {
        return properties.getProperty(expectedKey);
    }
}
