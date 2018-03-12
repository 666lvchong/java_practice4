<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/1/30
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="/Team4/css/en_roll.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="all">
    <div class="most" >
        <form action="peopleInfoAction!addPeople.do" method="post">
            <table align="center" width="900px">
            <caption class="user">用户注册</caption>
                <tr>
                    <td class="birthdate" align="center">姓名</td>
                    <td><input type="text" name="peopleInfo.name" size="20"/></td>
                    <td class="birthdate" align="center">性别</td>
                    <td><input type="text" name="peopleInfo.sex" value=""/></td>
                </tr>
                <tr>
                    <td class="birthdate" align="center">年龄</td>
                    <td><input type="text" name="peopleInfo.age" value=""/></td>
                    <td class="birthdate" align="center">民族</td>
                    <td><input type="text" name="peopleInfo.nation" value=""/></td>
                </tr>
                <tr>
                    <td class="birthdate" align="center">出生日期</td>
                    <td><input type="text" name="peopleInfo.birthdate" value=""/></td>
                    <td class="birthdate" align="center">身份证号</td>
                    <td><input type="text" name="peopleInfo.idNumber" value=""/></td>
                </tr>
                 <tr>
                    <td class="birthdate" align="center">手机号</td>
                    <td><input type="text" name="peopleInfo.mobilePhone" value=""/></td>
                    <td class="birthdate" align="center">籍贯</td>
                    <td><input type="text" name="peopleInfo.nativePlace" value=""/></td>
                </tr>
                <tr>
                    <td class="birthdate" align="center">邮箱</td>
                    <td><input type="text" name="peopleInfo.mailBox" value="" /></td>
                    <td class="birthdate" align="center">常住地址</td>
                    <td><input type="text" name="peopleInfo.permanentAdress" value=""/></td>
                </tr>
                <tr>
                    <td class="birthdate" align="center">职业</td>
                    <td><input type="text" name="peopleInfo.profession" value=""/></td>
                    <td class="birthdate" align="center">工作单位</td>
                    <td><input type="text" name="peopleInfo.workUnit" value=""/></td>
                </tr>
                <tr>
                    <td class="birthdate" align="center">淘宝账户</td>
                    <td><input type="text" name="taobaoAccount.personnelAccount" value=""/></td>
                    <td class="birthdate" align="center">密码</td>
                    <td><input type="password" name="taobaoAccount.password" value=""/></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="center" >
                    <input type="submit"  value="注册" class="roll">
                    </td>
                    <td align="center">
                      <input type="reset" value="重置" class="reset">
                    </td>
                    <td></td>
                </tr>
            </table>
        </form>
    </div>
</div>



</body>
</html>
