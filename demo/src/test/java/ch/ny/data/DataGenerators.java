package ch.ny.data;

import ch.ny.demo.berufsbildner.Berufsbildner;
import ch.ny.demo.fachrichtung.Fachrichtung;
import ch.ny.demo.ort.Ort;
import ch.ny.demo.schnupperer.Schnupperer;
import ch.ny.demo.schnuppertag.Schnuppertag;

public class DataGenerators {
	
	public static <T> DataGeneratable<T> forClass(Class<T> clazz) {
		return new DataGenerators().build(clazz);
	}
	
	@SuppressWarnings("unchecked")
	public <T> DataGeneratable<T> build(Class<T> clazz) {
		DataGeneratable<?> gen = null;
		
		if(Fachrichtung.class.isAssignableFrom(clazz)) {
			gen = fachrichtungGen();
		} else if(Schnupperer.class.isAssignableFrom(clazz)) {
			gen = schnuppererGen();
		} else if(Schnuppertag.class.isAssignableFrom(clazz)) {
			gen = schnuppertagGen();
		} else if(Ort.class.isAssignableFrom(clazz)) {
			gen = ortGen();
		} else if(Berufsbildner.class.isAssignableFrom(clazz)) {
			gen = berufsbildnerGen();
		} else {
			throw new RuntimeException();
		}
		
		return (DataGeneratable<T>) gen;
	}
	
	private FachrichtungDataGenerator fachrichtungGen() {
		return new FachrichtungDataGenerator();
	}
	
	private OrtDataGenerator ortGen() {
		return new OrtDataGenerator();
	}
	
	private SchnuppererDataGenerator schnuppererGen() {
		return new SchnuppererDataGenerator(ortGen());
	}
	
	private BerufsbildnerDataGenerator berufsbildnerGen() {
		return new BerufsbildnerDataGenerator();
	}
	
	private SchnuppertagDataGenerator schnuppertagGen() {
		return new SchnuppertagDataGenerator(ortGen(),  schnuppererGen(), berufsbildnerGen(), fachrichtungGen());
	}
}
