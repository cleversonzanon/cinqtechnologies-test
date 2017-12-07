## Run Instructions
* On **eclipse**:
    Create a maven build with the arguments "spring-boot:run"
* On **IntelliJ IDEA**:
    Run the Application.java file
* Through **command line**:
    Navigate to the project's folder and run the command "mvn spring-boot:run"

After this, all we need to do is entera valid address on the browser, such as *http://localhost:8090/rest/cities* or *http://localhost:8090/rest/cities?country=Uni*.

## Database Changes
In order to load the data from a CSV file, the H2 script only creates the tables. Although, for unit testing, the *db_init_test.h2.sql* still populates the tables.

## Code Testing
Besides the **unit test** that already existed, **integration tests** were created. In order to run these two type of tests separately , the plugin **failsafe** was used, so that only the unit tests run every time with the application and the integration tests run separately when necessary.

Regarding code coverage, on IntelliJ IDEA the coverage presented was 100% of the classes, 92% of the methods and 87% of the lines.

![Intellij IDEA Coverage](coverage/intellij.png "Intellij IDEA Coverage")

On eclipse the coverage presented was 60.6%, and that is due the Entity and Configuration classes, which IntelliJ does not count on code coverage. All the classes that contains business logic and can be tested had
a percentage not lower than 86.4.

![Eclipse Coverage](coverage/eclipse.png "Eclipse Coverage")