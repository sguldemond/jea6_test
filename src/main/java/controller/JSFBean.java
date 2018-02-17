package controller;

import javax.ejb.Stateless;
import javax.inject.Named;

/**
 * Created by stasiuz on 15/02/2018.
 */

@Stateless
@Named("jsfBean")
public class JSFBean {
    private final String demoString = "demo text";

    public String getDemoString() {
        return demoString;
    }
}
