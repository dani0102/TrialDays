package ch.ny.demo.fachrichtung;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FachrichtungMapper {

	FachrichtungDTO toDTO(Fachrichtung fachrichtung);
	
	List<FachrichtungDTO> toListDTO(List<Fachrichtung> fachrichtungen);
	
	Fachrichtung toEntity(FachrichtungDTO fachrichtung);
}
