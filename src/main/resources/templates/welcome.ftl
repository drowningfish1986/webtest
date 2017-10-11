<!DOCTYPE html>
<html>
<script type="text/javascript" src="/static/javascript/jquery-1.8.3.min.js"></script>
<script>
    var ctx = $("#ctx").val();
</script>
<body>
    <h3>Hello,${name}.欢迎阅读《${bookTitle}》</h3>

    <form id="login" action="${ctx}/hello/login" method="post">
        <input type="hidden" id="ctx" value="${ctx}">
        <input type="text" id="userName" name="userName" placeholder="请输入用户名"><br>
        <input type="password" id="password" name="password" placeholder="请输入密码"><br>
        <span id="tip" style="color: red">${tip}</span>
        <input type="submit">
    </form>
</body>
</html>