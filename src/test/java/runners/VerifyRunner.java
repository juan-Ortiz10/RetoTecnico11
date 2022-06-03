package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@CucumberOptions(features = "src/test/resources/features/tarifario.feature",
glue = {"stepdefinitions", "utils"},
tags = "@automatizacion",
snippets = CucumberOptions.SnippetType.CAMELCASE)
@RunWith(CucumberWithSerenity.class)
public class VerifyRunner {
}
