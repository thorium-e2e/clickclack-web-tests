package com.apothuaud.testng.listeners;

import org.testng.*;

import static io.restassured.RestAssured.given;

public class SlackNotifier implements ITestListener, ISuiteListener {

    public void onStart(ISuite suite) {
        given()
            .log().body()
        .with()
            .header("Content-Type", "application/json")
            .body("{\"text\": \"Début d'exécution des tests.\"}")
        .when()
            .post("https://hooks.slack.com/services/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")
        .then()
            .log().body()
        .and()
            .statusCode(200);
    }

    public void onFinish(ISuite suite) {
        given()
                .log().body()
                .with()
                .header("Content-Type", "application/json")
                .body("{\"text\": \"Fin d'exécution des tests.\"}")
                .when()
                .post("https://hooks.slack.com/services/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")
                .then()
                .log().body()
                .and()
                .statusCode(200);
    }

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {
        given()
                .log().body()
                .with()
                .header("Content-Type", "application/json")
                .body("{\"text\": \"Test FAILED:\n" + result.getTestName() + "\"}")
                .when()
                .post("https://hooks.slack.com/services/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")
                .then()
                .log().body()
                .and()
                .statusCode(200);
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
