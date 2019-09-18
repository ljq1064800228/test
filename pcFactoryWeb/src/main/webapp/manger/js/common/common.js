$(function(){	
	layui.use(['layer', 'form'], function(){
	  var layer = layui.layer
	  ,form = layui.form;
	  
	  //关闭遮罩
	  $('.covers').click(function(event){	
		$('.covers_wrap').stop().fadeOut(300);
	  	$('.covers').stop().fadeOut(300);
	  	$('body').removeClass('nosc');
	  });
	  // 阻止冒泡
	  $('.covers_wrap').click(function(event){	
	  	event.stopPropagation();
	  });
	  
	  //多选
		$('.sort_input').click(function(){
			if($(this).attr('ischecked') == 'true'){
				$(this).attr('ischecked','false');
			}else{
				$(this).attr('ischecked','true');
			}
		});
	
		//多选
		$('body').on('click','input[type=checkbox]', function(){
			var id = $(this).attr('id');
			
			if( $(this).is(':checked') ){ //点击后是选择状态
				if( $(this).attr('isallcheck') ){
					$(this).attr({'checked':true ,'isallcheck':true});
					$('label[for='+ id +']').attr('isallcheck',true);
				}else{
					$(this).attr({'checked':true ,'ischecked':true});
					$(this).siblings().attr('ischecked',true);
					$('label[for='+ id +']').attr('ischecked',true);
				}
			}else{ 
				//点击后是非选择状态
				if( $(this).attr('isallcheck') ){
					$(this).attr({'checked':false ,'isallcheck':false});
					$('label[for='+ id +']').attr('isallcheck',false);
				}else{
					$(this).attr({'checked':false ,'ischecked':false});
					$(this).siblings().attr('ischecked',false);
					$('label[for='+ id +']').attr('ischecked',false);
				}
			}
		});
		
		//单选
		$('body').on('click', 'label input[type="radio"]', function(e){
			var name = $(this).attr('name');
			//单选
			if( $(this).is(':checked') ){
				$('label input[name='+ name +']').attr('ischoos','false');
				$(this).attr('ischoos','true');
			}
		});
		
		
	  
	  
	});
});