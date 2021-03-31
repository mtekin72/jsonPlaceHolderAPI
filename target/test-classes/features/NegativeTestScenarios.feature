@Smoke
Feature: Check given title with invalid parameters

Scenario: Searching posts by title
Given send get request with parameter "baseURL" and "/posts"
When I search with the "Sincere@april.biz" as a title
Then The "title" should not not contains the given parameter