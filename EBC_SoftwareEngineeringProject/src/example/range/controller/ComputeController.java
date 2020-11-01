package example.range.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import example.range.model.Model;
import example.range.view.App;

public class ComputeController {

	App app;
	Model model;

	public ComputeController(App app, Model m) {
		this.app = app;
		this.model = m;
	}

	public void compute() {
		String s = app.getStartDateField().getText();
		String e = app.getEndDateField().getText();

		String pattern = "MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		try {
			Date startDate = simpleDateFormat.parse(s);
			Date endDate = simpleDateFormat.parse(e);

			model.setStartDate(startDate);
			model.setEndDate(endDate);

			long delta = model.range();
			app.getNumberDays().setText("Number Days: " + delta);
		} catch (ParseException e1) {

		}
	}
}
