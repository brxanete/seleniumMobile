package appmobile.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;


public class ElementDisabledQuestion implements Question<Boolean> {

    private final Target element;
    private final int timeOut;

    public ElementDisabledQuestion(Target element, int timeOut) {
        this.element = element;
        this.timeOut = timeOut;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(element, WebElementStateMatchers.isVisible()).forNoMoreThan(timeOut).seconds()
            );

            String checkedAttribute = element.resolveFor(actor).getAttribute("disabled");
            return "true".equalsIgnoreCase(checkedAttribute);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ElementDisabledQuestion ofElement(Target element, int timeOut) {
        return new ElementDisabledQuestion(element, timeOut);
    }

}