package com.jury.transform;

import com.jury.transform.impl.DDMMYYYYslashTransformer;
import com.jury.transform.impl.YYYYMMDDTransformer;
import com.jury.transform.impl.YYYYMMDDdashTransformer;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class DateStringTransformerTest {

	private final DateStringTransformer dateStringTransformer = new YYYYMMDDTransformer();
	private final DateStringTransformer dashDateStringTransformer = new YYYYMMDDdashTransformer();
	private final DateStringTransformer slashDateStringTransformer = new DDMMYYYYslashTransformer();
	private final LocalDate testDate = LocalDate.of(2019, 3, 25);
	private final long testTimeStampMillis = 1553589581464L;
	private final LocalDate testDate2 = DateStringTransformer.getLocalDate(new Timestamp(testTimeStampMillis));

	@Test
	public void standardConsume() {
		assertEquals("20190325", dateStringTransformer.consume(testDate));
		assertEquals("20190326", dateStringTransformer.consume(testDate2));
	}

	@Test
	public void standardProduce() {
		assertEquals(testDate.toString(), dateStringTransformer.produce("20190325").toString());
	}

	@Test
	public void dashConsume() {
		assertEquals("2019-03-25", dashDateStringTransformer.consume(testDate));
		assertEquals("2019-03-26", dashDateStringTransformer.consume(testDate2));
	}

	@Test
	public void dashProduce() {
		assertEquals(testDate.toString(), dashDateStringTransformer.produce("2019-03-25").toString());
	}

	@Test
	public void slashConsume() {
		assertEquals("25/03/2019", slashDateStringTransformer.consume(testDate));
		assertEquals("26/03/2019", slashDateStringTransformer.consume(testDate2));
	}

	@Test
	public void slashProduce() {
		assertEquals(testDate.toString(), slashDateStringTransformer.produce("25/03/2019").toString());
	}

}
