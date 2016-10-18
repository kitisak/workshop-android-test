package workshop.hello;

public class HelloWorld {

    private String name;

    public HelloWorld(String name) {
        this.name = name;
    }

    public String showMessage() {
        return String.format("Hello %s", this.name);
    }

    public void meaw() {
        int a=10;
    }
}
