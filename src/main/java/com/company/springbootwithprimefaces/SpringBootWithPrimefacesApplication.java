package com.company.springbootwithprimefaces;

import com.company.springbootwithprimefaces.controllers.ViewScope;
import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.ErrorPage;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringBootWithPrimefacesApplication implements WebApplicationInitializer
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootWithPrimefacesApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean facesServletRegistraiton()
    {
        ServletRegistrationBean registration = new ServletRegistrationBean(new FacesServlet(), new String[]{"*.xhtml"});
        registration.setName("Faces Servlet");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer()
    {
        return servletContext ->
        {
            servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
            servletContext.setInitParameter("primefaces.THEME", "bootstrap");
            servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
            servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
            servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
            servletContext.setInitParameter("primefaces.UPLOADER", "commons");
        };
    }

    @Bean
    public static CustomScopeConfigurer customScopeConfigurer()
    {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        Map<String, Object> scopes = new HashMap<String, Object>();
        scopes.put("view", new ViewScope());
        configurer.setScopes(scopes);
        return configurer;
    }

    @Override
    public void onStartup(ServletContext container)
    {
        ServletRegistration.Dynamic registration = container.addServlet("MVC Servlet", new DispatcherServlet());
        registration.setLoadOnStartup(1);
        registration.addMapping("/api/*");
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer()
    {

        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();

        TomcatContextCustomizer contextCustomizer = new TomcatContextCustomizer()
        {
            @Override
            public void customize(Context context)
            {
                context.addWelcomeFile("index.xhtml");
                ErrorPage errorPage = new ErrorPage();
                errorPage.setErrorCode(500);
                errorPage.setExceptionType("java.lang.Throwable");
                errorPage.setLocation("/error/errorOccured.xhtml");
                //TODO error pages not working
                context.addErrorPage(errorPage);
            }
        };
        factory.addContextCustomizers(contextCustomizer);

        return factory;
    }

}
