package com.shazam.app.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty",
                "html:target/api-reports.html" }, features = "src/test/resources/features/api", glue = "com.shazam.app.stepdefinitions.api")

public class BackendRunner {
}
