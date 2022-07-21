package com.system.sit.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.system.sit.persistence.main.entity.Person;
import com.system.sit.persistence.main.entity.PersonRole;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JwtUser implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6250234144260634731L;
	private Long id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser(Long id, String username, String password, 
    		Collection<? extends GrantedAuthority> authorities) {
    	this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static JwtUser build(Person person, Collection<PersonRole> personRoles){
        List<GrantedAuthority> authorities =
        		personRoles.stream().map(role -> new SimpleGrantedAuthority(
                		role.getRole().getRoleName())).collect(Collectors.toList());
        return new JwtUser(
        		person.getPersonId(), 
        		person.getPersonUsername(), 
        		person.getPersonPassword(), 
        		authorities);
    }
    
    public Long getId() {
    	return this.id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
    
    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      JwtUser user = (JwtUser) o;
      return Objects.equals(this.id, user.id);
    }
}