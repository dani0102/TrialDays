package ch.ny.data;

import java.util.Date;
import java.util.HashSet;

import ch.ny.demo.schnupperer.Schnupperer;
import ch.ny.demo.schnuppertag.Schnuppertag;

public class SchnuppertagDataGenerator implements DataGeneratable<Schnuppertag>{

	private OrtDataGenerator ortGenerator;
	private SchnuppererDataGenerator schnuppererGenerator;
	private BerufsbildnerDataGenerator berufsbildnerGenerator;
	private FachrichtungDataGenerator fachrichtungGenerator;
	
	public SchnuppertagDataGenerator(
			OrtDataGenerator ortGenerator,
			SchnuppererDataGenerator schnuppererGenerator,
			BerufsbildnerDataGenerator berufsbildnerGenerator,
			FachrichtungDataGenerator fachrichtungGenerator) {
		
		this.berufsbildnerGenerator = berufsbildnerGenerator;
		this.fachrichtungGenerator = fachrichtungGenerator;
		this.ortGenerator = ortGenerator;
		this.schnuppererGenerator = schnuppererGenerator;
	}
	
	@Override
	public DataHolder<Schnuppertag> generate() {
		var orte = ortGenerator.generate();
		var schnuppern = schnuppererGenerator.generate();
		var berufsbildnern = berufsbildnerGenerator.generate();
		var fachrichtungen = fachrichtungGenerator.generate();
		
		return DataHolder.of(
				new Schnuppertag(0L, new Date(), orte.first(), 4, new HashSet<Schnupperer>(schnuppern.asList()), berufsbildnern.first(), fachrichtungen.first()),
				new Schnuppertag(1L, new Date(), orte.second(), 10, new HashSet<Schnupperer>(schnuppern.asList()), berufsbildnern.second(), fachrichtungen.second()),
				new Schnuppertag(2L, new Date(), orte.third(), 3, new HashSet<Schnupperer>(schnuppern.asList()), berufsbildnern.third(), fachrichtungen.third())
				);
	}

}
