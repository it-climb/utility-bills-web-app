package alex.pol;

import alex.pol.domain.Street;
import alex.pol.domain.UserData;
import alex.pol.service.StreetService;
import alex.pol.service.UserDataService;
import alex.pol.util.ClassNameUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
//@EnableOAuth2Sso
public class Application extends SpringBootServletInitializer {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public static void main(String[] args) throws SQLException {

    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}

