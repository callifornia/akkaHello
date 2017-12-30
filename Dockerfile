FROM java:8
ENV SBT_VERSION 1.0.4

RUN curl -L -o sbt-$SBT_VERSION.deb https://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get update && \
  apt-get install sbt && \
  sbt sbtVersion && \
  apt-get install -y git && \
  mkdir /usr/src/app && \
  cd /usr/src/app && \
  git clone https://github.com/callifornia/akkaHello.git && \
  cd akkaHello && \
  sbt clean compile assembly && \ 
  java -jar target/scala-2.12/akkaHello-assembly-0.1.jar
EXPOSE 8080