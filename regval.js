function validate_form()
	{
		var name=document.getElementById('name').value;
		var email=document.getElementById('email').value;
		var password=document.getElementById('password').value;
		var phone=document.getElementById('phone').value;
		
		var valid_name=/^[ a-zA-Z]+$/;
		var valid_email=/^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;
		var valid_password=/^([a-zA-Z0-9!@$%&*]{8,})+$/;
		var valid_phone=/^([+0-9]{1,3})?([0-9]{10,11})$/;
		
		if(name=='')
		{
			alert("Please Enter Name");
			return false;
		}
		else if(!valid_name.test(name))
		{
			alert("Please Enter Alphabet");
			return false;
		}
		if(email=='')
		{
			alert("Please Enter email");
			return false;
		}
		else if(!valid_email.test(email))
		{
			alert("Please Enter valid email");
			return false;
		}
		if(password=='')
		{
			alert("Please Enter password");
			return false;
		}
		else if(!valid_password.test(password))
		{
			alert("Please Enter valid password");
			return false;
		}
		if(phone=='')
		{
			alert("Please Enter phone");
			return false;
		}
		else if(!valid_phone.test(phone))
		{
			alert("Please Enter valid phone");
			return false;
		}
	}