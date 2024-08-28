package appmobile.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriverException;

public class ElementClickableQuestion implements Question<Boolean> {

    private final Target element;
    private final int timeOut;

    public ElementClickableQuestion(Target element, int timeOut) {
        this.element = element;
        this.timeOut = timeOut;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(element, WebElementStateMatchers.isClickable()).forNoMoreThan(timeOut).seconds()
            );
            return true;
        } catch (WebDriverException ignored) {
            return false;
        }
    }

    public static ElementClickableQuestion ofElement(Target element, int timeOut) {
        return new ElementClickableQuestion(element, timeOut);
    }
}