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
				<th>角色名</th>
				<th>可读</th>
				<th>可写</th>
				<th>更新</th>
                <th>删除</th>
			</tr>
		</thead>
		<tbody>
		    <#list roles as roleitem>
				<tr>
					<td>${(roleitem.id)!}</td>
					<td>${(roleitem.rolename)!}</td>
					<td>${(roleitem.isRead)!}</td>
					<td>${(roleitem.isWrite)!}</td>
					<td><a href="updateRoleView?id=${(roleitem.id)! }">更新</a></td>
					<td><a href="deleteRoleById?id=${(roleitem.id)! }">删除</a></td>
				</tr>
			</#list>
		</tbody>
	</table>
</div>
<div class="paging layui-inline">
    <a href="findAllRoleByPageAndSize?pageRoleFlag=previousRolePage">上一页</a>
    <a href="findAllRoleByPageAndSize?pageRoleFlag=nextRolePage">下一页</a>
    <input type="button" class="btn btn-success" onclick="addRole()" value="添加角色">
</div>

<script type="text/javascript">
	function addRole(){
		location.href="/role/addRoleView";
	}
</script>

