package com.shazam.app.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty",
                "html:target/ui-reports.html" }, features = "src/test/resources/features/ui", glue = "com.shazam.app.stepdefinitions.ui")

public class FrontendRunner {
}
