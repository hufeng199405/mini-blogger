<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>mini-blogger登录界面</title>

    <link rel="stylesheet" href="${request.contextPath}/static/css/css.css">
    <link rel="stylesheet" href="${request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/static/css/style.css">
    <!--表单校验css-->
    <link rel="stylesheet" href="${request.contextPath}/static/css/bootstrapValidator.css">
</head>

<body class="style-2">
<div class="container">
    <div class="row">
        <div class="col-md-12 text-center">
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <form action="${request.contextPath}/loginController/login" class="fh5co-form animate-box" method="post" data-animate-effect="fadeIn" id="loginForm">
                <h2 class="text-center">登录界面</h2>
                <div class="form-group">
                    <label for="username" class="sr-only">用户名</label>
                    <input type="text" class="form-control" id="username" name="loginName" placeholder="用户名/手机号码/邮箱" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">密码</label>
                    <input type="password" class="form-control" id="password" name="loginPassword" placeholder="密码" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="checkCode" class="sr-only">验证码</label>
                    <input type="text" maxlength="4" class="form-control" style="width: 45%;display:inline" id="checkCode" name="checkCode" placeholder="验证码" autocomplete="off">
                    <img src="${request.contextPath}/CheckImgServlet" id="checkCodeImage" onclick="this.src='${request.contextPath}/CheckImgServlet?'+(new Date()).getTime();"/>
                </div>
                <div class="form-group">
                    <label for="remember"><input type="checkbox" id="remember">记住密码</label>
                </div>
                <div class="form-group">
                    <p>没有账号，请注册? <a href="sign-up.html">注册</a> | <a href="forgot.html">忘记密码?</a>
                    </p>
                </div>
                <div class="form-group">
                    <input type="submit" value="登录" class="btn btn-primary form-control">
                </div>
            </form>
        </div>
    </div>
    <div class="row hidden">
        <div class="col-md-4 col-md-offset-4">
            <form action="#" class="fh5co-form animate-box" data-animate-effect="fadeIn" id="registerForm">
                <h2 class="text-center">注册界面</h2>
                <div class="form-group">
                    <label for="username" class="sr-only">用户名</label>
                    <input type="text" class="form-control" name="username" placeholder="用户名" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">密码</label>
                    <input type="password" class="form-control" name="registerPassword" placeholder="密码" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">确认密码</label>
                    <input type="password" class="form-control" name="againPassword" placeholder="确认密码" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="checkCode" class="sr-only">邮箱</label>
                    <input type="text" class="form-control" name="email" placeholder="邮箱" autocomplete="off">
                </div>
                <div class="form-group">
                    <p>已有账号，请登录? <a href="sign-up.html">登录</a> | <a href="forgot.html">忘记密码?</a>
                    </p>
                </div>
                <div class="form-group">
                    <input type="submit" value="注册" class="btn btn-primary form-control">
                </div>
            </form>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="${request.contextPath}/static/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${request.contextPath}/static/js/bootstrap.min.js"></script>
<!--表单校验js-->
<script src="${request.contextPath}/static/js/bootstrapValidator.js"></script>
<!--登录js校验-->
<script src="${request.contextPath}/static/js/login.js"></script>
</body>
</html>