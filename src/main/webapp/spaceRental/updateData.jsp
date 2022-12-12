<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Updating...</title>

</head>
<body>
	<h1>Update Space Data</h1>
	<div id="container">
		<c:set var="update" value="${update}" scope="session" />
		<form action="<c:url value='/spaceAdmin/updateConfirmServlet?confirm=${update.spaceNo}' />" method="post" enctype="multipart/form-data">
			<p>
				<label class="c1" for="spaceName">場地名稱</label>
				<input type="text" name="spaceName" value="${update.spaceName }">
			</p>

			<p>
				<label class="c1">所在縣市</label> 
				<select name="city" value="${update.city}">
					<option value="台北市">台北市</option>
					<option value="新北市">新北市</option>
					<option value="桃園市">桃園市</option>
					<option value="新竹市">新竹市</option>
				</select>
			</p>

			<p>
				<label class="c1">詳細地址</label>
				<input type="text" name="address" value="${update.address}">
			</p>

			<p>
				<label class="c1">容納人數</label>
				<input type="number" name="accommodate" value="${update.accommodate}">
			</p>

			<p>
				<label class="c1">場地類型</label>
				<select name="spaceType" value="${update.spaceType}">
					<option value="商務會議">商務會議</option>
					<option value="多功能">多功能</option>
					<option value="烹飪教室">烹飪教室</option>
					<option value="藝文展演">藝文展演</option>
					<option value="多媒體">多媒體</option>
				</select>
			</p>

			<p>
				<label class="c1">收取金額</label>
				<input type="number" name="price" value="${update.price}">
			</p>

			<p>
				<label class="c1" >收費單位</label>
				<input type="radio" name="unit" value="小時"required>小時
				<input type="radio" name="unit" value="全天"required>全天
			</p>

			<p>
				<label class="c1">開放時段(一)</label>
				<select name="period1" value="${update.period1}">
					<option value="上午09:00-12:00">上午09:00-12:00</option>
					<option value="下午12:01-17:00">下午12:01-17:00</option>
					<option value="晚上17:01-21:00">晚上17:01-21:00</option>
					<option value="全天09:00-21:00">全天09:00-21:00</option>
					<option value="無">無</option>
				</select>
			</p>

			<p>
				<label class="c1">開放時段(二)</label>
				<select name="period2" value="${update.period2}">
				<option value="上午09:00-12:00">上午09:00-12:00</option>
					<option value="下午12:01-17:00">下午12:01-17:00</option>
					<option value="晚上17:01-21:00">晚上17:01-21:00</option>
					<option value="全天09:00-21:00">全天09:00-21:00</option>
					<option value="無">無</option>
				</select>
			</p>

			<p>
				<label class="c1">提供設施1</label>
				<select name="facility_1" value="${update.facility_1}">
					<option value="會議桌">會議桌</option>
					<option value="無線wifi">無線wifi</option>
					<option value="桌椅">桌椅</option>
					<option value="投影機(幕)">投影機(幕)</option>
					<option value="螢幕">螢幕</option>
					<option value="白板設備">白板設備</option>
					<option value="音響設備">音響設備</opiton>
					<option value="烹飪設備">烹飪設備</option>
					<option value="電腦">電腦</option>
					<option value="咖啡機">咖啡機</option>
					<option value="洗手間">洗手間</option>
					<option value="無">無</option>
				</select>
			</p>

			<p>
				<label class="c1">提供設施2</label>
				<select name="facility_2" value="${update.facility_2}">
					<option value="會議桌">會議桌</option>
					<option value="無線wifi">無線wifi</option>
					<option value="桌椅">桌椅</option>
					<option value="投影機(幕)">投影機(幕)</option>
					<option value="螢幕">螢幕</option>
					<option value="白板設備">白板設備</option>
					<option value="音響設備">音響設備</opiton>
					<option value="烹飪設備">烹飪設備</option>
					<option value="電腦">電腦</option>
					<option value="咖啡機">咖啡機</option>
					<option value="洗手間">洗手間</option>
					<option value="無">無</option>
				</select>
			</p>

			<p>
				<label class="c1">提供設施3</label>
				<select name="facility_3" value="${update.facility_3}">
					<option value="會議桌">會議桌</option>
					<option value="無線wifi">無線wifi</option>
					<option value="桌椅">桌椅</option>
					<option value="投影機(幕)">投影機(幕)</option>
					<option value="螢幕">螢幕</option>
					<option value="白板設備">白板設備</option>
					<option value="音響設備">音響設備</opiton>
					<option value="烹飪設備">烹飪設備</option>
					<option value="電腦">電腦</option>
					<option value="咖啡機">咖啡機</option>
					<option value="洗手間">洗手間</option>
					<option value="無">無</option>
				</select>
			</p>

			<p>
				<label class="c1">提供設施4</label>
				<select name="facility_4" value="${update.facility_4}">
					<option value="會議桌">會議桌</option>
					<option value="無線wifi">無線wifi</option>
					<option value="桌椅">桌椅</option>
					<option value="投影機(幕)">投影機(幕)</option>
					<option value="螢幕">螢幕</option>
					<option value="白板設備">白板設備</option>
					<option value="音響設備">音響設備</opiton>
					<option value="烹飪設備">烹飪設備</option>
					<option value="電腦">電腦</option>
					<option value="咖啡機">咖啡機</option>
					<option value="洗手間">洗手間</option>
					<option value="無">無</option>
				</select>
			</p>

			<p>
				<label class="c1">提供設施5</label>
				<select name="facility_5" value="${update.facility_5}">
					<option value="會議桌">會議桌</option>
					<option value="無線wifi">無線wifi</option>
					<option value="桌椅">桌椅</option>
					<option value="投影機(幕)">投影機(幕)</option>
					<option value="螢幕">螢幕</option>
					<option value="白板設備">白板設備</option>
					<option value="音響設備">音響設備</opiton>
					<option value="烹飪設備">烹飪設備</option>
					<option value="電腦">電腦</option>
					<option value="咖啡機">咖啡機</option>
					<option value="洗手間">洗手間</option>
					<option value="無">無</option>
				</select>
			</p>

			<p>
				<label class="c1">場地介紹</label>
				<textarea name="intro" cols="30" rows="5"  style="width:300px;height:80px;">${update.intro}</textarea>
			</p>

			<p>
			<label class="c1">修改照片</label>
				<input type="file" name="pic" multiple value="${update.pic}">
			</p>

			<p class="box">
				<img src="<c:url value='/spaceAdmin/showSpaceImgServlet?spaceNo=${update.spaceNo}' />" alt="無原始圖片"  width="400px" height="280px">
				
			</p>

			<input id="submit" type="submit" value="確認並儲存" >
			<input type ="button" onclick="history.go(-1)" value="取消"></input>
		</form>
	</div>
</body>
</html>