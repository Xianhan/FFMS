/**
 * 创建用户时判断用户名是否存在
 */
	window.onload=function(){

         var user= document.getElementById('uname');
         var sub=document.getElementById('submit');
user.onblur=function(){
var b;
$.ajax({
    url:'../IfUserExist?username='+user.value,
    type:'POST', //GET
    async:false,    //或false,是否异步
    timeout:5000,    //超时时间
    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
    success:function(data){
   	
    	 b=data;
    }, 
})
if(b=="false"){
	alert('该用户名已存在');
	sub.disabled=true;
}
else{
	sub.disabled=false;
}
}
}