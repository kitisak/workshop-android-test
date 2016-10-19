package workshop.hello.controller;


import org.junit.Test;

import workshop.hello.MainActivity;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class MailControllerSuccessTest {

    @Test public void
    add() throws InterruptedException {
        YYY yyy = new YYY();
        MainController mainController = new MainController(yyy);
        mainController.calculate("1", "1", MainActivity.Operation.ADD);

        Thread.sleep(1000);

        assertTrue("Should call showResult()", yyy.verify());
    }

    @Test public void
    minus() throws InterruptedException {
        YYY yyy = new YYY();
        MainController mainController = new MainController(yyy);
        mainController.calculate("1", "1", MainActivity.Operation.Minus);

        Thread.sleep(1000);

        assertTrue("Should call showResult()", yyy.verify());
    }

}

class YYY implements MainController.MainControllerCallback {

    private boolean called;

    public boolean verify() {
        return called;
    }

    @Override
    public void showErrorRequiredOfNumber1() {
    }

    @Override
    public void showResult(String result) {
        called = true;
    }
}

