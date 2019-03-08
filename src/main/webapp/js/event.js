var picture = null;
$(function(){
	/** 验证文件是否导入成功  */
	$("#form").ajaxForm(function(url){  
			picture = url;
			console.log(url);
	});     
});


function sureUpdateNote() {
	// 被选中的超链接的父辈是li，而并非ul
						//	var $li = $("#note_list li a.checked").parent();
						//	if ($li.length == 0) {
						//		alert("要先选择是哪个笔记哦！");
						//	} else {
						// 获取笔记的id
						//var $div = $("#pc_part_3");
						//var noteId = $div.date("noteId");
//		var noteId = $("#pc_part_3").data("noteId");
//		var noteBookId = $("#pc_part_3").data("bookId");
						//var noteId = $li.data("noteId");
		// 获取笔记标题
		//var categories = $("#categories").val().trim();
		var price = $("#price").val().trim();
		var start = $("#start").val().trim();
		var lectures = $("#lectures").val().trim();
		var organizer = $("#organizer").val().trim();
		var address = $("#address").val().trim();
		// 获取笔记内容
		var body = ue.getContent();
//		//刷新列表
//		$("#book_ul li a").removeClass("checked");
//		//遍历列表对更改的笔记 本 设置选中效果
//		$("#book_ul").find("li").each(function () {
//            var notebook = $(this);
//            var notebookid = notebook.data("bookId");
//            if (notebookid == noteBookId) {
//            	$(this).find("a").addClass("checked");// 设置选中效果
//            	$('#book_ul li a.checked').trigger('click');
//            }
//        });
		
		// 发送ajax请求
		$.ajax({
					url : "event/add",
					type : "post",
					data : JSON.stringify({
						"categories" : categories,
						"price" : price,
						"start" : start,
						"lectures" : lectures,
						"organizer" : organizer,
						"address" : address,
						"body" : body,
						"picture" : picture
					}),
					dataType : "json",
					contentType:"application/json;charset=UTF-8",
					success : function(result) {
						
						if (result.success == true) {
										// 获取新的标题放到note的li里
										// i标签是斜体字
										//var str = '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'
										//+ noteTitle
										//+ '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
										//$li.find("a").html(str);
							//遍历列表对更改的笔记设置选中效果
//							$("#note_list").find("li").each(function () {
//					            var note = $(this);
//					            var noteid = note.data("noteId");
//					            if (noteid == noteId) {
//					            	$(this).find("a").addClass("checked");// 设置选中效果
//					            }
//					        });
							// 提示成功
							alert(result.message);
						}
					},
					error : function(result) {
						alert(result.message);
					}
				});
	//}
};