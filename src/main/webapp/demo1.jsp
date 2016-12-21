<%--
  Created by IntelliJ IDEA.
  User: Влад
  Date: 19.12.2016
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo1</title>
</head>
<body>
Demo1
<br/><br/>
Program workflow came here like this:
<ul>
    <li>
        1) Request came to a socket of a server where a web-server is listening an incoming requests.
    </li>
    <li>
        2) Web-server sends this request(url) to a web-container.
    </li>
    <li>
        3) Web-container parses it and redirects to a dispatcher servlet.
    </li>
    <li>
        4) Dispatcher servlet defines which controller is to process this request and redirects(deligates)
        it to this controller.
    </li>
    <li>
        5) Controller performs some processing of a request and creates a respond.
    </li>
    <li>
        6) This respond is sent to a user's browser by web-server.
    </li>
    <li>
        7) User receives a web-page.
    </li>
</ul>
</body>
</html>
