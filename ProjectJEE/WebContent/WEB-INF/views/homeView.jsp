<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Home Page</title>
     <link rel="stylesheet" href="style.css" />
  </head>
  <body>
 
     <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_menu.jsp"></jsp:include>
      
      Дуже пре-альфа версія теоретично можливого в майбутньому сайту для мого каналу,<br>
      на якому б я продавав ноти та MIDI-файли (покищо я користуюсь чужим сайтом).<br>
      Реалізовано авторизацію для адміністратора та Cookie.<br>
      Проект отримує інформацію про файли з БД та дозволяє її редагувати (при авторизації).<br>
      Туторіал, на який я орієнтувався, включав в себе технологію Servlet-Filter,<br>
      я додав її у проект, слідуючи інструкціям:<br>
      http://o7planning.org/ru/10395/java-servlet-filter-tutorial<br>
      <br>
      <b>Вміст проекту:</b>
      <ul>
         <li>Авторизація</li>
         <li>Зберігання користувача у Cookies</li>
         <li>Відображення інформації з БД</li>
         <li>Створення запису БД</li>
         <li>Редагування запису БД</li>
         <li>Видалення запису БД</li>
      </ul>
  </body>
</html>