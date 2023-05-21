package com.example.demo.features.auth.application.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenService {

  private String jwtSigningKey = "secret";

  /**
   * Extracts the username from a string that contains an enconded JWT token.
   * 
   * @param token is a string that represents a JSON Web Token (JWT) which
   *              contains encoded information
   *              about a user or entity. It is used for authentication and
   *              authorization purposes in web applications.
   * @return The method `extractUsername` returns a `String` which is the subject
   *         claim extracted from
   *         the provided token using the `extractClaim` method.
   */
  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  /**
   * Extracts the expiration date from a string that contains an enconded JWT
   * token.
   * 
   * @param token is a string that represents a JSON Web Token (JWT) which
   *              contains encoded information
   *              about a user or entity. It is used for authentication and
   *              authorization purposes in web applications.
   * @return Date object.
   */
  public Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String token) {
    return Jwts.parser().setSigningKey(jwtSigningKey).parseClaimsJws(token).getBody();
  }

  /**
   * Generates an encoded JWT token for the given user details.
   * 
   * @param userDetailsis is an Spring Security interface. It is used to
   *                      authenticate and authorize
   *                      users in a Spring Security-enabled application.
   * @return a generated token using the claims and user details provided.
   */
  public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();
    return createToken(claims, userDetails);
  }

  private String createToken(Map<String, Object> claims, UserDetails userDetails) {
    return Jwts.builder().setClaims(claims)
        .setSubject(userDetails.getUsername())
        .claim("id", userDetails.getAuthorities())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
        .signWith(SignatureAlgorithm.HS256, jwtSigningKey).compact();
  }

  /**
   * Checks if a given token is valid for a given user by verifying the username
   * and
   * expiration date.
   * 
   * @param token       is a string that represents the authentication token that
   *                    was generated for a user
   *                    during the login process. It is used to authenticate
   *                    subsequent requests made by the user to the server.
   * @param userDetails is an Spring Security interface. It is used to
   *                    authenticate and authorize
   *                    users in a Spring Security-enabled application.
   * @return a boolean that indicates if the given token is valid for the given
   *         user.
   */
  public boolean isTokenValid(String token, UserDetails userDetails) {
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

  private boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

}
