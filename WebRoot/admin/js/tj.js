function tj(){
		var sel=$("#typesel").val();
		if(sel==1||sel==2){
			var sel1=("#sel1").val();
			$.ajax(
				{
					type : "post",
					url : "addtopimg",
					data : "type=1&param="+sel1,// 要提交的表单 
					dataType : "text",
					error : function()
					{
						//alert("表单提交失败");
					},
					success : function(data)
					{
					alert(data);
						if (data == 'OK')
						{
							alert("新增图片成功");
							window.self.location.href="appindex?type=1";
						}
					}
				});
		}
		if(sel==3){
			var url=$("#textbox1").val();
		}
		
	}