### TicTacToe with AngularJS and Spring REST ###
 
===========================================================================
DESCRIPTION:
 
This sample uses HTML5, AngularJS, and Spring REST to implement a tic-tac-toe game
===========================================================================
BUILD REQUIREMENTS:

JAVA 7 or later 
Maven 1.3 or later
 
===========================================================================
RUNTIME REQUIREMENTS:
 
Tomcat 7 or later
Chrome version 49 or later (!!Have tested only on Chrome!!)
 
===========================================================================
PACKAGING LIST:
pom.xml - Moven build file
index.jsp - Tic-Tac-Toe home page
frontcontroller.js - JavaScript front-end controller for game board display, game logic, and invocation to web services
main.css - Basic styles for the page.
servelet-context.xml - Spring configuration
TictactoeController.java - Server side controller
TictactoeServiceImp.java - Server side service program
Board.java - Game board model (n x n squares)
Square.java - Model of Square (an unit of game board)
ResponseData.java - JSON data object model for data exchange between server and client
Constants.java - Central constants reservoir

JavaDoc generated documents in Doc directory.
===========================================================================
CHANGES TO BE MADE LATER:
 
1. Fix angular rendering issue - no immediate update on screen when a binding value is changed, i.e., the last clicking is not marked before win is declared.
2. Add server playing strategies (AI) to simulate levels as beginner, experienced, and expert players.
3. Test and make this sample work on other browsers except Chrome.
4. Extend board size beyond 3x3.
5. Build docker images to scale out in high volume.
6. Add new features, e.g., use local storage to save state for revisits, record playing history, add complexity options. 
 
===========================================================================
Copyright (C) 2017 Wendong Wang.
