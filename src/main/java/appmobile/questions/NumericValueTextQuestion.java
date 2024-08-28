package appmobile.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.targets.Target;

@Subject("whether the text of the element matches the expected pattern for a numeric value")
public class NumericValueTextQuestion implements Question<Boolean> {
    private final Target target;
    private final String expectedPattern = "\\$?\\s*\\d{1,3}(\\.\\d{3})*(\\.\\d+)?";

    public NumericValueTextQuestion(Target target) {
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualText = target.resolveFor(actor).getText();
        return actualText.matches(expectedPattern);
    }

    public static NumericValueTextQuestion ofElement(Target target) {
        return new NumericValueTextQuestion(target);
    }
}