package appmobile.utils;

import org.openqa.selenium.By;

public class ByConverter {

    public static String convertToString(By by) {
        String result = null;
        if (by != null) {
            String locator = by.toString();
            String[] parts = locator.split(": ");
            if (parts.length == 2) {
                result = parts[1];
            }
        }
        return result;
    }
}