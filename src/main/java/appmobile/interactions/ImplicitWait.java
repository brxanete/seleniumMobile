package appmobile.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class ImplicitWait implements Interaction {
    private final long milliseconds;

    public ImplicitWait(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ImplicitWait forMilliseconds(long milliseconds) {
        return new ImplicitWait(milliseconds);
    }
}
