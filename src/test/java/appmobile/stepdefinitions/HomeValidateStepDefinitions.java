package appmobile.stepdefinitions;


import appmobile.questions.ElementEnabledQuestion;
import appmobile.questions.ElementVisibleQuestion;
import appmobile.tasks.*;
import appmobile.utils.UserDataTransformer;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


import static appmobile.userinterfaces.HomePage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;

public class HomeValidateStepDefinitions {

    private final UserDataTransformer userDataTransformer = new UserDataTransformer();


    @Before
    public void setTheStageBeforeScenario() {
        OnStage.setTheStage(
                new OnlineCast());
    }

    @After
    public void tearDownAfterScenario() {
        theActorCalled("Engineer").attemptsTo(
                new CloseTestExecution());
    }


    @Given("El usuario esta en el home page")
    public void userIsOnHomePage() {
        theActorCalled("Bryan").should(
                seeThat("Validate presence home principal logo", ElementVisibleQuestion.ofElement(robotImage, 10), equalTo(true)),
                seeThat("Validate enabled principal logo", ElementEnabledQuestion.ofElement(robotImage, 10), equalTo(true))
        );
    }

    @Then("El usuario valida los elementos visuales")
    public void userValidateHomeElements() {
        theActorCalled("Bryan").should(
                seeThat("Validate presence home principal logo", ElementVisibleQuestion.ofElement(robotImage, 10), equalTo(true))
        );
    }

}












