package ch.ny.data;

import ch.ny.fachrichtung.Fachrichtung;

public class FachrichtungDataGenerator implements DataGeneratable<Fachrichtung>{

	@Override
	public DataHolder<Fachrichtung> generate() {
		return DataHolder.of(
				new Fachrichtung(0L, "Informatiker"),
				new Fachrichtung(1L, "KV"),
				new Fachrichtung(2L, "Mechaniker")
				);
	}

}
