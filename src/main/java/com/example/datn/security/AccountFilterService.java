package com.example.datn.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class AccountFilterService {
    private final String singInKey="7A25432A462D4A614E645266556A586E3272357538782F413F4428472B4B6250";

    private SecretKey getSignInkey(){
        byte[] key = Base64.getDecoder().decode(singInKey);
        return Keys.hmacShaKeyFor(key);
    }
    private Claims getClaims(String token){
        return Jwts
                .parser()
                .setSigningKey(getSignInkey())
                .parseClaimsJws(token)
                .getBody();
    }
    private <T> T extractClaim(String token, Function<Claims, T> getClaimValue){
        final Claims claims = getClaims(token);
        return  getClaimValue.apply(claims);
    }

    public  String getUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }
    private String generateToken(HashMap<String,Object> claims, Authentication account){
        UserDetails userDetails = (UserDetails) account.getPrincipal();
        return  Jwts
                .builder()
                .setClaims(new HashMap<>())
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*2*60*60))
                .signWith(getSignInkey())
                .compact();
    }
    private boolean isTokenExpired(String token){
        Date expiredDate = extractClaim(token,Claims::getExpiration);
        return new Date().after(expiredDate);
    }
    public boolean isTokenValid(String token,UserDetails userDetails){
        return !isTokenExpired(token)&&
                isTheSameUser(token,userDetails)&&
                isAccountEnable(userDetails);
    }
    public String generateToken(Authentication account){
        return generateToken(new HashMap<>(),account);
    }
    public boolean isAccountEnable(UserDetails userDetails){return userDetails.isEnabled();}
    public boolean isTheSameUser(String token,UserDetails userDetails){
        return userDetails.getUsername().equals(getUsername(token));
    }
    public String refreshToken(String token){
        if (isTokenValid(token,null)){
            Claims claims = getClaims(token);
            HashMap<String,Object> newClaims = new HashMap<>(claims);

            long expirationTime = System.currentTimeMillis() + 1000 * 24 * 60 * 60;
            newClaims.put("exp",new Date(expirationTime));
            return Jwts.builder().setClaims(newClaims).setIssuedAt(new Date()).setExpiration(new Date(expirationTime)).signWith(getSignInkey()).compact();
        }else {
            return null;
        }
    }
}
