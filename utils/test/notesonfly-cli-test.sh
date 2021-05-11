JAVA_OPTS="-Dprovider=db -DdbURL=\"jdbc:mysql://localhost:3306/notesonfly\" -DdbUser=\"root\" -DdbPassword=\"password\""
JAR_LOCATION=/D:/workspace/git/NotesOnFly/NotesOnFly-CLI/target/NotesOnFly-CLI-0.0.1-SNAPSHOT-jar-with-dependencies.jar

java $JAVA_OPTS -jar $JAR_LOCATION user list