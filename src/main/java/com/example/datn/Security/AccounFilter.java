package com.example.datn.Security;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
@Component
public class AccounFilter extends OncePerRequestFilter {
    private final com.example.datn.Security.AccountFilterService accountFilterService;
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String header = httpServletRequest.getHeader("Authorization");
        if(header == null || !header.startsWith("Bearer")){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }
        final String token = header.substring(7);
        String userName = null;
        try{
            userName = accountFilterService.getUsername(token);
        }catch (IllegalArgumentException e){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }catch (ExpiredJwtException e){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }
        if (userName!=null&& SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails account=userDetailsService.loadUserByUsername(userName);
            if (accountFilterService.isTokenValid(token,account)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(account,null,account.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
