package ch.ny.demo.schnuppertag;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SchnuppertagMapper {

	SchnuppertagDTO toDTO(Schnuppertag schnuppertag);
	
	List<SchnuppertagDTO> toListDTO(List<Schnuppertag> schnuppertage);
	
	Schnuppertag toEntity(SchnuppertagDTO schnuppertag);
}