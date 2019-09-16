<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${param.lang}">
<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Pre-calculated price</title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="/assets/css/styles3.min.css">
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
    <div class="container"><a class="navbar-brand" href="#">TruckKing</a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse"
             id="navcol-1">
            <ul class="nav navbar-nav mr-auto">
                <li class="nav-item"><a class="nav-link" href="#calculate"></a></li>
            </ul>
            <span class="navbar-text actions"> <a href="#myModal" data-toggle="modal" class="login"><fmt:message
                    key="login"/></a><a
                    class="btn btn-light action-button" role="button" href="#myModal" data-toggle="modal"
                    style="background-color: #00bce2;"><fmt:message key="register"/></a>
                </span>
            <button class="btn" type="button"
                    value="uk"
                    id="locales2"
                    style="height: 20px;background-image: url(&quot;/assets/img/ua.jpg&quot;);background-position: center;margin-right: 2px;margin-left: 15px;"></button>
            <button
                    value="en"
                    class="btn" type="button" id="locales"
                    style="height: 20px;background-image: url(&quot;/assets/img/en.jpg&quot;);background-position: center;background-size: cover;background-repeat: no-repeat;padding-right: 12px;margin: 6px;margin-top: 6px;margin-right: -27px;margin-left: 1px;"></button>
        </div>
    </div>
</nav>
<div class="register-photo">
    <div class="form-container">
        <div class="image-holder" style="background-image: url(&quot;/assets/img/TruckMountain-small.jpg&quot;);"></div>
        <form method="post">
            <h2 class="text-center"><strong>Your calculation</strong></h2>
            <div class="form-row">
                <div class="col">
                    <h1 class="text-left">${sessionScope.fromCity}</h1>
                </div>
                <div class="col">
                    <h1 class="text-right">${sessionScope.toCity}</h1>
                </div>
            </div>
            <div class="form-row">
                <div class="col">
                    <h3>Weight: <span>${sessionScope.weight}</span></h3>
                </div>
            </div>
            <div class="form-row">
                <div class="col">
                    <h2>Price: <span></span></h2>
                </div>
            </div>
            <a
                    class="btn btn-light action-button" role="button" href="#myModal" data-toggle="modal"

                    style="background-color: #00bce2;">Proceed</a>
        </form>
    </div>
</div>
<div class="modal fade" role="dialog" tabindex="-1" id="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">x</span></button>
            </div>
            <div class="modal-body">
                <div>
                    <ul class="nav nav-tabs">
                        <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" href="#tab-1">Sign in</a>
                        </li>
                        <li class="nav-item"><a class="nav-link active" role="tab" data-toggle="tab" href="#tab-2">Sign
                            up</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane" role="tabpanel" id="tab-1">
                            <p></p>
                            <form method="post" action="/api/login">
                                <div class="form-group"><i class="fa fa-lock d-lg-flex justify-content-lg-center"
                                                           style="font-size: 32px;"></i></div>
                                <div class="form-group"><input class="form-control" type="email" name="email"
                                                               placeholder="Email"></div>
                                <div class="form-group"><input class="form-control" type="password" name="pass"
                                                               placeholder="Password"></div>
                                <div class="form-group">
                                    <button class="btn btn-primary d-lg-flex ml-auto" type="submit">Submit</button>
                                </div>
                            </form>
                        </div>
                        <div class="tab-pane active" role="tabpanel" id="tab-2">
                            <p></p>
                            <form method="post" action="/api/register">
                                <div class="form-group"><i class="fa fa-key d-lg-flex justify-content-lg-center"
                                                           style="font-size: 32px;"></i></div>
                                <div class="form-group"><input class="form-control" type="text" name="name"
                                                               placeholder="Name"></div>
                                <div class="form-group"><input class="form-control" type="text" name="surname"
                                                               placeholder="Surname"></div>
                                <div class="form-group"><input class="form-control" type="email" name="email"
                                                               placeholder="Email"></div>
                                <div class="form-group"><input class="form-control" type="password" name="password"
                                                               placeholder="Password"></div>
                                <div class="form-group ml-auto">
                                    <button class="btn btn-primary d-lg-flex ml-auto justify-content-lg-end"
                                            type="submit">Submit
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer"></div>
        </div>
    </div>
</div>
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/js/script3.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#locales").click(function () {
            var selectedOption = $('#locales').val();
            if (selectedOption != '') {
                window.location.replace('?lang=' + selectedOption);
            }
        });
    });
</script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#locales2").click(function () {
            var selectedOption = $('#locales2').val();
            if (selectedOption != '') {
                window.location.replace('?lang=' + selectedOption);
            }
        });
    });
</script>
</body>

</html>