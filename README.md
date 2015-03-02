#### 2. Tomcat 서버를 시작할 때 웹 애플리케이션이 초기화하는 과정을 설명하라.
* 서블릿 컨테이너는 컨테스트가 초기화 또는 종료 되는 시점에 이벤트를 발생시킨다.
* 이때 @webListener로 등록된 ContextLoaderListener가 연락을 듣고 contextInitialized메소드를 실행한다.

#### 3. Tomcat 서버를 시작한 후 http://localhost:8080으로 접근시 호출 순서 및 흐름을 설명하라.
* 

#### 10. ListController와 ShowController가 멀티 쓰레드 상황에서 문제가 발생하는 이유에 대해 설명하라.
* 

