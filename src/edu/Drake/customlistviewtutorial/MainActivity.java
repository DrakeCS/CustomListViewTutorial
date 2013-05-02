package edu.Drake.customlistviewtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Song song_data[] = new Song[]
				{
				new Song("Song 1", "Artist 1", "Album 1"),
				new Song("Song 2", "Artist 2", "Album 2"),
				};

		SongAdapter adapter = new SongAdapter(this, R.layout.listview_item, song_data);

		listView = (ListView)findViewById(R.id.listView1);
		View header = (View)getLayoutInflater().inflate(R.layout.listview_header, null);
		listView.addHeaderView(header);
		listView.setAdapter(adapter);
		
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				Toast toast = Toast.makeText(getApplicationContext(), "Long click at " + Integer.toString(position), Toast.LENGTH_SHORT);
				toast.show();
				return true;
			}
		});
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast toast = Toast.makeText(getApplicationContext(), "Click at " + Integer.toString(position), Toast.LENGTH_SHORT);
				toast.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
