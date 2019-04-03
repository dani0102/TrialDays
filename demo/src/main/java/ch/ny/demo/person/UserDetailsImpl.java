package ch.ny.demo.person;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ch.ny.demo.authority.Authority;
import ch.ny.demo.role.Role;

public class UserDetailsImpl implements UserDetails {
		
		private Person user;
		
		/**
		 *
		 */
		public UserDetailsImpl() {
			super();
		}
		
		/**
		 * @param user
		 */
		@Autowired
		public UserDetailsImpl(Person user) {
			super();
			this.user = user;
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
			for (Role role : user.getRoles()) {
				for (Authority authority : role.getAuthorities()) {
					grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
				}
			}
			return grantedAuthorities;
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getPassword() {
			return user.getPassword();
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getUsername() {
			return user.getUsername();
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isAccountNonExpired() {
			// TODO implement account expired check
			return true;
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isAccountNonLocked() {
			return !user.isLocked();
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isCredentialsNonExpired() {
			// TODO implement credentials expired check
			return true;
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isEnabled() {
			return user.isEnabled();
		}
		
		/**
		 * @return the user
		 */
		public Person getUser() {
			return user;
		}
		
		/**
		 * @param user the user to set
		 */
		public void setUser(Person user) {
			this.user = user;
		}
	
}
