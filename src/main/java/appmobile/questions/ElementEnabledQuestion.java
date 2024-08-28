package appmobile.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ElementEnabledQuestion implements Question<Boolean> {

    private final Target element;
    private final int timeOut;

    public ElementEnabledQuestion(Target element, int timeOut) {
        this.element = element;
        this.timeOut = timeOut;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(element, WebElementStateMatchers.isEnabled()).forNoMoreThan(timeOut).seconds()
            );
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public static ElementEnabledQuestion ofElement(Target element, int timeOut) {
        return new ElementEnabledQuestion(element, timeOut);
    }
}