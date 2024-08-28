package appmobile.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;


public class NavigateTo implements Interaction {

    private final Target element;


    public NavigateTo(Target element){
        this.element = element;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(element)
        );
    }

    public static Performable withWaitTime(Target element) {
        return Instrumented.instanceOf(NavigateTo.class).withProperties(element);
    }
}
