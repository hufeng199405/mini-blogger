<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>mini-blogger登录界面</title>

    <link rel="stylesheet" href="${request.contextPath}/static/css/css.css">
    <link rel="stylesheet" href="${request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/static/css/animate.css">
    <link rel="stylesheet" href="${request.contextPath}/static/css/style.css">
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-12 text-center">
        </div>
    </div>
    <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" title="网站模板">网站模板</a></div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">

            <!-- Start Sign In Form -->
            <form action="#" class="fh5co-form animate-box" data-animate-effect="fadeIn">
                <h2>登录界面</h2>
                <div class="form-group">
                    <label for="username" class="sr-only">用户名</label>
                    <input type="text" class="form-control" id="username" placeholder="用户名" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">密码</label>
                    <input type="password" class="form-control" id="password" placeholder="密码" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="checkCode" class="sr-only">验证码</label>
                    <input type="text" maxlength="4" class="form-control" style="width: 35%;display:inline" id="checkCode" name="checkCode" placeholder="验证码" autocomplete="off">
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
            <!-- END Sign In Form -->
        </div>
    </div>
    <div class="row" style="padding-top: 60px; clear: both;">
        <div class="col-md-12 text-center">
            <p>
                <small>&copy; All Rights Reserved. More Templates <a href="http://www.cssmoban.com/" target="_blank"
                                                                     title="开源">开源</a> - Collect from <a
                        href="http://www.cssmoban.com/" title="开源模板" target="_blank">开源模板</a></small>
            </p>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="${request.contextPath}/static/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${request.contextPath}/static/js/bootstrap.min.js"></script>
<!-- Placeholder -->
<script src="${request.contextPath}/static/js/jquery.placeholder.min.js"></script>
<!-- Waypoints -->
<script src="${request.contextPath}/static/js/jquery.waypoints.min.js"></script>
<!-- Main JS -->
<script src="${request.contextPath}/static/js/main.js"></script>
</body>
</html>