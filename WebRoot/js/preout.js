/**
 * 超出预支提醒功能
 */
window.onload = function() {


	var b = 'false';
	$.ajax({
		url : 'PreOutCompareAction',
		type : 'POST', //GET
		async : false, //或false,是否异步
		timeout : 5000, //超时时间
		dataType : 'text', //返回的数据格式：json/xml/html/script/jsonp/text
		success : function(data) {
			
			b = data;
		},
	})

	if (b == 'true') {
		alert('警告！！本月消费已超过预支的80%')
	}
}