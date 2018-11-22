<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>springmvc</title>
</head>
<body>
<h2>早期SpringMVC+Spring+mybatis 架构</h2>
<div>
    <h4>人员列表</h4>
    <table>
        <thead>
            <td>姓名</td>
            <td>用户名</td>
            <td>密码</td>
            <td>性别</td>
            <td>出生日期</td>
        </thead>
        <tbody>
            <c:forEach items="${userlist}"  var="item" step="1" varStatus="userStatus" >
                <tr>
                    <td>${item.name}</td>
                    <td>${item.username}</td>
                    <td>${item.password}</td>
                    <td>${item.gander}</td>
                    <td>${item.birthday}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>