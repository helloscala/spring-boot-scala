# spring-boot-scala

Spring程序员的Scala开始计划 or Scala程序员的Spring使用方法

*推荐使用 gradle 或 sbt 运行*

```
git clone https://github.com/yangbajing/spring-boot-scala.git
cd spring-boot-scala
```

**Gradle**

```
./gradlew -p web bootRun
```

**Sbt**

```
./sbt
spring-boot-scala > project web  # 
web > runMain me.yangbajing.springbootscala.SpringscalaApplication
```

打开浏览器访问：[http://localhost:18080/web/message](http://localhost:18080/web/message) 或 [http://localhost:18080/api/message](http://localhost:18080/api/message)。

也可通过命令行访问Spring Boot应用：

```
curl -v http://localhost:18080/web/message
curl -v http://localhost:18080/api/message
```
