

public class Base {

    void startSelenium() {
        SeleniumSandBox seleniumSandBox = new SeleniumSandBox();
        seleniumSandBox.startSelenium();
    }
    void startThreadSandBox() {
        ThreadSandBox threadSandBox = new ThreadSandBox();
        threadSandBox.go();
    }
}
