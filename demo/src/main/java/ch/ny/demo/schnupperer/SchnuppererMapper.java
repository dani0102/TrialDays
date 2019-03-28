package ch.ny.demo.schnupperer;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SchnuppererMapper {

	SchnuppererDTO toDTO(Schnupperer shcnupperer);
	
	List<SchnuppererDTO> toListDTO(List<Schnupperer> schnupperer);
	
	Schnupperer toEntity(SchnuppererDTO schnupperer);
}