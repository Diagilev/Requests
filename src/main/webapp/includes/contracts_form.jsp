<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="contractAdd">
    <fieldset>
        <legend>Регистрация нового договора</legend>
    <form name="addContract" id="addContract">
        <table border="0">
            <tbody>
            <tr>
                <td width="20%" align="right"><span>*</span>Номер договора:</td>
                <td width="70%" align="left"><input required id="contractId" name="contractId" type="text"></td>
                <td width="0%" align="right"></td>
            </tr>
            <tr>
                <td width="45%" align="right"><span>*</span>Название предприятия:</td>
                <td width="15%" align="left"><select required id="companyName" name="companyName">
                    <option disabled selected value="Выберите предприятие">Выберите предприятие</option>
                    <option>ООО "Алгос"</option>
                    <option>ООО "Техком-сервис"</option>
                    <option>ООО "Техсервис-инжиниринг"</option>
                </select></td>
                <td width="45%" align="right"></td>
            </tr>
            <tr>
                <td align="right"><span>*</span>Предмет договора:</td>
                <td align="left"><input required id="subject" name="subject" type="text"></td>
                <td align="right"></td>
            </tr>
            <tr>
                <td align="right"><span>*</span>Вторая сторона договора:</td>
                <td align="left"><input required id="clientName" name="clientName" type="text">                    <select id="status" name="status">
                    <option disabled selected>Статус</option>
                    <option>Клиент</option>
                    <option>Поставщик</option>
                </select></td>
                <td align="left">
                </td>
            </tr>
            <tr>
                <td align="right"><span>*</span>Документ:</td>
                <td align="left"><input required id="file" type="file" onChange='upload()'></td>
                <td align="right"></td>
            </tr>
            <tr>
                <td align="right"></td>
                <td align="left"><button type="button" id="btn" name="btn">Добавить договор</button></td>
                <td align="right"></td>
            </tr>
            </tbody>
        </table>
    </form>

    </fieldset>
    </div>

<%--            <label for="contractId">Номер договора:</label>
            <br>
            <input required id="contractId" name="contractId" type="text">
            <br><br>
            <label for="companyName">Название предприятия:</label>
            <br>
            <select required id="companyName" name="companyName">
                <option disabled selected value="Выберите предприятие">Выберите предприятие</option>
                <option>ООО "Алгос"</option>
                <option>ООО "Техком-сервис"</option>
                <option>ООО "Техсервис-инжиниринг"</option>
            </select>
            <br><br>
            <label for="subject">Предмет договора:</label>
            <br>
            <input required id="subject" name="subject" type="text">
            <br><br>
            <label for="clientName">Вторая сторона договора:</label>
            <br>
            <input required id="clientName" name="clientName" type="text">
            <select id="status" name="status">
                <option disabled selected>Статус</option>
                <option>Клиент</option>
                <option>Поставщик</option>
            </select>
            <br><br>
            <label for="file">Документ:</label>
            <br>
            <input required id="file" type="file" onChange='upload()'>
            <br>
            <br>
            <input id="btn" type="button" name="btn" value="Добавить договор">

    </form>--%>
<div class="contractView">
    <fieldset>
        <legend>Зарегистрированные договора</legend>
        <form id="criteria" name="criteria">
            <button id="ViewData" name="ViewData" type="Button">Получить список договоров</button>
            <input id="criteriaSubject" name="criteriaSubject" type="text" placeholder="Предмет договора">
            <input id="criteriaName" name="criteriaName" type="text" placeholder="Вторая сторона договора">
            <span>Сортировка по дате:</span>
            <select class="criteries" name="criteriaDate">
                <option selected value="desc">От новых к старым</option>
                <option value="asc">От старых к новым</option>
            </select>
            <span>Записей на странице:</span>
            <select class="criteries" name="criteriaLimit">
                <option value="10">10</option>
                <option selected value="50">50</option>
                <option value="100">100</option>
            </select>
        </form>
        <br>
        <div id="result"></div>
    </fieldset>
</div>
