package appmobile.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.targets.Target;

@Subject("whether the text of the element matches the expected pattern for a date value")
public class DateValueTextQuestion implements Question<Boolean> {
    private final Target target;
    private final String expectedPattern = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/\\d{4}$";

    public DateValueTextQuestion(Target target) {
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualText = target.resolveFor(actor).getText();
        return actualText.matches(expectedPattern);
    }

    public static DateValueTextQuestion ofElement(Target target) {
        return new DateValueTextQuestion(target);
    }
}
