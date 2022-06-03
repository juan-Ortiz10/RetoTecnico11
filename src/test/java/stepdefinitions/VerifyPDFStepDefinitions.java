package stepdefinitions;

import abilities.ReadPDF;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;
import questions.Verify;
import tasks.Go;
import tasks.OpenUp;
import tasks.See;

import java.io.IOException;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class VerifyPDFStepDefinitions {
    private EnvironmentVariables environmentVariables;
    private String downloadFolder;
    private String fileName;
    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Camilo");
    }
    @Given("that Camilo is in the Banitsmo Page")
    public void thatCamiloIsInTheBanitsmoPage() {
        downloadFolder = environmentVariables.optionalProperty("download.filesFolder")
                        .orElseThrow(IllegalArgumentException::new);
        fileName = environmentVariables.optionalProperty("statements.fileName")
                .orElseThrow(IllegalArgumentException::new);
        theActorInTheSpotlight().wasAbleTo(OpenUp.thePage());
    }
    @Given("he goes to the tariff page")
    public void heGoesToTheTariffPage() {
        theActorInTheSpotlight().attemptsTo(Go.toTariffPage());
    }
    @When("he click the Deposit Account Fees")
    public void heClickTheDepositAccountFees() throws InterruptedException {
        theActorInTheSpotlight().attemptsTo(See.theDAFService());
        Thread.sleep(10000);
    }
    @Then("he sees the PDF of that service")
    public void heSeesThePDFOfThatService() throws IOException {
        String statementFilePath = "C:/Users/jortizf/Downloads/Tarifario-Cuentas-de-Depositos.pdf";
        theActorInTheSpotlight().whoCan(ReadPDF.downloadedInPath(statementFilePath));
        String pdfText = ReadPDF.as(theActorInTheSpotlight()).getText();
        theActorInTheSpotlight().should(seeThat(Verify.titleWith(pdfText)));
    }
}
