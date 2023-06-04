# 기본 이미지로 OpenJDK를 사용합니다.
FROM openjdk:17-jdk

# 컨테이너 내부에 애플리케이션을 배치할 작업 디렉토리를 생성합니다.
WORKDIR /app

# 애플리케이션 JAR 파일을 작업 디렉토리로 복사합니다.
COPY build/libs/*.jar app.jar

# 애플리케이션의 포트 번호를 지정합니다.
EXPOSE 8080

# 컨테이너가 시작될 때 실행할 명령을 지정합니다.
CMD ["java", "-jar", "app.jar"]