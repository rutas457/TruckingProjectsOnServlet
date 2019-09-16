<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${param.lang}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Trucking service</title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="/assets/css/styles2.min.css">
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>
<div>
    <nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
        <div class="container"><a class="navbar-brand" href="#">TruckKing</a>
            <button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span
                    class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse"
                 id="navcol-1">
                <ul class="nav navbar-nav mr-auto">
                    <li class="nav-item"><a class="nav-link" href="#calculate"></a></li>
                </ul>
                <span class="navbar-text actions"> <a href="/api/login" class="login"><fmt:message key="login"/></a><a
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
</div>
<div data-bs-parallax-bg="true"
     style="height: 500px;background-image: url(&quot;/assets/img/dl-1-4g6.jpg&quot;);background-position: center;background-size: cover;"></div>
<div class="features-clean" style="height: 562px;">
    <div class="container">
        <div class="intro">
            <h2 class="text-center"></h2>
            <p class="text-center"></p>
        </div>
        <div class="row features" style="height: 337px;">
            <div class="col-sm-6 col-lg-4 item"><i class="fa fa-map-marker icon"></i>
                <h3 class="name"></h3>
                <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent
                    aliquam in tellus eu gravida. Aliquam varius finibus est.</p>
            </div>
            <div class="col-sm-6 col-lg-4 item"><i class="fa fa-clock-o icon"></i>
                <h3 class="name"></h3>
                <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent
                    aliquam in tellus eu gravida. Aliquam varius finibus est.</p>
            </div>
            <div class="col-sm-6 col-lg-4 item"><i class="fa fa-list-alt icon"></i>
                <h3 class="name"></h3>
                <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent
                    aliquam in tellus eu gravida. Aliquam varius finibus est.</p>
            </div>
            <div class="col-sm-6 col-lg-4 item"><i class="fa fa-leaf icon"></i>
                <h3 class="name"></h3>
                <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent
                    aliquam in tellus eu gravida. Aliquam varius finibus est.</p>
            </div>
            <div class="col-sm-6 col-lg-4 item"><i class="fa fa-plane icon"></i>
                <h3 class="name"></h3>
                <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent
                    aliquam in tellus eu gravida. Aliquam varius finibus est.</p>
            </div>
            <div class="col-sm-6 col-lg-4 item"><i class="fa fa-phone icon"></i>
                <h3 class="name"></h3>
                <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent
                    aliquam in tellus eu gravida. Aliquam varius finibus est.</p>
            </div>
        </div>
    </div>
</div>
<div style="height: 297px;">
    <div id="calculate" class="container border rounded-0 border-success" style="height: 320px;">
        <div class="row" style="height: 302px;">
            <div class="col-md-6" style="background-color: rgba(41,152,239,0.17);height: 302px;">
                <h2 class="text-center" style="margin: 110px;"><fmt:message key="count.price"/></h2>
            </div>
            <div class="col-md-6"
                 style="background-color: rgba(41,152,239,0.17);height: 302px;color: rgb(20,133,238);filter: blur(0px) brightness(100%) grayscale(0%);">
                <form class="text-center" style="margin: 70px;padding: 7px;" action="@{/}" method="post">
                    <div class="form-group"><select name="from" class="form-control" id="box_g1">
                        <optgroup label="Departure city">
                            <option selected="selected" value="Kyiv">Kyiv</option>
                            <option value="Lviv">Lviv</option>
                            <option value="Odesa">Odesa</option>
                            <option value="Kharkiv">Kharkiv</option>
                        </optgroup>
                    </select></div>
                    <div class="form-group"><select name="to" class="form-control">
                        <optgroup label="Arrival city">
                            <option selected="selected" value="Lviv">Lviv</option>
                            <option value="Kyiv">Kyiv</option>
                            <option value="Odesa">Odesa</option>
                            <option value="Kharkiv">Kharkiv</option>
                        </optgroup>
                    </select></div>
                    <div class="form-group"><input name="weight" class="form-control" type="number" min="1"
                                                   max="40"
                                                   style="width: 250px;"></div>
                    <div class="form-group">
                        <button class="btn btn-primary" type="submit" style="background-color: #5bbf21;"
                        ></button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="projects-clean">
    <div class="container" style="height: 633px;">
        <div class="intro">
            <h2 class="text-center"></h2>
            <p class="text-center"></p>
        </div>
        <div class="row projects">
            <div class="col-sm-6 col-lg-4 item"><img class="img-fluid" src="/assets/img/desk.jpg">
                <h3 class="name"></h3>
                <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent
                    aliquam in tellus eu gravida. Aliquam varius finibus est, interdum justo suscipit id.</p>
            </div>
            <div class="col-sm-6 col-lg-4 item"><img class="img-fluid" src="/assets/img/building.jpg">
                <h3 class="name"></h3>
                <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent
                    aliquam in tellus eu gravida. Aliquam varius finibus est, interdum justo suscipit id.</p>
            </div>
            <div class="col-sm-6 col-lg-4 item"><img class="img-fluid" src="/assets/img/loft.jpg">
                <h3 class="name"></h3>
                <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent
                    aliquam in tellus eu gravida. Aliquam varius finibus est, interdum justo suscipit id.</p>
            </div>
        </div>
    </div>
</div>
<div class="footer-basic">
    <footer>
        <div class="social"><a href="#"><i class="icon ion-social-instagram"></i></a><a href="#"><i
                class="icon ion-social-snapchat"></i></a><a href="#"><i class="icon ion-social-twitter"></i></a><a
                href="#"><i class="icon ion-social-facebook"></i></a></div>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="#">Home</a></li>
            <li class="list-inline-item"><a href="#">Services</a></li>
            <li class="list-inline-item"><a href="#">About</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Privacy Policy</a></li>
        </ul>
        <p class="copyright">TruckKing © 2019</p>
    </footer>
</div>
<div class="modal fade" role="dialog" tabindex="-1" id="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span></button></div>
            <div class="modal-body">
                <div>
                    <ul class="nav nav-tabs">
                        <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" href="#tab-1">Sign in</a></li>
                        <li class="nav-item"><a class="nav-link active" role="tab" data-toggle="tab" href="#tab-2">Sign up</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane" role="tabpanel" id="tab-1">
                            <p></p>
                            <form method="post" action="/api/login">
                                <div class="form-group"><i class="fa fa-lock d-lg-flex justify-content-lg-center" style="font-size: 32px;"></i></div>
                                <div class="form-group"><input class="form-control" type="email" name="email" placeholder="Email"></div>
                                <div class="form-group"><input class="form-control" type="password" name="pass" placeholder="Password"></div>
                                <div class="form-group"><button class="btn btn-primary d-lg-flex ml-auto" type="submit">Submit</button></div>
                            </form>
                        </div>
                        <div class="tab-pane active" role="tabpanel" id="tab-2">
                            <p></p>
                            <form>
                                <div class="form-group"><i class="fa fa-key d-lg-flex justify-content-lg-center" style="font-size: 32px;"></i></div>
                                <div class="form-group"><input class="form-control" type="text" name="name" placeholder="Name"></div>
                                <div class="form-group"><input class="form-control" type="text" name="surname" placeholder="Surname"></div>
                                <div class="form-group"><input class="form-control" type="email" name="email" placeholder="Email"></div>
                                <div class="form-group"><input class="form-control" type="password" name="pass" placeholder="Password"></div>
                                <div class="form-group ml-auto"><button class="btn btn-primary d-lg-flex ml-auto justify-content-lg-end" type="submit">Submit</button></div>
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
<script src="/assets/js/script2.min.js"></script>

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
<script>
    $('select').on('change', function () {

        $('select').find('option').prop('disabled', false);

        $('select').each(function () {
            $('select').not(this).find('option[value="' + this.value + '"]').prop('disabled', true);
        });

    });
</script>
</body>

</html>
