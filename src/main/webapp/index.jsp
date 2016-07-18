<%@ page contentType="text/html; charset=iso-8859-1" language="java"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring REST Demo</title>
</head>
<body>
    <h1>Simple RESTfull APP</h1>
    <h2>Host IP: <small><%= request.getLocalAddr() %></small></h2>

    <h2>Technology Used</h2>
    <ul>
        <li>Spring MVC</li>
        <li>Spring Data JPA</li>
        <li>Hibernate JPA Implementation</li>
    </ul>

    <h2>REST APIs:</h2>
    <ul>
        <li><code>GET /rest</code> Get all RestMeasure records from DB</li>
        <li><code>GET /rest/:id</code> Get specific RestMeasure record by its id</li>
        <li><code>POST /rest</code> Create a RestMeasure record with given <code>restMethod</code>, <code>restMethodName</code> parameter</li>
        <li><code>PUT /rest/:id</code> Update an existing RestMeasure record, only accept 2 fields: <code>restMethod</code>, <code>restMethodName</code></li>
        <li><code>DELETE /rest/:id</code> Delete a given RestMeasrue record</li>
    </ul>
</body>
</html>
