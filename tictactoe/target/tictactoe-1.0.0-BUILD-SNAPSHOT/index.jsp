<!doctype html>
<!-- 
/**
 * Tic Tac Toe home web page
 * @author Wendong Wang
 * @version 1 (June 2017)
 */
-->
<%@ page import="com.wwd.tictactoe.Constants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Tic Tac Toe</title>
  <meta name="viewport" content="width=400px" />
  <link rel="stylesheet" href="resources/css/main.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>  
</head>
<body onload="">  
<div ng-app="myApp" ng-controller="myCtrl" ng-init=''> 

<div>Tic-Tac-Toe Game</div>
<div id="players">
  <div class="">Who plays first?</div> 
  <input type="radio" name="who_plays_first" value="X">
  <div id="" class="">Player X (You)</div>
  <input type="radio" name="who_plays_first" value="O">
  <div id="" class="">Player O (Server)</div>
</div>
<div><input type="button" class="" value="New Game" ng-click="serverInit()"></div><br>


<table>
  <tr ng-repeat="row in board">
    <td ng-repeat="item in row" id="{{item.id}}" ng-click="selected(this)">{{item.value}}</td>
  </tr>
</table>

<div style="color:red;">{{message}}</div>

<script type="text/javascript">
SERVER_PLAY="<%= Constants.SERVER_PLAY %>"; 
SERVER_INIT="<%= Constants.SERVER_INIT %>"; 
SERVER_MARK="<%= Constants.SERVER_MARK %>"; 
CLIENT_MARK="<%= Constants.CLIENT_MARK %>";
</script>
<script src="resources/js/frontController.js" type="text/javascript"></script> 

</div>


</body>
</html>