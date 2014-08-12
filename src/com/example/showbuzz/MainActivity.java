package com.example.showbuzz;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button trailers,account,logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trailers = (Button) findViewById(R.id.trailersButton);
        account = (Button) findViewById(R.id.accountButton);
        logOut = (Button) findViewById(R.id.logOutButton);
        trailers.setOnClickListener(this);
        account.setOnClickListener(this);
        logOut.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==logOut){
			Intent i = new Intent(getApplicationContext(),LoginActivity.class);
			startActivity(i);
			finish();
		}else if(v==account){
			Intent i = new Intent(getApplicationContext(),AccountActivity.class);
			i.putExtra("username","Maverick");
			i.putExtra("fName","Georgi");
			i.putExtra("lName","Terziyski");
			i.putExtra("email","Maverick@showbuzz.com");
			startActivity(i);
		}else if(v==trailers){
			Intent i = new Intent(getApplicationContext(),TrailerActivity.class);
			startActivity(i);
		}
	}
    
}
