package appmobile.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;



public class InputText implements Interaction {

    private String id;
    private Target inputElement;
    private Target element;

    public InputText(String id, Target element) {
        this.id = id;
        this.element = element;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SendKeys.of(id).into(element)
        );
    }

    public static InputText into(String id, Target element){
        return new InputText(id, element);
    }


}