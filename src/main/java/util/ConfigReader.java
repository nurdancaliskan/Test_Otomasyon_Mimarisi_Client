package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//Bir tür Veri Okuma dosyasıdır.
//config.properties'ten verileri okuyacak.
public class ConfigReader {
    private static Properties properties;

    public static Properties initialize_Properties(){
        properties = new Properties(); // kendi pro muzla eşleştirdik.
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties"); //ben bir fileınput oluştudum sen bunu oku tırağın içindeki path ten oku.
            try {
                properties.load(fileInputStream); // yüklememiz gerek proterties i
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) { // try catch içinde çalışır.
            throw new RuntimeException(e);
        }
        return getProperties();
    }
    public static Properties getProperties(){ // bir return a ihtiyacımız vardı. properties ten çek get ile
        return properties;
    }
}