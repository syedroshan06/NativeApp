package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static Keyword.Module.*;



/**
 * @author Syed Caazimuddin
 */
public class Hooks {



    @Before
    public static void before(){



    }

    @After
    public static void after(){

        handlingSystemError();
        Prerequisite();

    }
}
