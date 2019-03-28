package ch.ny.data;

import ch.ny.ort.Ort;

public class OrtDataGenerator implements DataGeneratable<Ort>{

	@Override
	public DataHolder<Ort> generate() {
		return DataHolder.of(
				new Ort(0L, "8192", "Stockistrasse", 51, "Glattfelden", "Z�rich"),
				new Ort(1L, "8084", "Herostrasse", 12, "Altstetten", "Z�rich"),
				new Ort(2L, "8035", "Dorfstrasse", 2, "Cu de Judas", "Z�rich")
				);
	}

}
