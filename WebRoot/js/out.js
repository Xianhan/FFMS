function check(){

var start=document.getElementById('start').value;
var end=document.getElementById('end').value;


$.ajax({
    url:'../../WriteOutExcelAction?startDate='+start+'&endDate='+end,
    type:'POST', //GET
    async:false,    //或false,是否异步
    timeout:5000,    //超时时间
    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
    success:function(data){
    	alert(data);
    	if(data=='ok');
    	alert('导出成功');
    }, 
})
return false;
}
