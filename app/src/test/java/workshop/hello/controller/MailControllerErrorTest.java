package workshop.hello.controller;


import org.junit.Test;

import workshop.hello.MainActivity;

import static junit.framework.Assert.assertTrue;

public class MailControllerErrorTest {

    @Test public void
    empty_number1_should_show_error_message() {
        XXX xxx = new XXX();
        MainController mainController = new MainController(xxx);
        mainController.calculate("", "", MainActivity.Operation.ADD);

        assertTrue("Should call showErrorRequiredOfNumber1()", xxx.verify());
    }

}

class XXX implements MainController.MainControllerCallback {

    private boolean called;

    public boolean verify() {
        return called;
    }

    @Override
    public void showErrorRequiredOfNumber1() {
        called = true;
    }

    @Override
    public void showResult(String result) {

    }
}
