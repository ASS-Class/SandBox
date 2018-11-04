

public class Base {

    void startSeleniumSandBox() {
        SeleniumSandBox seleniumSandBox = new SeleniumSandBox();
        seleniumSandBox.startSelenium();
    }
    void startThreadSandBox() {
        ThreadSandBox threadSandBox = new ThreadSandBox();
        threadSandBox.go();
    }
    void startStreamSandBox(){
        StreamsSandBox streamsSandBox = new StreamsSandBox();
        streamsSandBox.go();
    }
}
