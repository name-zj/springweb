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
		<font color="#59D78D">更新角色信息</font>
	</div>
	<div class="addtable">
		<form action="/role/updateRole" method="post">
			<table class="table table-striped" align="center">
			<tbody>
			    <tr>
                    <td><font>Id</font></td>
                    <td>
                    <input type="text" name="id" class="shuru" value="${role.id}" readonly="readonly">
                    </td>
                </tr>
				<tr>
					<td><font>角色名</font></td>
					<td>
						<input type="text" name="rolename" class="shuru" value="${role.rolename}">
					</td>
				</tr>
				<tr>
					<td><font>可读</font></td>
					<td>
					    <#if 1 == (role.isRead)>
                            <input type="radio" name="isRead" value="1" checked/>1
                            <input type="radio" name="isRead" value="0"/>0
                        <#else>
                            <input type="radio" name="isRead" value="1"/>1
                            <input type="radio" name="isRead" value="0" checked/>0
                        </#if>
					</td>
				</tr>
				<tr>
                    <td><font>可写</font></td>
                    <td>
                        <#if 1 == (role.isWrite)>
                            <input type="radio" name="isWrite" value="1" checked/>1
                            <input type="radio" name="isWrite" value="0"/>0
                        <#else>
                            <input type="radio" name="isWrite" value="1"/>1
                            <input type="radio" name="isWrite" value="0" checked/>0
                        </#if>
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
		location.href="/role/findAllRole";
	}

</script>