package ua.org.oa.oatkachenko.Servlets; /**
 * Created by Oleg on 06.02.2016.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;

@WebListener()
public class Listener implements ServletContextListener {
    private static String contextPath;
    private String upload_dir = "upload";
    // Public constructor is required by servlet spec
    public Listener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        contextPath = sce.getServletContext().getRealPath(sce.getServletContext().getContextPath())
                + File.separator + upload_dir;
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    public static String getContextPath() {
        return contextPath;
    }
}
