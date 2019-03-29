package ch.ny.demo.data;

import ch.ny.demo.berufsbildner.Berufsbildner;

public class BerufsbildnerDataGenerator implements DataGeneratable<Berufsbildner>{

	@Override
	public DataHolder<Berufsbildner> generate() {
		return DataHolder.of(
				new Berufsbildner(0L, "Markus", "Meier"),
				new Berufsbildner(1L, "Joel", "Mueller"),
				new Berufsbildner(2L, "Nuno", "Cheap")
				);
	}

}
