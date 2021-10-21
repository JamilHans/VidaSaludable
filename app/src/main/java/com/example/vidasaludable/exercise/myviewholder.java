package com.example.vidasaludable.exercise;

import android.app.Application;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vidasaludable.R;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

public class myviewholder extends RecyclerView.ViewHolder {
    SimpleExoPlayerView simpleExoPlayerView;
    SimpleExoPlayer simpleExoPlayer;
    TextView vtitleview, vdurationview, vdescriptionview;

    public myviewholder(@NonNull View itemView) {
        super(itemView);
        vtitleview =itemView.findViewById(R.id.vtitle);
        vdurationview = itemView.findViewById(R.id.vduration);
        vdescriptionview = itemView.findViewById(R.id.vdescription);
        simpleExoPlayerView = itemView.findViewById(R.id.exoplayerview);
    }

    void prepareexoplayer(Application application, String videotitle, String videourl, String videoduration, String videodescription)
    {
        try{
            vtitleview.setText(videotitle);
            vdurationview.setText(videoduration);
            vdescriptionview.setText(videodescription);
            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            simpleExoPlayer =(SimpleExoPlayer) ExoPlayerFactory.newSimpleInstance(application,trackSelector);
            Uri videoURI = Uri.parse(videourl);
            DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            MediaSource mediaSource = new ExtractorMediaSource(videoURI, dataSourceFactory, extractorsFactory, null, null);
            simpleExoPlayerView.setPlayer(simpleExoPlayer);
            simpleExoPlayer.prepare(mediaSource);
            simpleExoPlayer.setPlayWhenReady(false);


        }catch (Exception ex){
            Log.d("Explaxer Creshed", ex.getMessage().toString());
        }
    }
}
