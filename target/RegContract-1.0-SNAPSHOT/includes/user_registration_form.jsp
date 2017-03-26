<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
<fieldset>
    <legend>Регистрация нового пользоваьеля</legend>
    <form id="user_form" name="user_form">
<table width="100%" border="0">
    <tbody>
    <tr>
        <td align="right" width="45%"><span>*</span>Имя пользователя:</td>
        <td width="55%"><input id="name" type="text" name="name" required></td>
    </tr>
    <tr>
        <td align="right"><span>*</span>Фамилия пользователя:</td>
        <td><input type="text" name="surname" required></td>
    </tr>
    <tr>
        <td align="right"><span>*</span>E-mail пользователя:</td>
        <td><input type="text" name="email" required></td>
    </tr>
    <tr>
        <td align="right"><span>*</span>Пароль:</td>
        <td><input type="password" name="password" required></td>
    </tr>
    <tr>
        <td align="right"><span>*</span>Уровень доступа:</td>
        <td><select type="text" name="role">
            <option value="admin">Администратор</option>
            <option value="operator">Оператор</option>
            <option selected=user">Пользователь</option>
        </select></td>
    </tr>
    </tbody>
</table>
        <input id="user_reg_btn" type="button" name="user_reg_btn" value="Регистрация">
    </form>
    </fieldset>
</div>