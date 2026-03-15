package pl.kurs.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    //java: java.lang.NoSuchFieldError: Class com.sun.tools.javac.tree.JCTree$JCImport does not have member field
    // 'com.sun.tools.javac.tree.JCTree qualid' - zła wersja Javy
    //reszta problemów w controller - opisana
    //logging.level.ROOT=TRACE -- zamiana na INFO

    // WARN 25580 --- [nio-8080-exec-1] org.hibernate.orm.query    : HHH90003004: firstResult/maxResults specified
    // with collection fetch; applying in memory - potrzebna zmiana w repository, złe query, jak pracujesz na dto to
    // pamiętaj też aby zwracać dto
}