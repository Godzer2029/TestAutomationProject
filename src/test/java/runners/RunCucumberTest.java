package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.runner.RunWith;

@IncludeEngines("cucumber")
@IncludeTags("SmokeTest")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Путь к вашим .feature файлам
        glue = "cucumber.steps" // Путь к вашим классам с определением шагов
)

public class RunCucumberTest {

}
