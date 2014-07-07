package br.vanat.trainning;

import lombok.Data;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@Data
public abstract class CharacterTest {
	@Rule public ExpectedException thrown= ExpectedException.none();
	
	@Before
    public abstract void setUp();
	
	@Test
	public abstract void fight() throws Exception;
	
	@Test
	public abstract void die() throws Exception;
}
