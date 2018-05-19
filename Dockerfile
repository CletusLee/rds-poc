FROM java
ADD ./target/rds-poc-0.0.1-SNAPSHOT.jar /rds-poc-0.0.1-SNAPSHOT.jar
ADD ./run.sh /run.sh
RUN chmod a+x /run.sh
EXPOSE 8080
EXPOSE 80
CMD /run.sh