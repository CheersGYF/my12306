<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 标签指令 ： prefix是标签前缀 ， uri是标签的标志符 -->
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- 
	jsp 语法之标签库：jstl - jsp标准标签库 - 由Sun公司提供 包含了5个标签库；
	core 核心标签库、  fmt 格式化标签库 、 function 函数标签库、 sql 标签库、 xml标签库
	1. 下载标签库 jstl maven  把库文件添加到web-INF/lib目录中
	2. 在jsp 页面当中引入标签库
	3. 在jsp页面中使用标签库进行编程  // ait+?
 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册信息</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
<!-- 
	js 框架使用步骤
	 1.下载js文件库，添加到项目工程中
	 2. 使用script 标签引入js库文件
	 3. 在script代码块或js文件中，调用js库进行编程
	 // 表单校验方法
		function checkForm(){
			// 要根据校验结果返回true或false 返回true表示校验成功，返回false表示校验失败
			return false;
		}
	 4. 当我们点击提交按钮时，如果校验通过则把表单的数据发送到action指定的服务器中进行处理
	 	如果校验失败则不会提交表单，需要提示用户修正输入错误，进行再次提交
 -->
 <script type="text/JavaScript" src="js/jquery-1.11.1.min.js"></script>
 <script type="text/JavaScript" src="js/laydate/laydate.js"></script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<!--
	1. 在页面中进行表单校验，使用在点击提交按钮，进行提交数据到服务器前进行的
	2. 经常的可以在 1）提交按钮submit上监听onclick事件，2）或在form标签上监听onsubmit事件
		3）如果form表单内部不使用submit按钮提交则可以使用javascript进行提交表单 或使用ajax提交数据到服务器
 -->
 <!-- 
 表单校验的思路：
 	1. 在表单中使用submit按钮提交表单
 	2. 在form标签上监听onsubmit事件，在提交事件中调用表单校验方法，并使用return语句接收校验方法的返回值
 	3. 编写校验方法时根据校验结果，需要返回true或false
 	
  -->
  

<form  name="regForm" action="RegServlet?op=doreg" method="post" onsubmit="return checkForm()">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="2" background="images/ny_top_img_bg.gif"><img src="images/ny_top_img.gif" width="650" height="108"></td>
    </tr>
  <tr>
    <td width="75" height="23" bgcolor="#deedf8">&nbsp;</td>
    <td width="958" align="left" bgcolor="#deedf8" class="text_cray1">当前位置:注册信息　</td>
    </tr>
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="images/bg_point_write.gif"><table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="30" colspan="2" align="center">&nbsp;</td>
        </tr>
      <tr>
        <td width="41" height="7" align="center">&nbsp;</td>
        <td width="794" height="30" align="left" valign="top"><span class="text_blod_title">注册信息</span></td>
      </tr>
      <tr>
        <td height="15" colspan="2" align="center"><img src="images/line1.jpg" width="835" height="6"></td>
      </tr>
      <tr>
        <td colspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="5%">&nbsp;</td>
            <td width="95%" align="left" class="text_cray">注：标有 <span class="text_red">*</span> 处，均为必填项</td>
          </tr>
          <tr>
            <td height="15" colspan="2">&nbsp;</td>
            </tr>
          
        </table>
          <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="30" colspan="4" align="left" class="text_red1"><span class="text_title">登录信息</span></td>
                </tr>
          
          <tr>
            <td width="19" align="center" class="text_red">*</td>
                  <td width="98" height="40" align="left" class="text_cray1">登录名：</td>
                  <td width="160" align="left" class="text_cray1"><input name="userName" type="text" class="text_cray" id="userName" /></td>
                  <td width="423" height="35" align="left" class="text_cray" id="userNameInfo">由字母、数字或“_”组成，长度不少于6位，不多于30位</td>
                </tr>
          <tr>
            <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">密码：</td>
                  <td align="left" class="text_cray1"><input name="password" type="text" class="text_cray" id="password" /></td>
                  <td height="35" align="left" class="text_cray" id ="passwordInfo">不少于6位字符</td>
                </tr>
          <tr>
            <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">确认密码：</td>
                  <td align="left" class="text_cray1"><input name="password2" type="password" class="text_cray" id="password2" /></td>
                  <td height="35" align="left" class="text_cray" id="password2Info">请再次输入密码</td>
                </tr>
        </table>
          <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td height="35" colspan="5" align="left" class="text_red1"><span class="text_title">详细信息</span></td>
                </tr>
            
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">真实姓名：</td>
                  <td height="35" colspan="2" align="left"><input name="realName" type="text" class="text_cray" id="realName" /></td>
              	<td height="35" align="left" class="text_cray" id="realNameInfo"> </td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">性 别：</td>
                  <td height="35" colspan="3" align="left" class="text_cray1">
                    <span class="mr25">
                    <input type="radio" name="sex" value="1" checked="checked" />
                    </span>
                    <span class="text_cray">
                    <label>男</label>
                    <input type="radio" name="sex" value="2" />
                    <label>女</label>
                    </span>
                    <label></label>
                    <span><label></label>
                  </span>				</td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">省份：</td>
                  <td width="104" height="35" align="left"><label>
                  
                  
                    <select name="province" class="text_cray" id="province">
                      <option value="省份" selected="selected">省份</option>
                      <!-- 3w1h -->
                      <!-- 使用循环迭代标签+ el 表达式（items = "$"{}）进行循环参数 -->
                      <c:forEach items="${province}" var="oneProvince">
                      	<option value="${oneProvince.provinceId}"> ${oneProvince.province}</option>
                      </c:forEach>
                    </select>
                    
                  </label>
                  </td>
                  <td width="43" height="35" align="left"  class="text_cray">城市：</td>
                  <td width="436" height="35" align="left" class="text_cray"><label>
                    <select name="city" class="text_cray" id="city">
                      <option value="城市" selected="selected">市县</option>
                    </select>
                    <b width="43" height="35" align="left" class="text_cray" id ="cityInfo" > </b>
                  </label>
                  </td>
                  
                </tr>
            <tr>
            
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">证件类型：</td>
                  <td height="35" colspan="3" align="left">
                    <select class="text_cray" name="certType" id="certType">
                   <c:forEach items="${certType}" var="oneCertType">
                    	<option value="${oneCertType.id }">${oneCertType.content}</option>	
                    </c:forEach>
                  </select>				
                 </td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">证件号码：</td>
                  <td height="35" colspan="2" align="left"><input name="cert" type="text" class="text_cray" id="cert" /></td>
                  <td height="35" align="left" class="text_cray" id =certInfo ></td>
                  
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">出生日期：</td>
                  <td height="35" colspan="2" align="left"><input name="birthday" type="text" class="text_cray" id="birthday" /></td>
                  <td height="35" align="left" class="text_cray" id =birthdayInfo ></td>
                </tr>
            
            <tr>
              <td width="19" align="center">&nbsp;</td>
                  <td width="98" height="40" align="left" class="text_cray1">旅客类型：</td>
                  <td height="35" colspan="3" align="left">
                    <select class="text_cray" id="userType" name="userType">
                   
                     <c:forEach items="${userType}" var="oneUserType">
                    	<option value="${oneUserType.id}">${oneUserType.content}</option>
                    </c:forEach>
                    
                    	
                  </select>				
               	</td>
                </tr>
            <tr>
              <td height="10" colspan="5" align="center">	</td>
	        </tr>
            
            <tr>
              <td width="19" align="center">&nbsp;</td>
                  <td width="98" height="30" align="left" class="text_cray1">备注：</td>
                  <td colspan="3" align="left" height="80">
                  <textarea name="content" rows="8" class="text_cray" style="width:100%"></textarea>				</td>
            </tr>
            
            <tr>
              <td align="center">&nbsp;</td>
                  <td height="30" align="left" class="text_cray1"></td>
                  <td height="50" colspan="3" align="left" valign="middle" class="text_cray1">
                  <input type="checkbox" class="check" id="checkAgree" /> 
                  我已阅读并同意遵守 <a href="/otn/regist/rule;jsessionid=FA97B306AACF75E37DD4D10CFD59994A" class="ft14" target="_blank" shape="rect"> 《中国铁路客户服务中心网站服务条款》</a>
                  <b height="30" align="left" class="text_cray1" id = "checkAgreeInfo"></b>
                  </td>
                  
                </tr>
          </table> 
          <br>
          <table width="835" border="0"align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="234">&nbsp;</td>
                  <td width="147" height="30" align="center"><input name="button3" type="submit" class="buttj" id="button3" value=""></td>
                  <td width="141" align="center">&nbsp;</td>
                  <td width="147" align="center"><input name="button4" type="reset" class="butcz" id="rest" value=""></td>
                  <td width="166" align="center">&nbsp;</td>
                </tr>
              </table>
              </td> 
     </tr>
      </table></td>
  </tr>
</table><br>

<table width="100%" border="0" cellspacing="0">
<tr>
    <td height="2" background="images/bottom_point.gif"></td>
  </tr>
  <tr>
    <td height="25" align="center" background="images/bottom_ny_bg.gif" class="text_cray">copyright@12306 购票网</td>
  </tr>
</table>
</form>

	<!-- 
	// 不使用静态js加载省市信息，改成从哪个数据库查询
	<script type="text/JavaScript" src="js/common.js"></script> -->
	<script type="text/JavaScript">
		// jquery框架提供了多种对象选择器，可以帮助快速查询网页对象：html dom对象
		// 提供了快速进行事件绑定的方法
		// document.getElementById("provice");
		
		$("#province").change(function(){
			// 取出当前选中的省份编号
			var provinceId = $("#province").val();
			
			//alert(provinceId);
			$.post("RegServlet",{op:"city",pid:provinceId},function(data){
				//alert(date);
				// 解析json有两种方法，把对象转换成json字符串 使用JSON.stringify(data)
				// 把json字符串转化为js对象使用eval()
				//alert(JSON.stringify(data));
				JSON.stringify(data);
				// 把返回的城市信息绑定到城市下拉框
				// 1. 清除原有信息
				$("#city").empty();
				// 2. 绑定新的信息
				$(data).each(function(index,el){
					$("#city").append("<option value = '"+el.id+"'>"+el.city+"</option>");
				});
			});
		});
		
		// 判断用户名格式的方法
		function isRegisterUserName(s){  
			var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[_]){5,29}$/;  
			if (!patrn.exec(s)) {return false}
			return true
		}
		//判断密码
		function isPasswordLength(p){
			var pword = /^.{6,}$/;
			if (!pword.exec(p)) {return false}
			return true
		}
		// 检查用户名是否已经存在
		$("#userName").blur(function(){
			// 1. 取当用户输入的账号
			// 2.使用js检查账号是否满足要求 - js 表单校验
			// 可以使用正则表达式进行表达
			//^[a_zA-Z0_9\_]{6,30}$
			// 3.向服务器发送ajax异步请求，在服务端检查账号是否可用
			// 4.在ajax的回调函数中，根据服务器返的结果，修改页面内容，提示用户操作
			var userName = $("#userName").val();
			$("#userNameInfo").empty();
			if(isRegisterUserName(userName)){
				$.post("RegServlet?"+new Date().toString(),{op:"checkname",uName:userName},function(data){
					alert(JSON.stringify(data));
					if(data){
						//$("#userNameInfo").html("此用户可以使用！")
						$("#userNameInfo").append("<td>此用户名可以使用！</td>");
						$("#userNameInfo").css("color","green");
					}else{
						$("#userNameInfo").append("<td>此用户名已经被注册，请重新输入！</td>");
						$("#userNameInfo").css("color","red");
					}
				});
			}else{
				$("#userNameInfo").append("<td>格式错误，请输入字母、数字或“_”，长度不少于6位，不多于30位！</td>");
				$("#userNameInfo").css("color","red"); 
				//alert(userName);
			}
		});
		
		// 判断密码是否符合长度大于6
		
		$("#password").blur(function(){
			var pword = $("#password").val();
			$("#passwordInfo").empty();
			// 判断密码长度
			//alert(pword);
			if(isPasswordLength(pword)){
				// 长度大于5符合要求输出判断结果提示
				$("#passwordInfo").html("密码符合要求可以使用");
				$("#passwordInfo").css("color","green")
			}else{
				$("#passwordInfo").html("密码不安全，请重新输入不小于6位字符");
				$("#passwordInfo").css("color","red");
			}
		});
		
		//判断重新输入的密码是否与原密码相同
		
		$("#password2").blur(function(){
			var pword = $("#password").val();
			var pword2 = $("#password2").val();
			$("#password2Info").empty();
			// 判断密码长度
			//alert(pword);
			if(pword==pword2){
				// 长度大于5符合要求输出判断结果提示
				$("#password2Info").html("密码输入正确！");
				$("#password2Info").css("color","green")
			}else{
				$("#password2Info").html("两次输入密码不相同，请检查！");
				$("#password2Info").css("color","red");
			}
		});
		
		// 对输入的姓名进行规制判断 必须是汉字或英文字母
		$("#realName").blur(function(){
			var realname = /^[\u4E00-\u9FA5A-Za-z]+$/;
	       	//console.log($("#realName").val())
	       	$("#realNameInfo").empty();
	       	if(!realname.test($("#realName").val())){
	        	$("#realNameInfo").text(" 请输入英文或者汉字");
	        	$("#realNameInfo").css("color","red");
	       	}else{
	        	$("#realNameInfo").text("");
	       	}
        });
		// 对证件号的合法性进行验证
		$("#cert").blur(function(){
			var certType = $("#certType").val();
			// alert($("#certType").val());
			$("#certInfo").empty();
	       	if(certType == "1" ){
	       		var re =/^\d{6}(19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])\d{3}(\d|[xX])$/;
	       		if(!re.test($("#cert").val())){
	       			$("#certInfo").html(" 证件号码或类型有误，请重新输入！");
					$("#certInfo").css("color","red")
	       		}
	       	}else if(certType== "2"){
	       		var ga =/^[HMhm]{1}([0-9]{10}|[0-9]{8})$/;
	       		if(!ga.test($("#cert").val())){
	       			$("#certInfo").html(" 证件号码或类型有误，请重新输入！");
					$("#certInfo").css("color","red")
	       		}
	       	}else if(certType== "3"){
	       		var tw = /^[0-9]{8}$/
	       		var tw2=/^[0-9]{10}$/;
	         	if(!(tw.test($("#cert").val())|tw2.test($("#cert").val()))){
	       			$("#certInfo").html(" 证件号码或类型有误，请重新输入！");
					$("#certInfo").css("color","red")
	       		}
	       	}else{
	       	 var hz = /^[a-zA-Z]{5,17}$/
	       	 var hz2 = /^[a-zA-Z0-9]{5,17}$/;
	         if(!(hz.test($("#cert").val())|hz2.test($("#cert").val()))){
	       			$("#certInfo").html(" 证件号码或类型有误，请重新输入！");
					$("#certInfo").css("color","red")
	       		}
	       	}
        }); //end
        
     
        
        $("#birthday").blur(function(){
        	//字符串转日期格式，strDate要转为日期格式的字符串
            function getDate(strDate){
              var date = eval('new Date(' + strDate.replace(/\d+(?=-[^-]+$)/, 
               function (a) { return parseInt(a, 10) - 1; }).match(/\d+/g) + ')');
              return date;
            }
            
            var date =$("#birthday").val();
            //alert(date);
            var date2=getDate(date);
        	// 判断出生日期格式
	      	//alert(date2);
	      	//alert(new Date())
	      	$("#birthdayInfo").empty();
	      	if(date.length>0){
	    	  	if(!( date2 <= new Date())){
	  	        	$("#birthdayInfo").html("请输入正确的出生日期！")
	  	        	$("#birthdayInfo").css("color","red")
	  	      }
	      }else{
	    	  	$("#birthdayInfo").html("请输入出生日期！")
	        	$("#birthdayInfo").css("color","red")
	      }
	        
        });
		//执行一个laydate实例
		laydate.render({
		  elem: '#birthday' //指定元素
		});
		
		// 表单校验方法
		function checkForm(){
			var ret = true;// 默认校验通过
			// 要根据校验结果返回true或false
			// 返回true表示校验成功，返回false表示校验失败
			// 表单组件的访问可以使用多种方法：document.getElecmentById();
			// document.form表单名.input组件名.value; - 获取表单组件的值
			//判断用户名是否填写
			if(!($("#userName").val().length>0)){
				
				ret= false;
				$("#userNameInfo").empty();
				$("#userNameInfo").append("<td>用户名不能为空！</td>");
				$("#userNameInfo").css("color","red"); 
			}
			// 判断密码是否为空
			if(!($("#password").val().length>0)){
				ret= false;
				$("#passwordInfo").empty();
				$("#passwordInfo").html("密码不能为空！");
				$("#passwordInfo").css("color","red");
			}
			//重新输入密码不能为空
			if(!($("#password2").val().length>0)){
				ret= false;
				$("#password2Info").empty();
				$("#password2Info").html("请再次输入密码！");
				$("#password2Info").css("color","red");
			}
			// 判断真实姓名是否为空
			if(!($("#realName").val().length>0)){
				ret= false;
				$("#realNameInfo").empty();
				$("#realNameInfo").text("真实姓名不能为空！");
	        	$("#realNameInfo").css("color","red");
			}
			// 判断证件编号是否填写
			if(!($("#cert").val().length>0)){
				ret= false;
				$("#certInfo").empty();
				$("#certInfo").html("请填写证件编号！");
				$("#certInfo").css("color","red");
			}
			//出生日期不恩能够为空
			if(!($("#birthday").val().length>0)){
				ret= false;
				$("#birthdayInfo").empty();
				$("#birthdayInfo").html("请输入出生日期！");
  	        	$("#birthdayInfo").css("color","red");
			}
			// 所在城市不能为空
			if($("#province").val()=="省份"){
				ret= false;
				$("#cityInfo").empty();
				$("#cityInfo").html("请选择城市信息！");
  	        	$("#cityInfo").css("color","red");
			}
			// 铁路条款服务选项
			if($("#checkAgree").val() == null){
				alert();
				ret= false;
				alert($("#checkAgree").val());
				$("#checkAgreeInfo").empty();
				$("#checkAgreeInfo").html("请同意协议！");
  	        	$("#checkAgreeInfo").css("color","red");
			}
			return ret;
		}
		
	</script> 
	
</body>
</html>
