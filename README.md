# akka hello word from docker container
1. _sbt docker:publishLocal_- to create image
2. _docker run -itd -p 8080:8080 --name akka-hello-word akka-hello-word:0.2_- run container from that image
3. _docker container ls_ - to make sure that container with name "akka-hello-word" is up
4. _http://localhost:8080/hello_ or _curl localhost:8080/hello_(from terminal) - you should see "Hi there !!! =)"