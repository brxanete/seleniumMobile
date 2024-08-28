package appmobile.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import org.openqa.selenium.WebElement;

public class InputEditableQuestion implements Question<Boolean> {

    private final Target element;
    private final String id;
    private final int timeOut;

    public InputEditableQuestion(Target element, String id, int timeOut) {
        this.element = element;
        this.id = id;
        this.timeOut = timeOut;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            WebElement webElement = element.resolveFor(actor);
            boolean isEditable = webElement.isEnabled();

            if (isEditable) {

                return false;
            } else {
                actor.attemptsTo(
                        WaitUntil.the(element, WebElementStateMatchers.isEnabled()).forNoMoreThan(timeOut).seconds()
                );
                return true;
            }
        } catch (Exception e) {
            // Manejar la excepción, por ejemplo, imprimir un mensaje
            System.out.println("Error al intentar verificar la editabilidad del elemento");
            return false;
        }
    }

    public static InputEditableQuestion ofInput(Target element, String id, int timeOut) {
        return new InputEditableQuestion(element, id, timeOut);
    }
}