package com.rafalzajac.manager.service;

import com.rafalzajac.manager.domain.Player;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import java.util.Collection;

/**
 * Class defining principal with implementation of user details methods. Sets almost everything to true since I'm not
 * checking account expiration or other values anywhere. It only returns provided user name and password.
 */
public class MyUserPrincipal implements UserDetails {

    private Player player;

    public MyUserPrincipal(Player player) {
        this.player = player;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return player.getPassword();
    }

    @Override
    public String getUsername() {
        return player.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
