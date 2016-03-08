package designpattern.singleton;

public class Singleton {

    //volatile关键字是必须的
    private static volatile Singleton instance = null;
    
    private Singleton(){}
    
    //双重检查锁定
    public static Singleton getInstance(){
        if(instance != null)
            return instance;
        synchronized (Singleton.class) {
            if(instance == null){
                instance = new Singleton();
            }
            return instance;
        }
    }
}
