package alex.pol;

import alex.pol.domain.Street;
import alex.pol.domain.UserData;
import alex.pol.service.StreetService;
import alex.pol.service.UserDataService;
import alex.pol.util.ClassNameUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.sql.SQLException;
import java.util.List;
@SpringBootApplication
@EnableGlobalMethodSecurity
@EnableAutoConfiguration // enables auto configuration from a yml file
@ComponentScan // informs spring to component scan from this package down
public class Application extends SpringBootServletInitializer {
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public static void main(String[] args) throws SQLException {
//        // Sets the application properties from the yml file in resources.
//        System.setProperty("spring.config.name", "application");
    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}

