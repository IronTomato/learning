package designpattern.proxy;

public class RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("Real object doing something");
    }

}
