package example.range.model;

import java.util.Date;

public class Model {
	Date start;
	Date end;

	public Model () { }

	public long range() {
		long millis = end.getTime() - start.getTime();
		long secs = millis / 1000;
		long mins = secs / 60;
		long hours = mins / 60;
		long days = hours / 24;
		return days;
	}

	public void setStartDate(Date startDate) { this.start = startDate; }
	public void setEndDate(Date endDate) { this.end = endDate; }

}
