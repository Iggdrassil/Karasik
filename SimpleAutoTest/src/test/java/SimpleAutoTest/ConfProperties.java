package SimpleAutoTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    private static Properties confProp;
    private static FileInputStream confFile;
    static {
        try {
            confFile = new FileInputStream("C:/Users/Navar/Desktop/Karasik/SimpleAutoTest/src/test/Resources/conf.properties"); // Открыттие потока файла конфига
            confProp = new Properties();  //конструктор создает объёкт Properties, который не имеет значений по умолчанию.
            confProp.load(confFile); //Вводит список свойств из входного потока confFile, связанного с streamIn.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (confFile != null) {
                    confFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String getProp(String prop_name){
        return confProp.getProperty(prop_name); /* Возвращает значение, связанное с ключом.
        Возвращается нулевой объект, если ключ не находится ни в списке, ни в списке свойств по умолчанию. **/
    }

}
