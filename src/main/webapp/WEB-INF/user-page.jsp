<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>User page</title>
    <link rel="stylesheet" href="/user-assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/user-assets/css/Login-Form-Dark.css">
    <link rel="stylesheet" href="/user-assets/css/Navigation-Clean.css">
    <link rel="stylesheet" href="/user-assets/css/Navigation-with-Button.css">
    <link rel="stylesheet" href="/user-assets/css/styles.css">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
    <div class="container"><a class="navbar-brand" href="#">TruckKing</a>
        <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse"
             id="navcol-1">
            <ul class="nav navbar-nav mr-auto">
                <li class="nav-item" role="presentation"><a class="nav-link" href="/api/user/page"
                ><fmt:message key="cabinet"/></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="/api/user/order"
                ><fmt:message key="place.order"/></a></li>
            </ul>
            <span class="navbar-text actions"> <a class="login" href="/api/logout"><fmt:message
                    key="logout"/></a></span>
            <button class="btn" type="button" id="locales" value="uk"
                    style="height: 20px;background-image: url(&quot;/assets/img/ua.jpg&quot;);background-position: center;margin-right: 2px;margin-left: 15px;"></button>
            <button
                    class="btn" type="button" id="locales2" value="en"
                    style="height: 20px;background-image: url(&quot;/assets/img/en.jpg&quot;);background-position: center;background-size: cover;background-repeat: no-repeat;padding-right: 12px;margin: 6px;margin-top: 6px;margin-right: -27px;margin-left: 1px;"></button>
        </div>
    </div>
</nav>
<div class="row">
    <div class="col">
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th><fmt:message key="cargo.type"/></th>
                    <th><fmt:message key="shipment.date"/></th>
                    <th><fmt:message key="arrival.date"/></th>
                    <th><fmt:message key="from.city"/></th>
                    <th><fmt:message key="to.city"/></th>
                    <th><fmt:message key="distance.in.km"/></th>
                    <th><fmt:message key="weight"/></th>
                    <th><fmt:message key="type"/></th>
                    <th><fmt:message key="price"/></th>
                    <th><fmt:message key="state"/></th>
                    <th><fmt:message key="payment.state"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="order" items="${userOrders}">
                    <tr>
                        <td>${order.cargoName}</td>
                        <td>${order.shippingStart}</td>
                        <td>${order.shippingEnd}</td>
                        <td>${order.route.startCity}</td>
                        <td>${order.route.endCity}</td>
                        <td>${order.route.distanceInKm}</td>
                        <td>${order.weight}</td>
                        <td>${order.cargoType}</td>
                        <td>${order.price}</td>
                        <td>${order.state}</td>
                        <td><a href="/api/user/order/set-paid?order=${order.id}"
                        >${order.paid ? "Paid" : "Pay"}<span></span></a>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="/user-assets/js/jquery.min.js"></script>
<script src="/user-assets/bootstrap/js/bootstrap.min.js"></script>
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