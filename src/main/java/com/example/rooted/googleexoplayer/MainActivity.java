package com.example.rooted.googleexoplayer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class MainActivity extends AppCompatActivity {
private  PlayerView playerview;
private SimpleExoPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerview=findViewById(R.id.playerview);

    }

    @Override
    protected void onStart() {
        super.onStart();
        player= ExoPlayerFactory.newSimpleInstance(this,new DefaultTrackSelector());
        playerview.setPlayer(player);
       DefaultDataSourceFactory defaultDataSource=new DefaultDataSourceFactory(this,Util.getUserAgent(this,"GoogleExoPlayer"));
        ExtractorMediaSource mediaSource=new ExtractorMediaSource.Factory(defaultDataSource).createMediaSource(Uri.parse("asset:///test.mp4"));
        player.prepare(mediaSource);
        player.setPlayWhenReady(true);

    }

    @Override
    protected void onStop() {
        super.onStop();
        playerview.setPlayer(null);
        player.release();
        player=null;
    }
}
