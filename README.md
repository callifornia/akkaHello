# akka hello word from docker container
1. `sbt docker:publishLocal` - to create image
2. `docker run -itd -p 8080:8080 --name akka-hello-word akka-hello-word:0.2` - run container from that image
3. `docker container ls` - to make sure that container with name "akka-hello-word" is up
4. `http://localhost:8080/hello` or `curl localhost:8080/hello`(from terminal) - you should see "Hi there !!! =)"