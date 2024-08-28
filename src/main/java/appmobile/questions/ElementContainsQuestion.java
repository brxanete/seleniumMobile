package appmobile.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;



public class ElementContainsQuestion implements Question<String> {

    private Target element;


    public ElementContainsQuestion(Target element) {
        this.element = element;


    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(element, WebElementStateMatchers.isVisible())
        );
        return element.resolveFor(actor).getText();
    }

    public static ElementContainsQuestion ofElement(Target element){
        return new ElementContainsQuestion(element);
    }
}
