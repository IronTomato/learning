练习代码和笔记

    Java/code/lab/src  
        ├─algorithm
        │      QuickSort.java       //快速排序实现
        │      QuickSortTest.java
        │      
        ├─designpattern
        │  ├─proxy
        │  │      Client.java
        │  │      Interface.java
        │  │      Proxy.java
        │  │      RealObject.java
        │  │      
        │  └─singleton
        │          Singleton.java   //双重检查加算实现单例
        │          SingletonFactory.java    //注册实现单例
        │          SingletonFactoryTest.java
        │          
        ├─mybatis           //mybatis demo
        │  │  City.java
        │  │  CityDao.java
        │  │  CityDaoImpl.java
        │  │  DaoFactory.java
        │  │  mybatis.xml
        │  │  MyBatisUtil.java
        │  │  SessionLoanee.java    //实现针对session的贷出模式
        │  │  TestMybatis.java
        │  │  
        │  └─mappers
        │          CityMapper.xml
        │          
        └─util
            │  Fabonacci.java
            │  Range.java       //一个整数范围，实现Iterable接口，stream API
            │  
            └─test
                    TestFabonacci.java
                    TestRange.java