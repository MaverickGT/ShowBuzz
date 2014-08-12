package com.example.showbuzz;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.VideoView;

public class MediaPlayer extends Activity {
	private static final String MovieUrl = "http://polisciuk.com/trailers/";
	TrailerActivity mov =new TrailerActivity();
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_player);
	        
	        Intent intent= getIntent(); // gets the previously created intent
	        String value = intent.getStringExtra("key");
	  
	       startMedia(value);
	       
	    }


	private void startMedia(String movie) {
		
		VideoView vid = (VideoView) findViewById(R.id.videoView);
		
		Uri video = Uri.parse(MovieUrl+movie+".mp4");
  		vid.setMediaController(null);
		vid.setVideoURI(video);

		vid.start();
		vid.requestFocus();
	}


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }

}
