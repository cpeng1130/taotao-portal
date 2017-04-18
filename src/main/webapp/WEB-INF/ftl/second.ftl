<html>
	<head>
		<title>${title}</title>
	</head>
	<body>
		<label> No:</label>${student.id}<br>
		<label>name:</label>${student.name}<br>
		<label>address:</label>${student.address}<br>
		
		Student List:
		<table border="1">
		<#list students as s>
		<#if s_index %2 == 0>
		<tr style="color:red">
		<#else>
		<tr>
		</#if>>
			<td>${s_index}</td>
			<td>${s.id}</td>
			<td>${s.name}</td>
			<td>${s.address}</td>
		</tr>
		</#list>
		</table>
		<br>
		current time: ${curdate?date}<br>
		current time: ${curdate?time}<br>
		current time: ${curdate?datetime}<br>
		current time: ${curdate?string("yyyy/MM/dd HH:mm:ss")}<br>
	</body>
	
</html>