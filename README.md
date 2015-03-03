#### 2. Tomcat 서버를 시작할 때 웹 애플리케이션이 초기화하는 과정을 설명하라.
* ContextListener를 통해 db를 초기화 하고, 메모리에 올린다.
* RequestMapping 클래스의 initMapping() 메소드가 mappings map에 url에 맞는 controller를 추가한다.

#### 3. Tomcat 서버를 시작한 후 http://localhost:8080으로 접근시 호출 순서 및 흐름을 설명하라.
* index.jsp에서 sendRedirect를 통해 list.next로 이동하고, dispatcherServlet의 service 메소드가 이 uri에 맞는 controller를 mappings map에서 찾아 실행하고, controller가 return하는 mav의 view를 rendering하여 response한다.

#### 10. ListController와 ShowController가 멀티 쓰레드 상황에서 문제가 발생하는 이유에 대해 설명하라.
* Controller가 서버 시작할 때, 하나의 인스턴스만 생성해서 맵핑을 하는데 global 변수를 사용하면 사용자의 데이터가 공유되어 잘못된 정보를 줄 수 있다.

