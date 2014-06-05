package com.kildeen.ref.application;

import com.kildeen.ref.UserContext;
import com.kildeen.ref.module.user.UserService;
import com.kildeen.ref.system.Initiator;
import org.apache.deltaspike.cdise.api.ContextControl;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.apache.deltaspike.core.api.provider.DependentProvider;
import org.omnifaces.filter.HttpFilter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * Created with IntelliJ IDEA.
 * User: Karl Kildén
 * Date: 2014-06-05
 */

@WebFilter(value = "/*")
public class LoginHack extends HttpFilter {

    @Inject
    private Database database;

    @Inject
    private UserContext userContext;

    @Inject
    UserService userService;

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, HttpSession session, FilterChain chain) throws ServletException, IOException {

        if(request.getParameter("user") != null)  {
            userContext.setUser(userService.fetchByName(request.getParameter("user")));
        }

        if (!userContext.initialized())
        userContext.setUser(database.getSuperUser());

        if (request.getRequestURI().contains("index.xhtml"))
        response.sendRedirect("/pages/content/factOverview.xhtml");
        chain.doFilter(request, response);
    }

}
