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

 time java -verbose:class --module-path ./build/libs -m demo/demo.HelloWorld

java -verbose:class --module-path ./build/libs -m demo/demo.HelloWorld  0,42s user 0,07s system 80% cpu 0,600 total

java -verbose:class -jar hello_world-0.1.0-SNAPSHOT.jar  0,26s user 0,05s system 75% cpu 0,419 total

time java -verbose:class -jar hello_world-0.1.0-SNAPSHOT.jar

java -verbose:class -jar hello_world-0.1.0-SNAPSHOT.jar  0,13s user 0,03s system 50% cpu 0,311 total

time java -verbose:class -jar hello_world-0.1.0-SNAPSHOT.jar

java version "9-ea" java -verbose:class --module-path ./build/libs -m demo/demo.HelloWorld  0,42s user 0,07s system 80% cpu 0,600 total
java version "9-ea" java -verbose:class -jar hello_world-0.1.0-SNAPSHOT.jar  0,26s user 0,05s system 75% cpu 0,419 total
java version "1.8.0_121" java -verbose:class -jar hello_world-0.1.0-SNAPSHOT.jar  0,13s user 0,03s system 50% cpu 0,311 total
