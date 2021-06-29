package com.reofixy.reobb.core.security;

import com.reofixy.reobb.model.dto.SecurityToken;
import com.reofixy.reobb.service.SecurityTokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestFilter extends OncePerRequestFilter {
    private SecurityTokenService securityTokenService;

    public RequestFilter(SecurityTokenService securityTokenService){
        this.securityTokenService = securityTokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authorization = httpServletRequest.getHeader("Authorization");

        if (authorization != null && authorization.startsWith("Bearer ")){
            String token = authorization.replace("Bearer ", "");
            SecurityToken securityToken = new SecurityToken(token);
            if (securityTokenService.isSecurityTokenValid(securityToken) && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = securityTokenService.getUserDetailsFromToken(securityToken);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
