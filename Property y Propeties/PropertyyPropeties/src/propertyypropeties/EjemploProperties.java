import java.io.*;
import java.util.Properties;

public class EjemploProperties {
    public static void main(String[] args) {
      
        Properties config = new Properties();
        
     
        config.setProperty("database.url", "jdbc:mysql://localhost:3306/mi_base");
        config.setProperty("database.username", "usuario");
        config.setProperty("database.password", "contraseña");
        
      
        try (FileOutputStream out = new FileOutputStream("config.properties")) {
            config.store(out, "Configuración de la base de datos");
        } catch (IOException e) {
        }
        

        Properties loadedConfig = new Properties();
        try (FileInputStream in = new FileInputStream("config.properties")) {
            loadedConfig.load(in);
        } catch (IOException e) {
        }
        
     
        System.out.println("URL de la base de datos: " + loadedConfig.getProperty("database.url"));
        System.out.println("Nombre de usuario: " + loadedConfig.getProperty("database.username"));
        System.out.println("Contraseña: " + loadedConfig.getProperty("database.password"));
    }
}
