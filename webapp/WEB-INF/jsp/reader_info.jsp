<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>ead>
    <title>${currentReader.name}的主页</title>
    <link rel="stylesheet" href="${APP_PATH}/static/css/bootstrap.min.css">
    <script src="${APP_PATH}/static/js/jquery-3.2.1.js"></script>
    <script src="${APP_PATH}/static/js/bootstrap.min.js" ></script>
</head>
<body background="${APP_PATH}/static/img/lizhi.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header" style="padding-bottom: 80px">
   <jsp:include page="reader_header.jsp"></jsp:include>
</div>
<c:if test="${!empty succ}">
    <div class="alert alert-success alert-dismissable">
        <button type="button" class="close" data-dismiss="alert"
                aria-hidden="true">
            &times;
        </button>
            ${succ}
    </div>
</c:if>
<c:if test="${!empty error}">
    <div class="alert alert-danger alert-dismissable">
        <button type="button" class="close" data-dismiss="alert"
                aria-hidden="true">
            &times;
        </button>
            ${error}
    </div>
</c:if>
<div class="col-xs-5 col-md-offset-3">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                我的信息
            </h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <tr>
                    <th width="20%">读者证号</th>
                    <td>${currentReader.readerId}</td>
                </tr>
                <tr>
                    <th>姓名</th>
                    <td>${currentReader.name}</td>
                </tr>
                <tr>
                    <th>性别</th>
                    <td>${currentReader.sex}</td>
                </tr>
                <tr>
                    <th>生日</th>
                    <td>${currentReader.birthStr}</td>
                </tr>
                <tr>
                    <th>地址</th>
                    <td>${currentReader.address}</td>
                </tr>
                <tr>
                    <th>电话</th>
                    <td>${currentReader.phone}</td>
                </tr>
            </table>
                    <a class="btn btn-success btn-xx" href="${APP_PATH}/reader/readerEditSelf?readerId=${currentReader.readerId}" role="button">修改</a>
        </div>
    </div>
</div>
</body>
</html>