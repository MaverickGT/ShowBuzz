package com.example.showbuzz;

import java.util.ArrayList;

import org.apache.commons.net.ftp.FTPClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class TrailerActivity extends Activity {
	
	private String[] asas;
	public String  itemValue;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_trailer);

		// get an ftpClient object  
		FTPClient ftpClient = new FTPClient();  

		try {  
			// pass directory path on server to connect  
			ftpClient.connect("ftp.polisciuk.com");  

			// pass username and password, returned true if authentication is  
			// successful  
			boolean login = ftpClient.login("polisciukcom", "Klaipeda_88");  
			//change working directory
			ftpClient.enterLocalPassiveMode();
			ftpClient.changeWorkingDirectory("/ShowBuzz/resume/");

			if (true) {  
				System.out.println("Connection established...");  
				System.out.println("Status: "+ftpClient.getStatus());  
				// logout the user, returned true if logout successfully  
				String[] files = ftpClient.listNames();

			
			
				 ArrayList<String> asas = new  ArrayList<String>();

				for(int i = 0; i < files.length; i++) 
				{
					
					asas.add(i, files[i].substring(0, files[i].indexOf(".")));
					System.out.println(files[i].substring(0, files[i].indexOf(".")));
				}       
				ftpClient.disconnect();

				
				final ListView listView ;
				   // Get ListView object from xml
		        listView = (ListView) findViewById(R.id.listView1);
		  
		        // Define a new Adapter
		        // First parameter - Context
		        // Second parameter - Layout for the row
		        // Third parameter - ID of the TextView to which the data is written
		        // Forth - the Array of data

		        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		          R.layout.simple_list_item_1, android.R.id.text1, asas);
		        // Assign adapter to ListView
		        listView.setAdapter(adapter); 
		        
		     // ListView Item Click Listener
		        listView.setOnItemClickListener(new OnItemClickListener() {

		              @Override
		              public void onItemClick(AdapterView<?> parent, View view,
		                 int position, long id) {
		                
		               // ListView Clicked item index
		               int itemPosition     = position;
		               
		               // ListView Clicked item value
		               itemValue    = (String) listView.getItemAtPosition(position);
		                  
		                // Show Alert 
		                Toast.makeText(getApplicationContext(),
		                  "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
		                  .show();
		                
		                
		                Intent intent = new Intent(TrailerActivity.this, MediaPlayer.class);
		                intent.putExtra("key", itemValue);
		                startActivity(intent);
		             
		              }

		         }); 

				/////////////////////////////////////////////  ///// End FTP

			
			}
		}catch(Exception e){
			}

		}
    
	  }

