package tasks;

import interfaces.TariffPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class See implements Task {
    public static See theDAFService() {
        return Tasks.instrumented(See.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(TariffPage.DAF_PDF));
    }
}
