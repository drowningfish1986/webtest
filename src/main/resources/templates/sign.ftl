<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>签名页</title>
</head>
<script src="/static/javascript/jquery-1.8.3.min.js"></script>
<script>
    function ss() {
        document.getElementsByTagName("form")[0].submit();
    }
    function ll() {
        document.getElementsByTagName("form")[1].submit();
    }
    function submit3() {
        document.getElementsByTagName("form")[2].submit();
    }
</script>
<body>
<h1 th:inline="text">签名</h1>
    <h3>普通接口签名（提交后返回urlParam）</h3>
    <form id="usualSign" action="${address}/sign/usual" method="post">
        <table border="1">
            <tr>
                <td>商户识别号appKey：</td>
                <td><input type="text" id="appKey1" name="appKey1" placeholder="请输入商户识别码"
                           style="width: 200px" /></td>
            </tr>
            <tr>
                <td>版本号：</td>
                <td><input type="text" name="version1" value="1.0.0"></td>
            </tr>
            <tr>
                <td>密钥：</td>
                <td><input type="text" value="YjY1Y2NkNTA5MmU0MTFlN2FiYzRjZWMyNzhiNmI1MGE=" disabled="disabled"/>
                    <input type="hidden" name="secure1" value="YjY1Y2NkNTA5MmU0MTFlN2FiYzRjZWMyNzhiNmI1MGE=" /></td>
            </tr>
            <tr>
                <td>时间戳：</td>
                <td><input type="text" id="timestamp1" name="timestamp1" placeholder="请输入时间戳" style="width: 200px" /></td>
            </tr>
            <tr>
                <td>json数据：</td>
                <td><input type="text" id="jsonData" name="jsonData" placeholder="请输入jsonData"
                           style="height: 100px;width: 200px" /></td>
            </tr>
            <tr>
                <td colspan="2"><button id="button1" onclick="ss();">普通接口签名提交</button></td>
            </tr>
        </table>
    </form>
    <h3>表单接口签名（提交后跳转账户验证）</h3>
    <form id="formSign" action="${address}/sign/form" method="post">
        <table border="1">
            <tr>
                <td>商户识别号appKey：</td>
                <td><input type="text" id="appKey" name="appKey" placeholder="请输入商户识别码"
                           style="width: 200px"/></td>
            </tr>
            <tr>
                <td>版本号：</td>
                <td><input type="text" name="version" value="1.0.0"></td>
            </tr>
            <tr>
                <td>密钥：</td>
                <td><input type="text" value="YjY1Y2NkNTA5MmU0MTFlN2FiYzRjZWMyNzhiNmI1MGE=" disabled="disabled"/>
                    <input type="hidden" name="secure" value="YjY1Y2NkNTA5MmU0MTFlN2FiYzRjZWMyNzhiNmI1MGE=" /></td>
            </tr>
            <tr>
                <td>时间戳：</td>
                <td><input type="text" id="timestamp" name="timestamp" placeholder="请输入时间戳" style="width: 200px" /></td>
            </tr>
            <tr>
                <td>userId：</td>
                <td><input type="text" id="userId" name="userId" placeholder="请输入userId" style="width: 200px"/></td>
            </tr>
            <tr>
                <td>redirectUrl：</td>
                <td><input type="text" id="redirectUrlAcct" name="redirectUrlAcct" placeholder="请输入redirectUrl" style="width: 200px"/></td>
            </tr>
            <tr>
                <td>客户类型：</td>
                <td>
                    <input type="radio" name="type" value="0">个人&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="type" value="1" checked="checked">企业<br>
                </td>
            </tr>
            <tr>
                <td colspan="2"><button id="button2" onclick="ll();">表单接口签名页面跳转</button></td>
            </tr>
        </table>
    </form>
    <h3>表单接口签名（提交后跳转企业提现）</h3>
    <form id="formSign" action="${address}/sign/withdraw" method="post">
        <table border="1">
            <tr>
                <td>商户识别号appKey：</td>
                <td><input type="text" id="appKey" name="appKey" placeholder="请输入商户识别码"
                           style="width: 200px"/></td>
            </tr>
            <tr>
                <td>版本号：</td>
                <td><input type="text" name="version" value="2.0.0"></td>
            </tr>
            <tr>
                <td>密钥：</td>
                <td><input type="text" value="YjY1Y2NkNTA5MmU0MTFlN2FiYzRjZWMyNzhiNmI1MGE=" disabled="disabled"/>
                    <input type="hidden" name="secure" value="YjY1Y2NkNTA5MmU0MTFlN2FiYzRjZWMyNzhiNmI1MGE=" /></td>
            </tr>
            <tr>
                <td>时间戳：</td>
                <td><input type="text" id="timestamp" name="timestamp" placeholder="请输入时间戳" style="width: 200px" /></td>
            </tr>
            <tr>
                <td>userId：</td>
                <td><input type="text" id="userId3" name="userId3" placeholder="请输入userId" style="width: 200px"/></td>
            </tr>
            <tr>
                <td>redirect：</td>
                <td><input type="text" id="redirect" name="redirect" placeholder="请输入redirect" style="width: 200px"/></td>
            </tr>
            <tr>
                <td>orderNo：</td>
                <td><input type="text" id="orderNo" name="orderNo" placeholder="请输入orderNo" style="width: 200px"/></td>
            </tr>
            <tr>
                <td>客户类型：</td>
                <td>
                    <input type="radio" name="type" value="0">个人&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="type" value="1" checked="checked">企业<br>
                </td>
            </tr>
            <tr>
                <td colspan="2"><button id="button2" onclick="ll();">提现页面跳转</button></td>
            </tr>
        </table>
    </form>
    <h3>表单接口签名2（提交后跳转密码修改）</h3>
    <form id="formSign" action="${address}/password/change" method="post">
        <table border="1">
            <tr>
                <td>商户识别号appKey：</td>
                <td><input type="text" id="appKey" name="appKey" placeholder="请输入商户识别码"
                           style="width: 200px"/></td>
            </tr>
            <tr>
                <td>版本号：</td>
                <td><input type="text" name="version" value="2.0.0"></td>
            </tr>
            <tr>
                <td>密钥：</td>
                <td><input type="text" value="YjY1Y2NkNTA5MmU0MTFlN2FiYzRjZWMyNzhiNmI1MGE=" disabled="disabled"/>
                    <input type="hidden" name="secure" value="YjY1Y2NkNTA5MmU0MTFlN2FiYzRjZWMyNzhiNmI1MGE=" /></td>
            </tr>
            <tr>
                <td>时间戳：</td>
                <td><input type="text" id="timestamp" name="timestamp" placeholder="请输入时间戳" style="width: 200px" /></td>
            </tr>
            <tr>
                <td>userId：</td>
                <td><input type="text" id="userId4" name="userId4" placeholder="请输入userId" style="width: 200px"/></td>
            </tr>
            <tr>
                <td>redirect：</td>
                <td><input type="text" id="redirect4" name="redirect4" placeholder="请输入redirect" style="width: 200px"/></td>
            </tr>
            <tr>
                <td colspan="2"><button id="button3" onclick="submit3();">修改密码页面跳转</button></td>
            </tr>
        </table>
    </form>
</body>
</html>