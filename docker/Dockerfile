FROM openjdk:15-slim

# the build context is `$REPO/target`
ADD bundle/lib /app/lib
ADD classes /app/classes

WORKDIR /app

CMD java -cp "classes:lib/*" backend.main
