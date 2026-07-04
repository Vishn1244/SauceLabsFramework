package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {

        try {

            // Default profile is "dev"
        	String profile = System.getProperty("env", "dev");

        	System.out.println("Profile = " + profile);

        	String filePath =
        	        System.getProperty("user.dir")
        	        + "/src/test/resources/config/"
        	        + profile
        	        + ".properties";

        	System.out.println("Loading file = " + filePath);

            FileInputStream fis =
                    new FileInputStream(filePath);

            properties.load(fis);

            fis.close();

            System.out.println("------------------------------------");
            System.out.println("Environment : " + profile.toUpperCase());
            System.out.println("Loaded File : " + filePath);
            System.out.println("------------------------------------");

        }

        catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);
    }
}