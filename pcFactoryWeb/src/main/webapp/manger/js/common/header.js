$(function(){
	layui.use(['table',"layer","form",], function(){
		
		var table = layui.table;
		var layer = layui.layer;
		var form = layui.form;
		
		$('.header_mune').on('click', function(){   
	        console.log( $(this) );    
	    });  
		
		$('.header_mune').click(function(){
			if( $(this).hasClass('back') ){	
				$(this).attr('disabled','disabled');
				$(this).removeClass('back');
				$('.sub_mune_item').removeClass('show');
			}else{
				$(this).addClass('back');
			}
		});
		
		$('.sign_out').click(function(){
			layer.open({
				type:1,    	
				area:['300px','200px'],
				content:'<div style="position:absolute;top:50%;left:25%;font-size:18px">确定要退出系统吗<i class="layui-icon layui-icon-help"></i></div>',
				title:'系统提示',
				btn: ['确定', '返回'],
				yes:function(index,layero){
					$.ajax({
						type : 'POST',
						url : './loginOut',
						dataType : 'json',
						success : function(data){
							if(data.success){
								layer.close(index);
								layer.msg(data.msg);
								setTimeout(function(){
									window.location.href="./index";
								},2000);
							}else{
								layer.msg(data.msg);
							}
						}
					});
					layer.close(index);
					return false;
				}
			});
		});
		
		
		$('.revise_pwd').click(function(){
			layer.open({
				type : 2,				
				title : '修改密码',
				btnAlign: 'c',
			  	content: './changePwd.jsp',
			  	btn : ['确定','取消'],
			  	area : ['350px','335px'],
			  	yes : function(index, layero){
			  		var body = layer.getChildFrame('body',index);//建立父子联系
		            var iframeWin = window[layero.find('iframe')[0]['name']];
		           	iframeWin.updatePassword();
			  	},
			  	success:function(layero,index){
			  		var body = layer.getChildFrame('body', index);
			  	    var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
			  	    iframeWin.updatePassword();
			  	}
			});
		});
		
	});
	
});
