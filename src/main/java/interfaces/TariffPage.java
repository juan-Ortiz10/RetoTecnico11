package interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TariffPage {
    public static final Target TARIFF_LINK = Target.the("link to go to the tariff page").located(By.xpath("//a[contains(text(), 'Tarifario')]"));
    public static final Target DAF_PDF = Target.the("link to open the DAF pdf").located(By.cssSelector("a[href*='Cuentas-de-Depositos']"));
}
