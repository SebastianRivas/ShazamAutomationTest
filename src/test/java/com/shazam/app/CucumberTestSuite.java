package com.shazam.app;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty",
                "html:target/cucumber-reports.html" }, features = "src/test/resources/features", glue = "com.shazam.app.stepdefinitions")

public class CucumberTestSuite {
}
