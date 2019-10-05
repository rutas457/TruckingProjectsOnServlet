<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${param.lang}">


<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Orders</title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    <link rel="stylesheet" href="/assets/css/styles.min.css">
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
                >Cabinet</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="/api/user/order"
                >Place order</a></li>
                <li class="nav-item" role="presentation"><a
                        class="nav-link active"
                        href="admin-settings.html">Settings</a>
                </li>
                <li class="nav-item" sec:authorize="hasRole('ROLE_ADMIN')" role="presentation"><a class="nav-link"
                                                                                                  href="/api/admin/all-users"
                >Users List</a>
                </li>
                <li class="nav-item" sec:authorize="hasRole('ROLE_ADMIN')" role="presentation"><a class="nav-link"
                                                                                                  href="/api/admin/all-orders"
                >All orders</a>
                </li>
            </ul>
            <span class="navbar-text actions"> <a class="login" href="/api/logout">Log out</a></span>
            <button class="btn" type="button" id="locales" value="uk"
                    style="height: 20px;background-image: url(&quot;/assets/img/ua.jpg&quot;);background-position: center;margin-right: 2px;margin-left: 15px;"></button>
            <button
                    class="btn" type="button" id="locales2" value="en"
                    style="height: 20px;background-image: url(&quot;/assets/img/en.jpg&quot;);background-position: center;background-size: cover;background-repeat: no-repeat;padding-right: 12px;margin: 6px;margin-top: 6px;margin-right: -27px;margin-left: 1px;"></button>
        </div>
    </div>
</nav>
<div class="card">
    <div class="card-header">
        <ul class="nav nav-tabs card-header-tabs" role="tablist">
            <li class="nav-item"><a class="nav-link active" id="item-1-1-tab" data-toggle="tab" role="tab"
                                    aria-controls="item-1-1" aria-selected="true" href="#item-1-1"
            >New orders</a></li>
            <li class="nav-item"><a class="nav-link" id="item-1-2-tab" data-toggle="tab" role="tab"
                                    aria-controls="item-1-2" aria-selected="false" href="#item-1-2"
            >In progress</a></li>
            <li class="nav-item"><a class="nav-link" id="item-1-3-tab" data-toggle="tab" role="tab"
                                    aria-controls="item-1-3" aria-selected="false" href="#item-1-3"
            >Completed</a></li>
            <li class="nav-item"><a class="nav-link" id="item-1-4-tab" data-toggle="tab" role="tab"
                                    aria-controls="item-1-4" aria-selected="false" href="#item-1-4"
            >Rejected</a></li>
        </ul>
    </div>
    <div class="card-body">
        <div id="nav-tabContent" class="tab-content">
            <div id="item-1-1" class="tab-pane fade show active" role="tabpanel" aria-labelledby="item-1-1-tab">
                <h4><span>New orders</span></h4>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>User</th>
                            <th>Email</th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="order" items="${newOrders}">
                            <tr>
                                <td>${order.user.name} ${order.user.surname}</td>
                                <td>${order.user.email}</td>
                                <td>${order.cargoName}</td>
                                <td>${order.shippingStart}</td>
                                <td>${order.shippingEnd}</td>
                                <td>${order.route.startCity}</td>
                                <td>${order.route.endCity}</td>
                                <td>${order.route.distanceInKm}</td>
                                <td>${order.weight}</td>
                                <td>${order.cargoType}</td>
                                <td>${order.price}</td>
                                <td><a href="/api/admin/change-state?action=processing&order=${order.id}"
                                >Confirm<span>/</span></a><a
                                        href="/api/admin/change-state?action=rejected&order=${order.id}"
                                >Reject</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="item-1-2" class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-2-tab">
                <h4><span> In progress</span></h4>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>User</th>
                            <th>Email</th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="order" items="${ordersInProcess}">
                            <tr>
                                <td>${order.user.name} ${order.user.surname}</td>
                                <td>${order.user.email}</td>
                                <td>${order.cargoName}</td>
                                <td>${order.shippingStart}</td>
                                <td>${order.shippingEnd}</td>
                                <td>${order.route.startCity}</td>
                                <td>${order.route.endCity}</td>
                                <td>${order.route.distanceInKm}</td>
                                <td>${order.weight}</td>
                                <td>${order.cargoType}</td>
                                <td>${order.price}</td>
                                <td><a href="/api/admin/change-state?action=completed&order=${order.id}"
                                >Completed</a>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="item-1-3" class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-3-tab">
                <h4><span>Completed</span></h4>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>User</th>
                            <th>Email</th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="order" items="${completedOrders}">
                            <tr>
                                <td>${order.user.name} ${order.user.surname}</td>
                                <td>${order.user.email}</td>
                                <td>${order.cargoName}</td>
                                <td>${order.shippingStart}</td>
                                <td>${order.shippingEnd}</td>
                                <td>${order.route.startCity}</td>
                                <td>${order.route.endCity}</td>
                                <td>${order.route.distanceInKm}</td>
                                <td>${order.weight}</td>
                                <td>${order.cargoType}</td>
                                <td>${order.price}</td>
                                <td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="item-1-4" class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-4-tab">
                <h4><span>Rejected</span></h4>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>User</th>
                            <th>Email</th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="order" items="${rejectedOrders}">
                            <tr>
                                <td>${order.user.name} ${order.user.surname}</td>
                                <td>${order.user.email}</td>
                                <td>${order.cargoName}</td>
                                <td>${order.shippingStart}</td>
                                <td>${order.shippingEnd}</td>
                                <td>${order.route.startCity}</td>
                                <td>${order.route.endCity}</td>
                                <td>${order.route.distanceInKm}</td>
                                <td>${order.weight}</td>
                                <td>${order.cargoType}</td>
                                <td>${order.price}</td>
                                <td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/js/script.min.js"></script>
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