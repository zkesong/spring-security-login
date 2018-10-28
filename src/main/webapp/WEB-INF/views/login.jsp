<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<h2>您好，使用本平台请先登录！</h2>
<form method="post" action="/login">
    <div>
        用户名：<input type="text" name="username">
        密码：<input type="password" name="password">
        <input type="submit" value="登录" name="submit">
    </div>
</form>
</body>
</html>
