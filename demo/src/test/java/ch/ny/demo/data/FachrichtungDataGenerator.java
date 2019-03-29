package ch.ny.demo.data;

import ch.ny.demo.fachrichtung.Fachrichtung;

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
