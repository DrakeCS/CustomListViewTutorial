package edu.Drake.customlistviewtutorial;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SongAdapter extends ArrayAdapter<Song>{

    Context context; 
    int layoutResourceId;    
    Song data[] = null;
    
    public SongAdapter(Context context, int layoutResourceId, Song[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        SongHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new SongHolder();
            holder.title = (TextView)row.findViewById(R.id.songTitle);
            holder.artist = (TextView)row.findViewById(R.id.songArtist);
            holder.album = (TextView)row.findViewById(R.id.songAlbum);
            
            row.setTag(holder);
        }
        else
        {
            holder = (SongHolder)row.getTag();
        }
        
        Song song = data[position];
        holder.title.setText(song.title);
        holder.artist.setText(song.artist);
        holder.album.setText(song.album);
        
        return row;
    }
    
    static class SongHolder
    {
        TextView title;
        TextView artist;
        TextView album;
    }
}
