#Author: Dhana Lakshmi Krishna

@FunctionalTest
Feature: Google Account Login Feature
 
@First @SmokeTest @RegressionTest @End2End 
  Scenario: Google Account Login Test
  Given User is able to navigate to Google Login Page URL and verify title
  Then User enters ID
  Then User clicks on Next button
  Then User enters Password
  Then User clicks on Next button 
  Then User is on Home Page
  And Browser is closed for Login Test
  
@Second @SmokeTest @RegressionTest @End2End   
  Scenario: Google Account Forgot Email Test
  Given User is able to navigate to Google Login Page URL and verify title
  Then Click on Forgot Email link
  Then Enter Recovery Email
  Then User clicks on Next button
  Then Enter Recovery Email Details
  Then User clicks on Next button 
  And Browser is closed for Login Test

@Third @SmokeTest @RegressionTest @End2End   
  Scenario: Google Account Learn More About using Guest mode Test
  Given User is able to navigate to Google Login Page URL and verify title
  Then Verify Learn More link text 
  Then Click on Learn more about using Guest mode link
  And Browser is closed for Login Test
    
 

  