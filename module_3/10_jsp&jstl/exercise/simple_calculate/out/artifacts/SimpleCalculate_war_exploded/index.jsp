<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/26/2021
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
      <style>
          form{
              width: 400px;
          }
          select{
              margin-bottom: 15px;
          }
      </style>
  </head>
  <body>
      <div class="calculator">
        <h2>Simple Calculator</h2>
          <form method="get" action="/Calculator">
              <table width="40%">
                  <fieldset>
                      <legend>Calculator</legend>
                      <label>First operand:</label>
                      <input type="text" name="fistNumber"><br><br>
                      <label>Operator:</label>
                      <select name="operator" id="">
                          <option value="+">Addition</option>
                          <option value="-">Subtraction</option>
                          <option value="*">Multiplication</option>
                          <option value="/">Division</option>
                      </select>
                      <br>
                      <label>Second operand:</label>
                      <input type="text" name="secondNumber"><br><br>
                      <input type="submit" value="Submit">
                  </fieldset>
              </table>
          </form>
      </div>
  </body>
</html>
