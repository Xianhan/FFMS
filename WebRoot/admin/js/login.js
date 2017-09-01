function check(){

var username=document.getElementById('username').value;
var password=document.getElementById('password').value;
var b;
$.ajax({
    url:'SelectUserAction?username='+username+'&password='+password,
    type:'POST', //GET
    async:false,    //或false,是否异步
    timeout:5000,    //超时时间
    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
    success:function(data){
    	b=data;
    }, 
})

if(b=='admin'){
	window.location.href="http://localhost:8888/FFMS/admin/index.html"; 
	return false;
}
else if(b=='user'){
	window.location.href="http://localhost:8888/FFMS/index.html"; 
	return false;
}
else{
	alert('用户名或密码错误');
	return false;
}
}
