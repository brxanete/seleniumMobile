package appmobile.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.WebDriver;

public class CloseTestExecution implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        driver.quit();
    }

    public static CloseTestExecution immediately() {
        return new CloseTestExecution();
    }
}