package com.faceBBook.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\2RIN\\eclipse-workspace\\Cucumber_Framework\\src\\test\\resources",
				glue="com.bookMyShow",
				dryRun=false,
				monochrome=true,
				plugin= {"html:target//html","json:target/report.json"},
				strict=false)
public class TestRunner {
	

}
