package ch.ny.data;

import ch.ny.demo.schnupperer.Schnupperer;

public class SchnuppererDataGenerator implements DataGeneratable<Schnupperer>{

	private OrtDataGenerator ortGenerator;
	
	public SchnuppererDataGenerator(OrtDataGenerator ortGenerator) {
		this.ortGenerator = ortGenerator;
	}
	
	@Override
	public DataHolder<Schnupperer> generate() {
		var orte = ortGenerator.generate();
		
		return DataHolder.of(
				new Schnupperer(0L, "Sofia", "Simoes", "sofia.simoes@test.test", "078 954 44 55", orte.first()),
				new Schnupperer(1L, "Miguel", "Grade", "miguel.grade@test.test", "075 945 66 44", orte.second()),
				new Schnupperer(2L, "Gomes", "Lohse", "gomes.lohse@test.test", "079 152 48 65", orte.third())
				);
	}

}
