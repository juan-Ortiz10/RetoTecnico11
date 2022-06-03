package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Verify implements Question<Boolean> {
    private String pdfText;

    public Verify(String pdfText) {
        this.pdfText = pdfText;
    }

    public static Verify titleWith(String pdfText) {
        return new Verify(pdfText);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return pdfText.contains("Tarifas de cuentas de Depósitos");
    }
}
