package appmobile.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class WaitNavigateTo implements Interaction {

    private final Target element;
    private final int timeout;

    public WaitNavigateTo(Target element, int timeoutWait){
        this.element = element;
        this.timeout = timeoutWait;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(element, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
            WaitUntil.the(element, WebElementStateMatchers.isClickable()).forNoMoreThan(timeout).seconds(),
            Click.on(element)
        );
    }

    public static Performable withWaitTime(Target element, int timeout) {
        return Instrumented.instanceOf(WaitNavigateTo.class).withProperties(element, timeout);
    }
}
