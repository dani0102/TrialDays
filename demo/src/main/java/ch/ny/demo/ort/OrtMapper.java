package ch.ny.demo.ort;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrtMapper {

	OrtDTO toDTO(Ort ort);
	
	List<OrtDTO> toListDTO(List<Ort> ort);
	
	Ort toEntity(OrtDTO ort);
}
