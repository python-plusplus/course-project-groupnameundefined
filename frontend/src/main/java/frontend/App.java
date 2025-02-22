package frontend;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private MainFrame mainFrame;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        new SpringApplicationBuilder(App.class).headless(false).run(args);

        ctx.close();
    }

    @Override
    public void run(String... args) {
        mainFrame.initalize();
    }

}
