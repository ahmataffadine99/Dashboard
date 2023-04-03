package com.epitech.dashboard.config;

import com.epitech.dashboard.facade.MauvaisTokenException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private JwtTokens jwtTokens;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, JwtTokens jwtTokens) {
        super(authenticationManager);
        this.jwtTokens = jwtTokens;

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //A chaque requette le token doit etre fournit
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token == null) {
            SecurityContextHolder.clearContext();
        } else {
            UsernamePasswordAuthenticationToken authentication = null;
            try {
                authentication = jwtTokens.decodeToken(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (MauvaisTokenException e) {
                SecurityContextHolder.clearContext();
            }
        }
        chain.doFilter(request, response);
    }
}
