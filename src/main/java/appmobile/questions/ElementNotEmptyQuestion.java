package appmobile.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.NoSuchElementException;

public class ElementNotEmptyQuestion implements Question<Boolean> {

    private final Target element;
    private final int timeOut;

    public ElementNotEmptyQuestion(Target element, int timeOut) {
        this.element = element;
        this.timeOut = timeOut;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(element, WebElementStateMatchers.isNotEmpty()).forNoMoreThan(timeOut).seconds()
            );
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    public static ElementNotEmptyQuestion ofElement(Target element, int timeOut) {
        return new ElementNotEmptyQuestion(element, timeOut);
    }
}
