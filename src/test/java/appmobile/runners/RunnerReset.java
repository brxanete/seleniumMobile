    package appmobile.runners;


    import io.cucumber.junit.CucumberOptions;
    import net.serenitybdd.cucumber.CucumberWithSerenity;
    import org.junit.runner.RunWith;


    @RunWith(CucumberWithSerenity.class)
    @CucumberOptions(plugin = {"pretty", "json:target/cucumber-json-report.json"},
            features = "src/test/resources/features/",
            glue = "appmobile.stepdefinitions",
            tags = "@ValidacionElementosDelHomePage")
    public class RunnerReset {

    }



