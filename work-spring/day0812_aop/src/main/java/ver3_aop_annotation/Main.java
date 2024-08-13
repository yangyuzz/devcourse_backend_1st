package ver3_aop_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
//        Boy daewon = new Boy();
//        daewon.makeTaco();
//
//        Girl jieun = new Girl();
//        jieun.makeSamgyepsal();
//        ApplicationContext ctx = new FileSystemXmlApplicationContext("/src/main/java/ver1_aop_xml/beans.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Boy daewon = (Boy) ctx.getBean("daewon");
        daewon.makeTaco();

//        Girl jieun = (Girl) ctx.getBean("jieun");
//        jieun.makeSamgyepsal();
    }
}