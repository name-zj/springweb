<script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>

<style type="text/css">
	#top{
		height:70px;
		text-align:center;
	}
	#top font{
		font-weight:bold;
		font-size:27px;
		line-height:70px;
		font-family:"KaiTi";
	}
	.addtable{
		width:1000px;
	}
	table{
		margin:60px;
		font-size:18px;
	}
	table font{
		font-size:18px;
	}
	.shuru{
		height:33px;
		width:190px;
		margin:4px 5px;
		font-size:18px;
	}
	.tianjia{
		height:30px;
		width:89px;
		margin:4px 5px;
		color:#FFFFFF;
		background-color:#444444;
		border:none;
		cursor:pointer;
	}
	.tianjia:hover{
		background-color:#111111;
	}
</style>

	<div id="top">
		<font color="#59D78D">更新用户信息</font>
	</div>
	<div class="addtable">
		<form action="/user/updateUser" method="post">
			<table class="table table-striped" align="center">
			<tbody>
			    <tr>
            		<td><font>Id</font></td>
            		<td>
                    <input type="text" name="id" class="shuru" value="${user.id}" readonly="readonly">
                    </td>
            	</tr>
				<tr>
					<td><font>用户名</font></td>
					<td>
						<input type="text" name="username" class="shuru" value="${user.username}">
					</td>
				</tr>
				<tr>
					<td><font>密码</font></td>
					<td>
						<input type="text" name="password" class="shuru" value="${user.password}">
					</td>
				</tr>
				<tr>
                    <td><font>角色</font></td>
                    <td>
                        <#list roles as roleItem>
                            <#if (user.roleName) == (roleItem.rolename)>
                                <input type="radio" name="roleId" value="${(roleItem.id)!}" checked/>
                            <#else>
                                <input type="radio" name="roleId" value="${(roleItem.id)!}"/>
                            </#if>
                            ${(roleItem.rolename)!}
                        </#list>
                    </td>
                    </tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="确认更改" class="tianjia">
						<input type="button" value="取消更改" class="tianjia" onclick="cancel()">
					</td>
				</tr>
				</tbody>
			</table>
		</form>
	</div>
<script type="text/javascript">
	function cancel(){
		location.href="/user/allUserView";
	}

</script>