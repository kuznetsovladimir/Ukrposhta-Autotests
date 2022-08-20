package Utils;

import com.codeborne.selenide.Configuration;

public class WebDriverFactory {
    public void GetDriver(String name){
        if("FIREFOX".equalsIgnoreCase(name)){
            Configuration.browser = "firefox";
            Configuration.browserSize = "1400x900";
        } else{
            Configuration.browser = "chrome";
            Configuration.browserSize = "1400x900";
        }
    }
}
