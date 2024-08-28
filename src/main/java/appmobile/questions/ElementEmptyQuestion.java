package appmobile.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.NoSuchElementException;

public class ElementEmptyQuestion implements Question<Boolean> {

    private final Target element;
    private final int timeOut;

    public ElementEmptyQuestion(Target element, int timeOut) {
        this.element = element;
        this.timeOut = timeOut;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(element, WebElementStateMatchers.isEmpty()).forNoMoreThan(timeOut).seconds()
            );
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    public static ElementEmptyQuestion ofElement(Target element, int timeOut) {
        return new ElementEmptyQuestion(element, timeOut);
    }
}
