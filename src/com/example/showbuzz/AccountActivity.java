package com.example.showbuzz;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AccountActivity extends Activity implements OnClickListener {
	EditText username,fName,lName,email;
	Button resetPass;
	Bundle bundle;
	MenuItem edit, done;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);
		username = (EditText) findViewById(R.id.usernameAccount);
		fName = (EditText) findViewById(R.id.firstNameAccount);
		lName = (EditText) findViewById(R.id.lastNamrAccount);
		email = (EditText) findViewById(R.id.emailAccount);
		bundle = getIntent().getExtras();
		resetPass = (Button) findViewById(R.id.resetPassword);
		resetPass.setOnClickListener(this);
		if(bundle!=null){
			username.setText(bundle.getString("username"));
			fName.setText(bundle.getString("fName"));
			lName.setText(bundle.getString("lName"));
			email.setText(bundle.getString("email"));
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account, menu);
		edit = menu.findItem(R.id.action_edit);
		done = menu.findItem(R.id.action_done);
		edit.setVisible(true);
		done.setVisible(false);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    
	    switch (item.getItemId()) {
	        case R.id.action_edit:
	            changeFieldEditable("edit");
	            edit.setVisible(false);
	    		done.setVisible(true);
	            return true;
	        case R.id.action_done:
	        	changeFieldEditable("done");
	        	edit.setVisible(true);
	    		done.setVisible(false);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	private void changeFieldEditable(String command){
		if(command.equals("edit")){
			username.setClickable(true);
			username.setFocusable(true);
			username.setFocusableInTouchMode(true);
			username.setCursorVisible(true);
			username.requestFocus();
			fName.setClickable(true);
			fName.setFocusable(true);
			fName.setFocusableInTouchMode(true);
			fName.setCursorVisible(true);
			lName.setClickable(true);
			lName.setFocusable(true);
			lName.setFocusableInTouchMode(true);
			lName.setCursorVisible(true);
			email.setClickable(true);
			email.setFocusable(true);
			email.setFocusableInTouchMode(true);
			email.setCursorVisible(true);
		}else if(command.equals("done")){
			username.setClickable(false);
			username.setFocusable(false);
			username.setFocusableInTouchMode(false);
			username.setCursorVisible(false);
			fName.setClickable(false);
			fName.setFocusable(false);
			fName.setFocusableInTouchMode(false);
			fName.setCursorVisible(false);
			lName.setClickable(false);
			lName.setFocusable(false);
			lName.setFocusableInTouchMode(false);
			lName.setCursorVisible(false);
			email.setClickable(false);
			email.setFocusable(false);
			email.setFocusableInTouchMode(false);
			email.setCursorVisible(false);
		}
	}
	@Override
	public void onClick(View v) {
		if(v==resetPass){
			
		}
		
	}
}
