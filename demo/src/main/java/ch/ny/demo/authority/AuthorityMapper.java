package ch.ny.demo.authority;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorityMapper {

	AuthorityDTO toDTO(Authority authority);
	
	List<AuthorityDTO> toListDTO(List<Authority> authorities);
	
	Authority toEntity(AuthorityDTO authority);
}
