package io.zhc1.realworld.config;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Transient;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

@Transient
public final class RealworldJwt extends AbstractOAuth2TokenAuthenticationToken<Jwt> {
    private final JwtAuthenticationToken delegate;

    public RealworldJwt(Jwt jwt, JwtAuthenticationToken delegate) {
        super(jwt);
        this.delegate = delegate;
    }

    @Override
    public Object getPrincipal() {
        return this.delegate.getPrincipal();
    }

    @Override
    public Object getCredentials() {
        return this.delegate.getCredentials();
    }

    @Override
    public void eraseCredentials() {
        this.delegate.eraseCredentials();
    }

    @Override
    public void setDetails(Object details) {
        this.delegate.setDetails(details);
    }

    @Override
    public Object getDetails() {
        return this.delegate.getDetails();
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        this.delegate.setAuthenticated(authenticated);
    }

    @Override
    public boolean isAuthenticated() {
        return this.delegate.isAuthenticated();
    }

    @Override
    public String getName() {
        return this.delegate.getName();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.delegate.getAuthorities();
    }

    @Override
    public Map<String, Object> getTokenAttributes() {
        return this.delegate.getTokenAttributes();
    }

    public String tokenValue() {
        return delegate.getToken().getTokenValue();
    }

    public UUID userId() {
        return UUID.fromString(delegate.getName());
    }
}
