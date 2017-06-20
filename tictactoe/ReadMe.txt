### TicTacToe with AngularJS and Spring REST ###
 
===========================================================================
DESCRIPTION:
 
This sample uses HTML5, AngularJS, and Spring REST to implement a tic-tac-toe game
===========================================================================
BUILD REQUIREMENTS:

JAVA 7 and later 
Maven 1.3 and later
 
===========================================================================
RUNTIME REQUIREMENTS:
 
Tomcat 7 and later
Chrome version 49 and later (!!!tested only on Chrome!!!)
 
===========================================================================
PACKAGING LIST:
pom.xml - build file for Moven
index.jsp - Tic Tac Toe home web page
frontcontroller.js - JavaScript that controls the game board, game logic, and ajax calls of Spring REST web services
main.css - Basic styles for the page.
servelet-context.xml - Spring configuration
TictactoeController.java - Server side controller
TictactoeServiceImp.java - Server side service program
Board.java - Game board model
Square.java - Board Square model
ResponseData.java - JSON data object model for data passing with web request/response
Constants.java - App constants

JavaDoc generated documents in Doc directory.
===========================================================================
CHANGES TO BE MADE LATER:
 
1. Fix angular rendering issue - no immediate update on screen when a binding value is changed, i.e., the last clicking is not marked before win is declared.
2. Add server playing strategies (AI) to simulate levels as beginner, experienced, and expert players.
3. Test and make this sample work on other browsers except for Chrome.
4. Extend board size beyond 3x3.
5. Build docker images to scale out in high volume.
6. Add new features, e.g., use local storage to save state for revisits, record playing history, add complexity options. 
 
===========================================================================
Copyright (C) 2017 Wendong Wang.