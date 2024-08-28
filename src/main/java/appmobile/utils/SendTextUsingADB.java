package appmobile.utils;


import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;


public class SendTextUsingADB implements Task {

    private final String text;
    private final Target target;

    public SendTextUsingADB(String text, Target target) {
        this.text = text;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isPresent()).forNoMoreThan(5).seconds()
        );

        WebElementFacade targetElement = target.resolveFor(actor);
        String elementId = getElementIdFromTarget(targetElement);

        if (elementId != null) {
            String adbCommand = String.format("adb shell input text %s --element %s", text, elementId);
            try {
                Process process = Runtime.getRuntime().exec(adbCommand);
            } catch (Exception e) {

            }
        } else {
            System.out.println("No se pudo obtener el identificador del elemento correctamente.");
        }
    }

    private String getElementIdFromTarget(WebElementFacade targetElement) {
        String targetString = targetElement.toString();
        int startIndex = targetString.indexOf("'") + 1;
        int endIndex = targetString.lastIndexOf("'");

        return (startIndex >= 0 && endIndex >= 0 && endIndex > startIndex) ?
                targetString.substring(startIndex, endIndex) : null;
    }

    public static SendTextUsingADB with(String text, Target target) {
        return new SendTextUsingADB(text, target);
    }
}
