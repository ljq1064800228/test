$(function(){	
		
		// 点击主菜单显示子菜单
		$('.main_mune dd').click(function(){	
			// 得到菜单下所有DD标签
			var dds = $('.main_mune').find('dd');
			// 删除所有的class
			for (var i = 0; i < dds.length; i++) {
				dds.eq(i).removeClass();
			}
			// 添加class样式
			$(this).attr('class','cur');
		});
		
		//点击子菜单返回按钮
		$('.sub_mune_item .layui-btn').click(function(){
			$('.header_mune').removeClass('back');
			$('.header_mune').attr('disabled','disabled');
			$(this).parent('.sub_mune_item').removeClass('show');
			$('body,html').scrollTop(0);
		});
		
		//子菜单点击效果
		$('.sub_mune dd').click(function(){
			$('.sub_mune dd').removeClass('cur');
			$(this).addClass('cur');
		});
		$('#detil').click(function(){	
			$('.main_in').load("./manger/page/kunlun/kunlunList.jsp");
		});
		
			
		
});
