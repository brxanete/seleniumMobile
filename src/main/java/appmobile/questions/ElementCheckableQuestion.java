package appmobile.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;


public class ElementCheckableQuestion implements Question<Boolean> {

    private final Target element;
    private final int timeOut;

    public ElementCheckableQuestion(Target element, int timeOut) {
        this.element = element;
        this.timeOut = timeOut;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(element, WebElementStateMatchers.isEnabled()).forNoMoreThan(timeOut).seconds()
            );

            String checkedAttribute = element.resolveFor(actor).getAttribute("checkable");
            return "true".equalsIgnoreCase(checkedAttribute);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ElementCheckableQuestion ofElement(Target element, int timeOut) {
        return new ElementCheckableQuestion(element, timeOut);
    }

}