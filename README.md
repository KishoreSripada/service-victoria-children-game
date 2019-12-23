# service-victoria-children-game
Children game

Please follow the below instructions to test the application

1) Start the server by either of the below methods

   a) Run the java class -> ChildrenGameApplication.java (This will start the tomcat server on port 7789)

   b) Run maven install to generate the jar in target directory

      Execute the command to start the server on port 7789

      java -jar target/ChildrenGame-1.0.jar
      
3) Open Postman and try to execute the below -

a) Health Check to check if server has started properly

GET -> http://localhost:7789/healthCheck

Output -  

Status Code - 200

Children Game Endpoint is up and running ! Enjoy the game

b) Game Endpoint with default inputs (Invoke endpoint without any query parameters)

Endpoint will consider noOfChildren = 5 , counter = 6 if no parameters are passed for default behaviour
GET -> http://localhost:7789/game

Status Code - 200

4

b) Game Endpoint with different inputs
GET -> http://localhost:7789/game?noOfChildren=14&counter=2

Status Code - 200

13

Unit Tests - 

The unit test coverage is 100% (Except for the main application class, where there is no logic for endpoint)

TODO - 
1) Extensive Exception Handling

2) Test cases to cover the exception handling scenarios

Time Complexity - 

There are two loops (Main loop for noOfChildren and the internal loop is to loop until we find the counter)

Hence the time complexity for this program would be O(m*n) where m -> noOfChildren and n-> counter(when the child is removed)