package ch.ny.berufsbildner;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

//mappe von DTO <-> enität
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BerufsbildnerMapper {

	BerufsbildnerDTO toDTO(Berufsbildner berufsbildner);
	
	List<BerufsbildnerDTO> toListDTO(List<Berufsbildner> fachrichtungen);
	
	Berufsbildner toEntity(BerufsbildnerDTO fachrichtung);
}
