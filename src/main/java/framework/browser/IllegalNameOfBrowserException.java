package framework.browser;

import framework.utils.LoggerMes;

public class IllegalNameOfBrowserException extends IllegalArgumentException {
    public IllegalNameOfBrowserException() {
        LoggerMes.logError("Illegal name of browser!");
        System.out.println("Illegal name of browser! Check your browser name");
    }

}
