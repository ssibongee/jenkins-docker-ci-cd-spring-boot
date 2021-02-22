Jenkins와 Docker를 이용하여 스프링 부트 애플리케이션을 서버에 배포하는 Jenkins 파이프라인 구축을 연습하기 위한 레포지토리입니다.

### 프로젝트에서 다룰 내용

* CI/CD란 무엇인가 왜 CI/CD를 사용해야하는지에 대해서 
* Jenkins란 무엇이며 Jenkins를 이용한 배포시나리오 구성하기
* Jenkins를 이용한 배포를 자동화하기 위한 Jenkins Pipeline에 대해서 학습하고 구성하기
* Dockerfile을 이용하여 배포한 스프링 애플리케이션을 도커 이미지로 만들어서 실행
* `application.properties`를 환경별로 나누고 외부에서 주입받는 방법을 적용하기 
* Docker Compose를 이용하여 MySQL 서버 구성하기 
* MySQL 서버 이중화 적용하기 및 애플리케이션에 이중화 적용
* Redis를 이용한 캐시서버 이중화 적용하기 

### 사용 기술
* Java 11
* Spring Boot 2.4.2, Spring 5.3.1
* MySQL 5.7
* Redis
