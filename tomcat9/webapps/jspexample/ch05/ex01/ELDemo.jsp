<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>EL Demo</title>
</head>
<body> 
Case1 屬性物件是字串物件==>透過 EL 來取用，\${識別字串}<br>
 
<font Color='darkblue'>${Case1} </font><p/>
<hr>
Case2 屬性物件是JavaBean物件==>透過 EL 來取用，\${識別字串.JavaBean的性質}<br>
<font Color='red'>
訂單編號：${Case2.orderNo} <br>
訂單日期：${Case2.orderDate} <br>
客戶編號：${Case2.customerID} <br>
訂單金額：${Case2.amount} <br>
</font>
<hr>
Case3 屬性物件是Map物件==>透過EL來取用，\${識別字串.鍵值}就可取得對應的value，
如果value為JavaBean則\${識別字串.鍵值.Bean的性質名稱}就可以取得對應的性質<br>
<font Color='blue'>
mapkey1對應字串物件：${Case3.mapkey1} <br>
訂單編號：${Case3.mapkey2.orderNo} <br>
訂單日期：${Case3.mapkey2.orderDate} <br>
客戶編號：${Case3.mapkey2.customerID} <br>
訂單金額：${Case3.mapkey2.amount} <br>
</font>
<hr>
Case4 屬性物件是元素是JavaBean物件的陣列==>搭配JSTL的＜c:forEach＞ 與 EL 來取用<br>
<font Color='brown'>
<c:forEach var="aVar" items="${Case4}">
訂單編號：${aVar.orderNo} <br>
訂單日期：${aVar.orderDate} <br>
客戶編號：${aVar.customerID} <br>
訂單金額：${aVar.amount} <br>
------------------------------------------<br>
</c:forEach>
</font>
<hr>
Case5 屬性物件是元素是JavaBean物件的Collection==>搭配JSTL的＜c:forEach＞與EL 來取用<br>
<font Color='purple'>
<c:forEach var="aVar" items="${Case5}">
訂單編號：${aVar.orderNo} <br>
訂單日期：${aVar.orderDate} <br>
客戶編號：${aVar.customerID} <br>
訂單金額：${aVar.amount} <br>
------------------------------------------<br>
</c:forEach>
</font>
<hr>
Case6 屬性物件是元素是JavaBean物件的Map==>搭配JSTL的＜c:forEach＞與EL 來取用<br>
<font Color='red'>
<c:forEach var="anEntry" items="${Case6}">
Map的Key：${anEntry.key} <br>
訂單編號：${anEntry.value.orderNo} <br>
訂單日期：${anEntry.value.orderDate} <br>
客戶編號：${anEntry.value.customerID} <br>
訂單金額：${anEntry.value.amount} <br>
------------------------------------------<br>
</c:forEach>
</font>
<small>&lt;&lt;<a href="<c:url value='/ch05/index.jsp' />">回第五章首頁</a>&gt;&gt;</small> 
</body>
</html>