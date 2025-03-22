package appmobile.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-json-report-android.json"},
        features = "src/test/resources/features/",
        glue = "appmobile.stepdefinitions",
        tags = "@ValidacionElementosDelHomePage"
)
public class RunnerAndroid {

    @BeforeClass
    public static void setup() {
        String serenityConfig = "serenity-android.properties";
        System.out.println("🔹 Ejecutando pruebas en Android con configuración: " + serenityConfig);

        replaceSerenityProperties(serenityConfig);

        System.setProperty("webdriver.driver", "appium");
        System.out.println("🔧 Configuración forzada: webdriver.driver = " + System.getProperty("webdriver.driver"));
        System.out.println("📌 Configuración actual de Appium:");
        System.out.println("   - appium.hub = " + System.getProperty("appium.hub"));
        System.out.println("   - appium.platformName = " + System.getProperty("appium.platformName"));
        System.out.println("   - appium.deviceName = " + System.getProperty("appium.deviceName"));
    }

    private static void replaceSerenityProperties(String propertiesFile) {
        Properties properties = new Properties();
        try {
            String resourcePath = "src/test/resources/" + propertiesFile;
            File file = new File(resourcePath);

            if (!file.exists()) {
                throw new IOException("❌ No se encontró el archivo: " + resourcePath);
            }

            properties.load(new FileInputStream(file));

            File serenityFile = new File("serenity.properties");
            if (serenityFile.exists()) {
                serenityFile.delete();
            }
            properties.store(new FileOutputStream(serenityFile), "Serenity Configuration Overwritten");

            properties.forEach((key, value) -> System.setProperty(key.toString(), value.toString()));

            System.out.println("✅ Archivo serenity.properties reemplazado con " + propertiesFile);
        } catch (IOException e) {
            System.err.println("⚠️ No se pudo cargar el archivo de configuración: " + propertiesFile);
            e.printStackTrace();
        }
    }
}
