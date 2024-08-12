package ver2_aop_xml_around;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
//        Boy daewon = new Boy();
//        daewon.makeTaco();
//
//        Girl jieun = new Girl();
//        jieun.makeSamgyepsal();
        ApplicationContext ctx = new FileSystemXmlApplicationContext("/src/main/java/ver2_aop_xml_around/beans.xml");
        Boy daewon = (Boy) ctx.getBean("daewon");
        daewon.makeTaco();

        Girl jieun = (Girl) ctx.getBean("jieun");
        jieun.makeSamgyepsal();
    }
}
