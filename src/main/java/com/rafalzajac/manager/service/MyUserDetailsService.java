package com.rafalzajac.manager.service;

import com.rafalzajac.manager.domain.Player;
import com.rafalzajac.manager.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Custom implementation of user details service. First it finds player in data base by its user name and throws
 * error if there is none. Returns user details as a MyUserPrincipal class.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player player = playerRepository.findByUsername(username);
        if(player == null) {
            throw new UsernameNotFoundException(username);
        }

        return new MyUserPrincipal(player);
    }
}
