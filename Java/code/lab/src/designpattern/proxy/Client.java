package designpattern.proxy;

import static org.junit.Assert.*;

import org.junit.Test;

public class Client {

    @Test
    public void testReal() {
       Interface real =  new RealObject();
       real.doSomething();
    }
    
    @Test
    public void testProxy(){
        Interface real = new RealObject();
        Interface proxy = new Proxy(real);
        proxy.doSomething();
    }

}
