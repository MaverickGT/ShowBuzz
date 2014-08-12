package com.example.showbuzz;

import org.json.JSONException;
import org.json.JSONObject;

import Controler.UserFunctions;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity   implements OnClickListener {
	
	

	
	
	private TextView forgotPass;
	private String text;
	private Button btnLogin,btnRegister,create,cancel;
	private EditText passwordField, usernameField,repeatPassword;
	public String Status;
	Dialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		    forgotPass = (TextView) findViewById(R.id.forgotPass);
		    text = "<a href = http://www.google.com>Forgot your password ?</a>";
		    forgotPass.setMovementMethod(LinkMovementMethod.getInstance());
		    forgotPass.setText(Html.fromHtml(text));
		    btnLogin = (Button) findViewById(R.id.loginButton);
		    btnRegister = (Button) findViewById(R.id.registerButton);
		    passwordField = (EditText) findViewById(R.id.passwordText);
		    usernameField = (EditText) findViewById(R.id.usernameText);
		    btnLogin.setOnClickListener(this);
		    btnRegister.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==btnLogin){
			try {
				checkLogin();
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(v==btnRegister){
			register();
		}else if(v==create){
			
			if(checkPasswords(passwordField.getText().toString(),repeatPassword.getText().toString())){
				
				
				
				
				try {
					createAccount();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Toast toast  = Toast.makeText(this,R.string.success	, Toast.LENGTH_LONG);
				toast.setGravity(Gravity.CENTER, -30, 50);
				toast.show();
				//here we have to add the create account in database
				
				
				
				dialog.dismiss();
			}else{
				dialog.dismiss();
				Toast toast = Toast.makeText(this, R.string.incorrect, Toast.LENGTH_LONG);
				toast.setGravity(Gravity.CENTER, -30, 50);
				toast.show();
				register();
			}
		}else if(v==cancel){
			dialog.dismiss();
		}
	}
	
	private void createAccount() throws JSONException {
		
		UserFunctions info = new UserFunctions();
		
		JSONObject data = info.RegisterAccount(usernameField.getText().toString(), passwordField.getText().toString());
		
		Status = data.get("results").toString();
		
		if(Status.equalsIgnoreCase("query success")){
			
			
			 Intent i = new Intent(LoginActivity.this, MainActivity.class);
		     startActivity(i);
			
				
			}else{
				Toast toast = Toast.makeText(this, "User with this Account name already exsists try another", Toast.LENGTH_LONG);
				toast.setGravity(Gravity.CENTER, -30, 50);
				toast.show();
				
			}
		
	}
	
	
	
	
	
	private void checkLogin() throws NotFoundException, JSONException{
		//check if the credentials are matching with the DB
		UserFunctions info = new UserFunctions();

		JSONObject data = info.LoginConfirmation(usernameField.getText().toString(), passwordField.getText().toString());
		
		Status = data.get("results").toString();

		if(Status.equalsIgnoreCase("query success")){
			
		 Intent i = new Intent(LoginActivity.this, MainActivity.class);
	     startActivity(i);
		}else{
			Toast toast = Toast.makeText(this, R.string.wrongUser, Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, -30, 50);
			toast.show();
			
		}
	}

	private void register(){
		dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setTitle(R.string.repeat_password);
        repeatPassword=(EditText)dialog.findViewById(R.id.repeatText);
        create=(Button)dialog.findViewById(R.id.createAccount);
        create.setOnClickListener(this);
        cancel=(Button)dialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
        dialog.show();
		
	}
	private boolean checkPasswords(String pass, String repeatPass){
		if(pass.equals(repeatPass)){
			return true;
		}else{
		return false;
		}
	}
	


}
