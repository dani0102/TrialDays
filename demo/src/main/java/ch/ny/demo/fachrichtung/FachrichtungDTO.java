package ch.ny.demo.fachrichtung;

import javax.validation.constraints.NotBlank;

public class FachrichtungDTO {

	@NotBlank
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}