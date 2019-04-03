package ch.ny.demo.role;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

	RoleDTO toDTO(Role role);
	
	List<RoleDTO> toListDTO(List<Role> roles);
	
	Role toEntity(RoleDTO role);
}
