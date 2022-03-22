<%-- 
    Document   : outcome
    Created on : 21 Mar 2022, 20:55:51
    Author     : Thato Keith Kujwane
--%>

<%@page import="za.ac.tut.tutor.Tutor"%>
<%@page import="za.ac.tut.processor.TutorProcessor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
    </head>
    <body>
        <h1>Tutor Successfully Added!</h1>
        <%
            TutorProcessor pr = (TutorProcessor) request.getAttribute("processor");
            Tutor t = pr.getLastTutor();
        %>
        <p>
            Profile for <%=t.getName().charAt(0)%> <%=t.getSurname()%> has been created.
        </p>
        
        Click <a href="index.html">here</a> to go back to the homepage;
    </body>
</html>
