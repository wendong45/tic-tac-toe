/**
 * JavaScript that controls the game board, game logic, and ajax calls of Spring REST web services
 * @author Wendong Wang
 * @version 1 (June 2017)
 */

var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
    $scope.serverInit = function() {
    	var whoPlaysFirstGrp = document.getElementsByName("who_plays_first");
        var whoPlaysFirst = "";
    	for (var i = 0, l = whoPlaysFirstGrp.length; i < l; i++) {
            if (whoPlaysFirstGrp[i].checked) {
            	whoPlaysFirst = whoPlaysFirstGrp[i].value;
            }
        }
    	
    	$scope.message = "";
    	
       $http.get(SERVER_INIT + "?who_plays_first=" + whoPlaysFirst)
            .then(function(response) {
                $scope.board = response.data.board.squares;
                $scope.message = response.data.message;
            });
    };

    $scope.serverInit();

    $scope.selected = function(squareHtml) {
        var squareJS = $scope.getQquareById(squareHtml.item.id);
        if (!squareJS)
            return;
        if (squareJS.value){
            alert("Sorry, that square is taken! Please select another one.");
            return;
        }
        
        squareJS.value = CLIENT_MARK;

        if ($scope.checkAndDeclareWinner())
            return;

        $scope.message = "";
        setTimeout($scope.serverPlay, 300);

        setTimeout($scope.checkAndDeclareWinner, 500);
    };

    $scope.getQquareById = function(squareId) {
        for (var i = 0; i < $scope.board.length; i++) {
            for (var j = 0; j < $scope.board[i].length; j++) {
                if ($scope.board[i][j].id == squareId)
                    return $scope.board[i][j];
            }
        }
        return null;
    };

    $scope.checkAndDeclareWinner = function() {
        var winner = $scope.findWinner();
        if (winner) {
            var winMessage = (winner == CLIENT_MARK) ? "You win!" : "Server wins!";
            $scope.message = winMessage;
            if (confirm(winMessage + " New game?"))
                $scope.serverInit(); 
            return true;
        }
        
        // if no winner but the board is full
        if (!JSON.stringify($scope.board).match(/""/)) {
        	$scope.message = "It's a draw!";
        	if (confirm("It's a draw! New game?")) {
        	  $scope.serverInit(); 
        	}
        	return true;
        }

        return false;
    };

    $scope.serverPlay = function() {
        var parameter = angular.toJson($scope.board);
//        var config = {
//            headers: {
//                'Content-Type': 'application/json;charset=utf-8;',
//                'Accept': 'application/json;charset=utf-8;'
//            }
//        };
//        $http.post("rest/serverplay", parameter, config).then(
//            function(response) {
//                $scope.board = response.data.board.squares;
//            },
//            function(response) {
//                // failure callback
//            }
//        );

        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
          if (this.readyState == 4 && this.status == 200) {
        	  var responseData = JSON.parse(this.responseText);
        	  $scope.board = responseData.board.squares;
        	  $scope.message = responseData.message;
        	  $scope.$apply();
          }
        };
        xhttp.open("POST", SERVER_PLAY, false);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.setRequestHeader("Accept", "application/json");
        xhttp.send(parameter);
  
    };


    $scope.findWinner = function() {//debugger;
        //check row
        for (var i = 0; i < $scope.board.length; i++)
        	if($scope.straightThree([i,0],[i,1],[i,2]))
                return $scope.board[i][0].value;

        //check column
        for (var i = 0; i < $scope.board[0].length; i++)
        	if($scope.straightThree([0,i],[1,i],[2,i]))
                return $scope.board[0][i].value;

        //check diagonal
    	if($scope.straightThree([0,0],[1,1],[2,2]))
            return $scope.board[0][0].value;
    	if($scope.straightThree([0,2],[1,1],[2,0]))
            return $scope.board[0][2].value;

        return null;
    };

    $scope.straightThree = function(coord1, coord2, coord3) {
    	return $scope.board[coord1[0]][coord1[1]].value != ""  
    		&& $scope.board[coord1[0]][coord1[1]].value == $scope.board[coord2[0]][coord2[1]].value
    		&& $scope.board[coord1[0]][coord1[1]].value == $scope.board[coord3[0]][coord3[1]].value;
    };
});