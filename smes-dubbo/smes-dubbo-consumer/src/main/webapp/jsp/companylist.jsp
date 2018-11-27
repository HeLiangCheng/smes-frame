<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mongodb-company-list</title>
</head>
<body>
<h2>读取mongodb 数据库的数据</h2>
<div>
    <h4>公司列表</h4>
    <table>
        <thead>
        <td>id</td>
        <td>公司名称</td>
        <td>地址</td>
        <td>电话</td>
        <td>员工数量</td>
        </thead>
        <tbody>
        <c:forEach items="${companyList}"  var="item" step="1" varStatus="status" >
            <tr>
                <td>${item.id}</td>
                <td>${item.companyName}</td>
                <td>${item.address}</td>
                <td>${item.telphone}</td>
                <td>${item.staffnum}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>