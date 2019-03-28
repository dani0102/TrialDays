package ch.ny.data;

import ch.ny.demo.ort.Ort;

public class OrtDataGenerator implements DataGeneratable<Ort>{

	@Override
	public DataHolder<Ort> generate() {
		return DataHolder.of(
				new Ort(0L, "8192", "Stockistrasse", 51, "Glattfelden", "Zuerich"),
				new Ort(1L, "8084", "Herostrasse", 12, "Altstetten", "Zuerich"),
				new Ort(2L, "8035", "Dorfstrasse", 2, "Cu de Judas", "Zuerich")
				);
	}

}
