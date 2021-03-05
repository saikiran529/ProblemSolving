Feature: Problem solving Balance feature

Background:
Given user is on exercise page
When value Labels and value text fields are displayed

Scenario: Exercise page with right count of values 
Then right count of field values should appear on the screen

Scenario: Values should be greater than zero
Then value should exist in the value text boxes 
And count of each text box value should be greater than zero

Scenario: Total balance is correct based on listed values
Then value should exist in total Balance text box 
Then total balance should be correct as per listed values

Scenario: Values are in dollar currency format
Then all the values listed on the screen must be in dollar currency format

Scenario: Total balance equals to sum of values
Then Sum of all the values listed on the screen must be equal to Total balance