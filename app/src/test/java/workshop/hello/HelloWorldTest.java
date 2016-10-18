package workshop.hello;


import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HelloWorldTest {

    @Test public void
    show_message_Hello_somkiat_when_name_is_somkiat() {
        String expectedMessage = "Hello somkiat";
        //Arrange
        HelloWorld helloWorld = new HelloWorld("somkiat");
        //Act
        String actualMessage = helloWorld.showMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test public void
    show_message_Hello_pui_when_name_is_pui() {
        String expectedMessage = "Hello pui";
        //Arrange
        HelloWorld helloWorld = new HelloWorld("pui");
        //Act
        String actualMessage = helloWorld.showMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

}
