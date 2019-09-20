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
                <li class="nav-item" role="presentation"><a class="nav-link" href="/user/personal-cabinet"
                                                           >Cabinet</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="/user/place-order"
                                                            >Place order</a></li>
                <li class="nav-item" sec:authorize="hasRole('ROLE_ADMIN')" role="presentation"><a
                        class="nav-link active"
                        href="admin-settings.html" >Settings</a>
                </li>
                <li class="nav-item" sec:authorize="hasRole('ROLE_ADMIN')" role="presentation"><a class="nav-link"
                                                                                                  href="/admin/users"
                                                                                                  >Users List</a>
                </li>
                <li class="nav-item" sec:authorize="hasRole('ROLE_ADMIN')" role="presentation"><a class="nav-link"
                                                                                                  href="/admin/cabinet"
                                                                                                  >All orders</a>
                </li>
            </ul>
            <span class="navbar-text actions"> <a class="login" href="@{/logout}">Log out</a></span>
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
                <h4><span >New orders</span></h4>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>User</th>
                            <th>Email</th>
                            <th></th>
                            <th ></th>
                            <th ></th>
                            <th ></th>
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
                            <td><a href="/api/order?action=confirmed&order=${order.id}"
                                   >Confirm<span>/</span></a><a
                                   >Reject</a></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
<%--            <div id="item-1-2" class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-2-tab">--%>
<%--                <h4><span th:text="#{in.progress}"></span></h4>--%>
<%--                <div class="table-responsive">--%>
<%--                    <table class="table">--%>
<%--                        <thead>--%>
<%--                        <tr>--%>
<%--                            <th th:text="#{user}"></th>--%>
<%--                            <th th:text="#{email}"></th>--%>
<%--                            <th th:text="#{cargo.name}"></th>--%>
<%--                            <th th:text="#{shipment.date}"></th>--%>
<%--                            <th th:text="#{arrival.date}"></th>--%>
<%--                            <th th:text="#{from.city}"></th>--%>
<%--                            <th th:text="#{to.city}"></th>--%>
<%--                            <th th:text="#{distance}"></th>--%>
<%--                            <th th:text="#{weight.calc}"></th>--%>
<%--                            <th th:text="#{cargo.type}"></th>--%>
<%--                            <th th:text="#{price}"></th>--%>
<%--                            <th th:text="#{state}"></th>--%>
<%--                        </tr>--%>
<%--                        </thead>--%>
<%--                        <tbody>--%>
<%--                        <tr th:each="order: ${ordersInProcess}">--%>
<%--                            <td th:text="${order.user.firstName} +' '+${order.user.surname} "></td>--%>
<%--                            <td th:text="${order.user.email}">/td>--%>
<%--                            <td th:text="${order.cargoName}"></td>--%>
<%--                            <td th:text="${order.shippingStart}"></td>--%>
<%--                            <td th:text="${order.shippingEnd}"></td>--%>
<%--                            <td th:text="${order.route.startCity}"></td>--%>
<%--                            <td th:text="${order.route.endCity}"></td>--%>
<%--                            <td th:text="${order.route.distanceInKm}"></td>--%>
<%--                            <td th:text="${order.weight}"></td>--%>
<%--                            <td th:text="${order.cargoType}"></td>--%>
<%--                            <td th:text="${order.price}"></td>--%>
<%--                            <td><a th:href="@{/admin/cabinet/complete(id=${order.id})}">Completed</a></td>--%>
<%--                        </tr>--%>
<%--                        </tbody>--%>
<%--                    </table>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div id="item-1-3" class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-3-tab">--%>
<%--                <h4><span th:text="#{completed}"></span></h4>--%>
<%--                <div class="table-responsive">--%>
<%--                    <table class="table">--%>
<%--                        <thead>--%>
<%--                        <tr>--%>
<%--                            <th th:text="#{user}"></th>--%>
<%--                            <th th:text="#{email}"></th>--%>
<%--                            <th th:text="#{cargo.name}"></th>--%>
<%--                            <th th:text="#{shipment.date}"></th>--%>
<%--                            <th th:text="#{arrival.date}"></th>--%>
<%--                            <th th:text="#{from.city}"></th>--%>
<%--                            <th th:text="#{to.city}"></th>--%>
<%--                            <th th:text="#{distance}"></th>--%>
<%--                            <th th:text="#{weight.calc}"></th>--%>
<%--                            <th th:text="#{cargo.type}"></th>--%>
<%--                            <th th:text="#{price}"></th>--%>
<%--                            <th th:text="#{state}"></th>--%>
<%--                        </tr>--%>
<%--                        </thead>--%>
<%--                        <tbody>--%>
<%--                        <tr th:each="order: ${completedOrders}">--%>
<%--                            <td th:text="${order.user.firstName} +' '+${order.user.surname} "></td>--%>
<%--                            <td th:text="${order.user.email}"></td>--%>
<%--                            <td th:text="${order.cargoName}"></td>--%>
<%--                            <td th:text="${order.shippingStart}"></td>--%>
<%--                            <td th:text="${order.shippingEnd}"></td>--%>
<%--                            <td th:text="${order.route.startCity}"></td>--%>
<%--                            <td th:text="${order.route.endCity}"></td>--%>
<%--                            <td th:text="${order.route.distanceInKm}"></td>--%>
<%--                            <td th:text="${order.weight}"></td>--%>
<%--                            <td th:text="${order.cargoType}"></td>--%>
<%--                            <td th:text="${order.price}"></td>--%>
<%--                            <td th:text="${order.state}"></td>--%>
<%--                        </tr>--%>
<%--                        </tbody>--%>
<%--                    </table>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div id="item-1-4" class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-4-tab">--%>
<%--                <h4><span th:text="#{rejected}"></span></h4>--%>
<%--                <div class="table-responsive">--%>
<%--                    <table class="table">--%>
<%--                        <thead>--%>
<%--                        <tr>--%>
<%--                            <th th:text="#{user}"></th>--%>
<%--                            <th th:text="#{email}"></th>--%>
<%--                            <th th:text="#{cargo.name}"></th>--%>
<%--                            <th th:text="#{shipment.date}"></th>--%>
<%--                            <th th:text="#{arrival.date}"></th>--%>
<%--                            <th th:text="#{from.city}"></th>--%>
<%--                            <th th:text="#{to.city}"></th>--%>
<%--                            <th th:text="#{distance}"></th>--%>
<%--                            <th th:text="#{weight.calc}"></th>--%>
<%--                            <th th:text="#{cargo.type}"></th>--%>
<%--                            <th th:text="#{price}"></th>--%>
<%--                            <th th:text="#{state}"></th>--%>
<%--                        </tr>--%>
<%--                        </thead>--%>
<%--                        <tbody>--%>
<%--                        <tr th:each="order: ${rejectedOrders}">--%>
<%--                            <td th:text="${order.user.firstName} +' '+${order.user.surname} "></td>--%>
<%--                            <td th:text="${order.user.email}"></td>--%>
<%--                            <td th:text="${order.cargoName}"></td>--%>
<%--                            <td th:text="${order.shippingStart}"></td>--%>
<%--                            <td th:text="${order.shippingEnd}"></td>--%>
<%--                            <td th:text="${order.route.startCity}"></td>--%>
<%--                            <td th:text="${order.route.endCity}"></td>--%>
<%--                            <td th:text="${order.route.distanceInKm}"></td>--%>
<%--                            <td th:text="${order.weight}"></td>--%>
<%--                            <td th:text="${order.cargoType}"></td>--%>
<%--                            <td th:text="${order.price}"></td>--%>
<%--                            <td th:text="${order.state}"></td>--%>
<%--                        </tr>--%>
<%--                        </tbody>--%>
<%--                    </table>--%>
<%--                </div>--%>
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