package appmobile.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target robotImage = Target.the("Robot Image")
            .located(getLocator(
                    AppiumBy.accessibilityId("Home-screen"),  // Android
                    AppiumBy.iOSNsPredicateString("name == 'Home-screen'") // iOS
            ));

    public static final Target webDriverTitle = Target.the("Web Driver Title")
            .located(getLocator(
                    AppiumBy.xpath("//android.widget.TextView[@text='WEBDRIVER']"),
                    AppiumBy.iOSNsPredicateString("name == 'WEBDRIVER'")
            ));

    public static final Target iOLogo = Target.the("IO Logo")
            .located(getLocator(
                    AppiumBy.xpath("//android.widget.ScrollView[@content-desc='Home-screen']/android.view.ViewGroup/android.widget.ImageView[2]"),
                    AppiumBy.xpath("//XCUIElementTypeScrollView[@name='Home-screen']/XCUIElementTypeImage[2]")
            ));

    public static final Target infoApp = Target.the("Info App")
            .located(getLocator(
                    AppiumBy.xpath("//android.widget.TextView[@text='Demo app for the appium-boilerplate']"),
                    AppiumBy.iOSNsPredicateString("name == 'Demo app for the appium-boilerplate'")
            ));

    public static final Target appleLogo = Target.the("Apple Logo")
            .located(getLocator(
                    AppiumBy.xpath("//android.widget.TextView[@text='󰀵']"),
                    AppiumBy.iOSNsPredicateString("name == '󰀵'")
            ));

    public static final Target androidLogo = Target.the("Android Logo")
            .located(getLocator(
                    AppiumBy.xpath("//android.widget.TextView[@text='󰀲']"),
                    AppiumBy.iOSNsPredicateString("name == '󰀲'")
            ));

    public static final Target supportText = Target.the("Support Text")
            .located(getLocator(
                    AppiumBy.accessibilityId("Support"),
                    AppiumBy.iOSNsPredicateString("name == 'Support'")
            ));

    // 📌 Método corregido: Ahora devuelve By en lugar de AppiumBy
    private static By getLocator(By androidLocator, By iosLocator) {
        String platform = System.getProperty("platform", "Android"); // Por defecto, Android
        return platform.equalsIgnoreCase("iOS") ? iosLocator : androidLocator;
    }
}
