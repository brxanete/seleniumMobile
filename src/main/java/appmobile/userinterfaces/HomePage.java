package appmobile.userinterfaces;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static Target robotImage = Target.the("Robot Image").located(AppiumBy.xpath("//android.widget.ScrollView[@content-desc='Home-screen']/android.view.ViewGroup/android.widget.ImageView[1]"));
    public static Target webDriverTitle = Target.the("Web Driver Title").located(AppiumBy.xpath("//android.widget.TextView[@text='WEBDRIVER']"));
    public static Target iOLogo = Target.the("IO Logo").located(AppiumBy.xpath("//android.widget.ScrollView[@content-desc='Home-screen']/android.view.ViewGroup/android.widget.ImageView[2]"));
    public static Target infoApp = Target.the("Info App").located(AppiumBy.xpath("//android.widget.TextView[@text='Demo app for the appium-boilerplate']"));
    public static Target appleLogo = Target.the("Apple Logo").located(AppiumBy.xpath("//android.widget.TextView[@text='󰀵']"));
    public static Target androidLogo = Target.the("Android Logo").located(AppiumBy.xpath("//android.widget.TextView[@text='󰀲']"));
    public static Target supportText = Target.the("Support Text").located(AppiumBy.xpath("//android.widget.TextView[@text='Support']"));

}