package com.banking.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features/Test.feature" },
				 glue = { "com.banking.steps", "com.banking.hooks"},
				 monochrome=true,
				 dryRun=false,
				 plugin = { "pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/" }

)
public class TestRunner {

}
