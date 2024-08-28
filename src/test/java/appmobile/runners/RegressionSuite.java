package appmobile.runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RunnerReset.class,
        RunnerNoReset.class
})
public class RegressionSuite {
}
