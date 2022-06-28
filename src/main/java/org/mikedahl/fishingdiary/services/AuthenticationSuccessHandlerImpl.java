package org.mikedahl.fishingdiary.services;
import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mikedahl.fishingdiary.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;



@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler{

    @Autowired HttpSession session; //autowiring session

    @Autowired
    UserRepository repository; //autowire the user repo
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl.class);
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // TODO Auto-generated method stub
        String userName = "";
        if(authentication.getPrincipal() instanceof Principal) {
            userName = ((Principal)authentication.getPrincipal()).getName();

        }else {
            userName = ((User)authentication.getPrincipal()).getUsername();
        }
        logger.info("username: " + userName);
        //HttpSession session = request.getSession();
        session.setAttribute("username", userName);
        redirectStrategy.sendRedirect(request,response,"/diarypage");

    }

}
