package example.range.model;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class TestModel {

	@Test
	public void testRange() {
		Model m = new Model();
		Date d1 = new Date(2019, 1, 13);
		Date d2 = new Date(2019, 1, 15);
		m.setStartDate(d1);
		m.setEndDate(d2);

		long diff = m.range();

		assertEquals (2, diff);
	}
}
