package hello.embed;

import hello.servlet.HelloServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class EmbedTomcatServletMain {

    public static void main(String[] args) throws LifecycleException {
        System.out.println("EmbedTomcatServletMain.main");

        // 톰캣 설정
        Tomcat tomcat = new Tomcat();
        // 톰캣을 어디에 연결할지 클라이언트 요청에 대한 커넥터
        Connector connector = new Connector();
        connector.setPort(8080);
        tomcat.setConnector(connector);

        // 서블릿 등록
        // 톰캣 컨텍스트 파일 있으면 등록 (설정 파일)
        Context context = tomcat.addContext("", "/");
        // 현재 만든 서블릿 등록
        tomcat.addServlet("", "helloServlet", new HelloServlet());
        // 서블릿 url 매핑
        context.addServletMappingDecoded("/hello-servlet", "helloServlet");
        tomcat.start();
    }
}
