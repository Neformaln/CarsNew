package framework.webdriver;

/**
 * Created by d.korobkin on 6/15/17.
 */
public enum BrowserEnum {
    CHROME("Chrome"),
    FIREFOX("Firefox");
    public String value;

    BrowserEnum(final String values){
        value = values;
    }

    public String toString(){
        return value;
    }
}



