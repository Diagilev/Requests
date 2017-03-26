<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="sidebar">
    <script type="text/javascript">
        /* Открытие меню */
        var main = function () { //главная функция
            $('.icon-menu').click(function () {
                if ($('.sidebar').css('left') == '0px') {
                    $('.sidebar').animate({left: '-235px'}, 300);
                    $('body').animate({left: '0px'}, 300);
                    $('.main').animate({width: '98.5%'}, 300);
                }
                else {
                    $('.sidebar').animate({left: '0px'}, 300);
                    $('body').animate({left: '235px'}, 300);
                    $('.main').animate({width: '80%'}, 300);
                }
            });
        }
        $(document).ready(main);
    </script>
    <br><br>
    <img width="200px" src="../img/logo.png">
    <div id="authorization">
        <c:if test="${sessionScope.email == null}">
            <p>Авторизация</p>
            <form action="Login" method="post">
                <input id="email" type="text" name="email" placeholder="E-mail">
                <br>
                <input id="password" type="password" name="password" placeholder="Пароль">
                <br>
                <input type="submit" value="Вход">
            </form>
        </c:if>
    </div>
    <c:if test="${sessionScope.email != null}">
        <p>Вы авторизованы как:</p><p><c:out value="${sessionScope.email}"/></p>
        <p><button onclick="window.location.href='/Logout'">Выйти</button></p>
        <br>
        <br>
        <p><a href="#">Регистрация договоров</a></p>
        <p><a href="#">Подача заявок</a></p>
        <p><a href="#">Транспорт</a></p>
        <br>
    </c:if>
</div>