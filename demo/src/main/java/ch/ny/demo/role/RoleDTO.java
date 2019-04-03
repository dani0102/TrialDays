package ch.ny.demo.role;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import ch.ny.demo.authority.AuthorityDTO;

public class RoleDTO {

	@NotBlank
	private String name;
	
	@NotNull
	private Set<AuthorityDTO> authorities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<AuthorityDTO> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<AuthorityDTO> authorities) {
		this.authorities = authorities;
	}
}
