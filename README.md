README
This is a repo with T-Systems Java School preliminary examination tasks. Code points where you solution is to be located are marked with TODOs.

The solution is to be written using Java 1.8 only, external libraries are forbidden. You can add dependencies with scope "test" if it's needed to write new unit-tests.

The exam includes 3 tasks to be done: Calculator, Pyramid, and Subsequence

Result
Author name : {Antonov Aleksandr Aleksadnrovich}
Codeship : {[![Codeship Status for AntonovAleksandr/TSystemsSchool](https://app.codeship.com/projects/daee7d10-c30a-0137-3eb9-765ddbbaedf9/status?branch=master)](https://app.codeship.com/projects/366484)}
Example of Codeship badge. Please remove the example before you send us the link.  Codeship Status for tschool/javaschoolexam

How to start?
Install GIT and Maven
Fork the repository
You're ready to go!
How can I submit the result?
Make sure your code can be built and all tests are green (example command: "mvn clean install")
Commit and push all changes to your repository
Configure the build on CI server like Codeship
Add build badge and your name to the README.md under Result section
Check that the badge shows green build. We will not accept your solution if there is any red badge on the page.
Send us an email with the link to your repository. Be aware that the build must be green all the time after you send us the link
Test fails but I'm sure my solution is correct. What to do?
First of all - don't modify the tests. It will be considered as fraud and treated accordingly
Send us an email with full details:
Link to your repository
Name of failing test
Explain what is expected behaviour from your point of view
Explain why do you think your version is correct
Wait for the response
Tips and tricks for Codeship CI
Codeship uses Java 7 by default. Please refer to this article to set up Java 8
jdk_switcher is to be used in "Setup Commands" of project configuration
Test command is "mvn -B test"
Markdown code to add badge to your README is located in Project Settings -> Notification -> Status images
Who do I talk to?
In case of any questions contact the person who sent you the task (first) or HR department of T-Systems RU (second).
Useful links
Learn Markdown
Codeship
