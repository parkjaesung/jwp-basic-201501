#### 2. Tomcat 서버를 시작할 때 웹 애플리케이션이 초기화하는 과정을 설명하라.
* 서블릿 컨테이너는 컨테스트가 초기화 또는 종료 되는 시점에 이벤트를 발생시킨다.
* 이때 @webListener로 등록된 ContextLoaderListener가 연락을 듣고 contextInitialized메소드를 실행한다.
* https://tomcat.apache.org/tomcat-5.5-doc/servletapi/javax/servlet/Servlet.html
* 위에 링크가면 init메소드가 서블릿이 인스턴스화 되자마자 바로 호출 한데요
* "The servlet container calls the init method exactly once after instantiating the servlet."

#### 3. Tomcat 서버를 시작한 후 http://localhost:8080으로 접근시 호출 순서 및 흐름을 설명하라.
* index.jsp가 호출되면 스크립틀릿 코드 response.sendRedirect("/list.next"); 를 실행한다.
* 사용자가 요청한 list.next 가 @WebServlet(name="dispatcher", urlPatterns="*.next")의해 
* DispatcherServlet의 service메소드를 실행한다.
* service메소드 에서 RequestMapping의 findController메소드가 req.getRequestURI()에 해당하는 controller를 찾아준다.
* list.next에 맵핑되는 ListController의 excute 메소드 가 호출된다.
* list.jsp 파일을 보여준다.

#### 10. ListController와 ShowController가 멀티 쓰레드 상황에서 문제가 발생하는 이유에 대해 설명하라.
* reauestMapping 메소드를 통해 ListController 와 ShowContorller 인스턴스가 하나만 만들어진다.
* 하나씩 만들어진 인스턴스 안에 있는 멤버 변수(멤버 필드)는 여러 사용자가 공유하게 된다.
* 그러므로 메소드가 인스턴스안에 있는 멤버 변수에 동시에 접근할 경우 문제가 발생한다.
   

