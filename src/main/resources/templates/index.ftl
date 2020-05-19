<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
html, body {
	height: 100%
}
ul, li, body {
	margin: 0;
	padding: 0;
}
ul {
	list-style: none;
}
a {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
.left {
	width: 15%;
	height: 100%;
	background-color: #334C58;
	float: left;
}
.left .l_top {
	height: 70px;
	background-color: #59D78D;
	padding: 1px;
}
.left .l_top .t_title {
	height: 70px;
	margin: 19px 0 0 30px;
	color: #E8FFF4;
	font-size: 18px;
	font-weight: bold;
}
.left ul li {
	width: 100%;
	height: 40px;
	line-height: 40px;
	padding-left: 30px;
}
.left ul .${chosedItem} {
	border-color: #59D78D;
	border-style: none none none solid;
	background-color: #263940;

}
.left ul .${chosedItem} a i{
	color: #FCFBFE;
}
.left ul .${chosedItem} a font{
	color: #FCFBFE;
}
.left ul .l_m_tlist a:hover i{
	color: #FCFBFE;
}
.left ul .l_m_tlist a:hover font{
	color: #FCFBFE;
}
.left ul .l_m_t_tests {
	margin-top: 25px;
}
.left ul .l_m_t_student {
	margin-top: 30px;
}
.left li a {
	display: inline-block;
	width: 100%;
	height: 100%;
}
.left ul .l_m_title {
	color: #8AA4AB;
	font-size: 15px;
}
.left ul li .l_m_list {
	color: #8AA4AB;
	font-size: 16px;
	margin-left: 5px;
}
.left li .fa {
	margin-right: 10px;
}
.right {
	width: 85%;
	height: 100%;
	background-color: #FCFBFE;
	float: right;

}
.right .r_top {
	height: 70px;
	background-color: #FFFFFF;
	padding: 16px;
	box-shadow: 0px 1px 7px #BBBBBB;
	margin-bottom:7px;
}
.right .r_top .search{
	width:295px;
	height:25px;
	display:inline-block;
	margin-left:50px;
}
.right .r_top .search input{
	padding-left:7px;
	border:none;
	border-radius:15px;
	background-color:#F3F5F7;
}
.right .r_top .fa{
	color:#A9A9AB;
}
.right .r_top .fa-chevron-left{
	margin-left:15px;
}
.right .r_top .fa-chevron-right{
	margin-left:45px;
}
.right .r_top .fa-chevron-down{
	float:right;
	margin-top:17px;
	margin-right: 10px;
	font-size:10px;
	color:#AAAAAA;
}
.right .r_top .username{
	color:#888888;
	float:right;
	margin-right: 10px;
    margin-top: 12px;
}
.right .r_top .img-circle{
	height:40px;
	float:right;
	margin-right:10px;
}
.${ifShow}{
    display:none
}
</style>
</head>
<body>
	<div class="left">
		<div class="l_top">
			<div class="t_title">Test</div>
		</div>
		<div class="l_middle">
			<ul>
				<li class="l_m_t_tests l_m_title">管理</li>
				<li class="l_m_tlist userManager"><a href="/user/allUserView" class="l_m_list"> <i
						class="fa fa-list-alt"></i><font>用户管理</font>
				</a></li>
				<li class="l_m_tlist roleManager ifShow"><a href="/role/findAllRoleByPageAndSize" class="l_m_list"> <i
						class="fa fa-address-card"></i><font>角色管理</font>
				</a></li>
			</ul>
		</div>
	</div>
	<div class="right" >
		<div class="r_top">

			<a href="javascript:history.back()"><i class="fa fa-chevron-left fa-lg"></i></a>
			<a href="javascript:history.forward()"><i class="fa fa-chevron-right fa-lg"></i></a>

			<div class="search form-group has-feedback">
				<input
					type="text" class="form-control" id="uid" value=""
					autocomplete="off" autofocus="autofocus" onkeydown="findUserById()">
				<span
					class="fa fa-search form-control-feedback"></span>
			</div>
			<a href="#"><i class="fa fa-chevron-down"></i>
			<i class="username">${getUser.username}</i></a>
		</div>
		<div class="middle" >
			<#include "${content}">
		</div>

	</div>
</body>
<script language="javascript">
	function findUserById () {
		var e=window.event||arguments.callee.caller.arguments[0];
		var v = document.getElementById("uid").value;
		if(e.keyCode==13){
			window.self.location = "/user/findUserById?uid="+v;
		}
	}
</script>
</html>