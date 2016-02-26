设计目标
---------
1. 可扩展性 Extensbility
	* 新的功能容易加入到系统中

2. 灵活性 Flexibility
	* 模块间依赖少，耦合低，当修改代码时，不会波及很多其他模块

3. 可插入性 Pluggability
	* 可以容易地抽出一个模块，并用相同接口的其他模块代替

设计原则
---------
1. 开/闭原则 OCP
	* Open-Closed Principle
	* 一个软件实体应该对扩展开放，对修改关闭
2. 里氏代换原则 LSP
	* Liskov Substitution Principle
	*任何基类可以出现的地方，子类一定可以出现
3. 依赖倒转原则 DIP
	* Dependency Inversion Principle
	* 要依赖于抽象，不要依赖于实现
4. 接口隔离原则 ISP
	* Interface Segregation Principle
	* 应当为客户端提供尽可能小的单独的接口，而不要提供大的总接口
5. 合成/聚合复用原则 CARP
	* Composition/Aggregation Principle
	* 要尽量使用合成/聚合，而不是继承关系来达到复用的目的
6. 迪米特法则 LoD
	* Law of Demeter
	* 一个软件实体应该尽可能少的与其他实体发生相互作用

设计模式
---------
###创建模式###
1. 简单工厂 Simple Factory
2. 工厂方法 Factory Method
3. 抽象工厂 Abstract Factory
4. 单例 Singleton
5. 建造 Builder
6. 原型 Prototype
###结构模式###
7. 适配器 Adapter
	* JDBC驱动就是适配器模式实现
8. 合成 Composite
9. 装饰 Decorator
10. 代理 Proxy
11. 享元 Flyweight Pattern
12. 门面/外观 Facade
13. 桥梁/桥接 Bridge
###行为模式###
14. 不变 Immutable
15. 策略 Strategy
16. 模板方法 Template Method
	* 通过委派，组合调用基本方法完成功能，基本功能则要由子类实现
	* HttpServlet的service()方法
	* Java8添加的大量default method
17. 观察者 Observer
18. 迭代子 Iterator
	* 实现Iterable接口的
	* JDBC的ResultSet
19. 责任链 Chain of Responsibility
	* 对象保有对下家的引用形成一条链，请求在这条链上传递，链上的对象可以决定处理此请求，或者由下家处理，而发出请求的客户端并不知道请求最终由谁处理
20. 命令 Command
21. 备忘录 Memento
22. 状态 State
23. 访问者 Visitor
24. 解释器 Interpreter
25. 调停者 Mediator
