package envorinment;


import envorinment.driver.AndroidDriver;
import envorinment.steps.AndroidSteps;

public final class EnvironmentFactory {

    public static AndroidSteps init() throws Exception {
        return new AndroidSteps(new AndroidDriver());
    }
}
