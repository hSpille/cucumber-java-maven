package de.neusta.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(format = { "html:target/report.html" })
public class RunCukesIT {
}