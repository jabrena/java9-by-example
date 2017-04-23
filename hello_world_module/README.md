```
➜  hello_world_module git:(feature/JIGSAW) ✗ java -verbose:class --module-path ./build/libs -m demo/demo.HelloWorld | grep "class,load" | wc -l
     780
➜  hello_world_module git:(feature/JIGSAW) ✗ java -version
java version "9-ea"
Java(TM) SE Runtime Environment (build 9-ea+163)
Java HotSpot(TM) 64-Bit Server VM (build 9-ea+163, mixed mode)
➜  hello_world_module git:(feature/JIGSAW) ✗ 
``` 

```
➜  libs git:(feature/JIGSAW) ✗ java -verbose:class -jar hello_world-0.1.0-SNAPSHOT.jar | wc -l
     594
➜  libs git:(feature/JIGSAW) ✗ 
```

MODULE

Hello, World
[0,739s][info][class,load] java.lang.Shutdown source: jrt:/java.base
[0,739s][info][class,load] java.lang.Shutdown$Lock source: jrt:/java.base

NO MODULE

Hello, World
[0,558s][info][class,load] java.lang.Shutdown source: jrt:/java.base
[0,558s][info][class,load] java.lang.Shutdown$Lock source: jrt:/java.base
