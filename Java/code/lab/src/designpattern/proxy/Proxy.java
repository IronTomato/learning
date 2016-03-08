package designpattern.proxy;

public class Proxy implements Interface {

    private Interface real;
    public Proxy(Interface real){
        this.real = real;
    }
    @Override
    public void doSomething() {
        System.out.println("Before real do something");
        real.doSomething();
        System.out.println("After real do something");
    }

}
