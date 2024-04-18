FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM adoptopenjdk:17-jdk-hotspot AS runtime

# Install necessary dependencies for running Chrome in headless mode
RUN apk add --no-cache \
    chromium \
    chromium-chromedriver \
    udev \
    ttf-freefont

# Set up Chrome options to run in headless mode
ENV CHROME_BIN=/usr/bin/chromium-browser \
    CHROME_PATH=/usr/lib/chromium/
ENV PATH=$PATH:/usr/lib/chromium/

COPY --from=build /app/target/selenium-docker.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
