java -verbose:class --module-path ./build/libs -m demo/demo.HelloWorld
java --module-path ./build/libs -m demo/demo.hw.HelloWorld

jdeps -s ./build/libs/*

http://download.java.net/java/jdk9/docs/api/index.html?overview-summary.html