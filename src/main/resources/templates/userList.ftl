<script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
<style type="text/css">
.tb {
	padding: 40px 100px 10px;
	font-size: 17px;
}
table {
	table-layout: fixed;
	width: 100%;
}
.table th, .table td {
text-align: center;
vertical-align: middle!important;
}
td {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
table #amend {
	background: url(imgs/change4.png) no-repeat;
	cursor: pointer;
}
table #amend:hover {
	background: url(imgs/change3.png) no-repeat;
}
table #del {
	background: url(imgs/del3.png) no-repeat;
	cursor: pointer;
}
table #del:hover {
	background: url(imgs/del4.png) no-repeat;
}
label{
	font-size:15px;
}
.tb{
	overflow-y:auto;
	overflow-x:hidden;
	width:100%;
	height:570px;
}
.paging{
	margin-left:890px;
}

</style>
<div class="tb">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>序号</th>
				<th>姓名</th>
				<th>密码</th>
				<th>角色</th>
				<th class="ifShow">更新</th>
				<th class="ifShow">删除</th>
			</tr>
		</thead>
		<tbody>
		    <#list users as useritem>
				<tr>
					<td>${(useritem.id)!}</td>
					<td>${(useritem.username)!}</td>
					<td>${(useritem.password)!}</td>
					<td>${(useritem.roleName)!}</td>
					<td class="ifShow"><a href="updateUserView?id=${(useritem.id)! }">更新</a></td>
					<td class="ifShow"><a href="logicDeleteUserById?id=${(useritem.id)! }">删除</a></td>
				</tr>
			</#list>
		</tbody>
	</table>
</div>

<div class="paging layui-inline">
    <a href="allUserView?pageFlag=previousPage">上一页</a>
    <a href="allUserView?pageFlag=nextPage">下一页</a>
    <input type="button" class="btn btn-success" onclick="addUser()" value="添加用户">
</div>

<script type="text/javascript">
	function addUser(){
		location.href="/user/addUserView";
	}
</script>