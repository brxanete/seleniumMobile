package appmobile.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ElementNotEnabledQuestion implements Question<Boolean> {

    private final Target element;
    private final int timeOut;

    public ElementNotEnabledQuestion(Target element, int timeOut) {
        this.element = element;
        this.timeOut = timeOut;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(element, WebElementStateMatchers.isNotEnabled()).forNoMoreThan(timeOut).seconds()
            );
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public static ElementNotEnabledQuestion ofElement(Target element, int timeOut) {
        return new ElementNotEnabledQuestion(element, timeOut);
    }
}