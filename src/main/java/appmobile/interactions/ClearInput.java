package appmobile.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ClearInput implements Interaction {

    private final Target element;

    public ClearInput(Target element) {
        this.element = element;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(element, WebElementStateMatchers.isClickable()).forNoMoreThan(15).seconds()
        );
        element.resolveFor(actor).clear();
    }

    public static ClearInput ofWebElement(Target element){
        return new ClearInput(element);
    }
}
