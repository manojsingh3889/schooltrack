package org.app.security;

public interface ISecurityUserService {

    String validatePasswordResetToken(long id, String token);

}
