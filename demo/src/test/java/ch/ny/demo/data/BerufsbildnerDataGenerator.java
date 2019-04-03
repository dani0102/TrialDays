package ch.ny.demo.data;

import ch.ny.demo.berufsbildner.Berufsbildner;

public class BerufsbildnerDataGenerator implements DataGeneratable<Berufsbildner>{

	@Override
	public DataHolder<Berufsbildner> generate() {
		return DataHolder.of(
				new Berufsbildner(0L, "Markus", "Meier", "meiermarkus", "not_my_password"),
				new Berufsbildner(1L, "Joel", "Mueller", "TheLegend27", "ksi>gsi"),
				new Berufsbildner(2L, "Nuno", "Cheap", "xXx", "20010901")
				);
	}

}
