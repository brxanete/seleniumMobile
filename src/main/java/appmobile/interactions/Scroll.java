package appmobile.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Scroll implements Interaction {

    private final Map<String, Object> arguments;

    public Scroll(Map<String, Object> arguments) {
        this.arguments = arguments;
    }

    public static Scroll gesture(Map<String, Object> arguments) {
        return instrumented(Scroll.class, arguments);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("mobile: scrollGesture", arguments);
    }
}