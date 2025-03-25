package appmobile.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target robotImage = Target.the("Robot Image")
            .located(AppiumBy.xpath(
                    "//android.widget.ScrollView[@content-desc='Home-screen'] | " +
                            "//XCUIElementTypeImage[@name='assets/src/assets/webdriverio.png']"
            ));






}
