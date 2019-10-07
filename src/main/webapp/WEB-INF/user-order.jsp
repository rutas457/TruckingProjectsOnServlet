<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="${cookie['lang'].value}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Order</title>
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
                ><fmt:message key="cabinet"/></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="/api/user/order"
                ><fmt:message key="place.order"/></a></li>
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
<div class="register-photo">
    <div class="form-container">
        <div class="image-holder" style="background-image: url(&quot;/assets/img/banner.jpg&quot;);"></div>
        <form action="api/user/order" method="post">
            <h2 class="text-center"><strong><fmt:message key="order"/></strong></h2><input name="cargoName"
                                                                      class="form-control" type="text"
                                                                      placeholder="<fmt:message key="cargo.name"/>"
                                                                      style="margin-top: -22px;margin-bottom: 3px;">
            <div class="form-group" style="margin-top: 9px;"><label><fmt:message key="from.city"/></label><select
                    name="fromCity" class="form-control">
                <optgroup label=<fmt:message key="select.from"/>>
                    <option selected="selected" value="Lviv"><fmt:message key="Lviv"/></option>
                    <option value="Kyiv"><fmt:message key="Kyiv"/></option>
                    <option value="Odesa"><fmt:message key="Odesa"/></option>
                    <option value="Kharkiv"><fmt:message key="Kharkiv"/></option>
                </optgroup>
            </select></div>
            <div class="form-group"><label><fmt:message key="to.city"/></label><select name="toCity"
                                                                  class="form-control">
                <optgroup label="<fmt:message key="to.city"/>">
                    <option selected="selected" value="Kyiv"><fmt:message key="Kyiv"/></option>
                    <option value="Lviv"><fmt:message key="Lviv"/></option>
                    <option value="Odesa"><fmt:message key="Odesa"/></option>
                    <option value="Kharkiv"><fmt:message key="Kharkiv"/></option>
                </optgroup>
            </select></div>
            <label><fmt:message key="shipment.date"/></label>
            <div class="form-group"><input class="form-control" type="date" name="shippingStart" id="txtDate"></div>
            <div class="form-group"><label><fmt:message key="arrival.date"/></label><input class="form-control" type="date"
                                                                      name="shippingEnd" id="txtDateEnd"></div>
            <div class="form-group"><input class="form-control" type="number" min="1" max="40"
                                           placeholder=<fmt:message key="weight"/>
                                           name="weight"></div>
            <div class="form-group"><label><fmt:message key="cargo.type"/></label><select class="form-control"
                                                                     name="cargoType">
                <optgroup>
                    <option value="Standard"><fmt:message key="standard"/></option>
                    <option value="Food" ><fmt:message key="food"/></option>
                    <option value="Dangerous"><fmt:message key="dangerous"/></option>
                    <option value="Fragile"><fmt:message key="fragile"/></option>
                </optgroup>
            </select></div>
            <div class="form-group">
                <button class="btn btn-primary btn-block" style="background-color: #00bce2;" type="submit">
                    <fmt:message key="submit"/>
                </button>
            </div>
        </form>
    </div>
</div>
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/js/script.min.js"></script>
<script type="text/javascript">
    $(function () {
        var dtToday = new Date();

        var month = dtToday.getMonth() + 1;
        var day = dtToday.getDate();
        var year = dtToday.getFullYear();
        if (month < 10)
            month = '0' + month.toString();
        if (day < 10)
            day = '0' + day.toString();
        var maxDate = year + '-' + month + '-' + day;
        $('#txtDate').attr('min', maxDate);
    });
</script>

<script>
    $(document).ready(function () {
        $('#txtDate').change(function () {
            var inputDate = new Date(this.value);
            var month = inputDate.getMonth() + 1;
            var day = inputDate.getDate();
            var year = inputDate.getFullYear();
            if (month < 10)
                month = '0' + month.toString();
            if (day < 10)
                day = '0' + day.toString();
            var maxDate = year + '-' + month + '-' + (day + 1);
            if (new Date(maxDate) > inputDate) {
                $('#txtDateEnd').val(maxDate);
            }
            $('#txtDateEnd').attr('min', maxDate);
        });
    });
</script>
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