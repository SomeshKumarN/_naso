package naso.nueral;

import org.openqa.selenium.WebDriver;

public class NasoFrameWork {

    protected final NasoDriver nasoDriver;

//    public NasoFrameWork() {
//        nasoDriver = new NasoDriver();
//    }

    public NasoFrameWork(){
        nasoDriver = new NasoDriver();
    }
    public NasoFrameWork(WebDriver driver) {
        nasoDriver = new NasoDriver(driver);
    }



}
