package com.yelizdemir93.zumbaworkoutapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


public class VideoViewer extends Fragment
{
    View root;
    VideoView vv;
    MediaController mc;
    MediaPlayer mp;


    @Override
    public void onPause() {
        super.onPause();
        MainActivity ma = (MainActivity) getActivity();
        ma.getSupportActionBar().show();
        vv.pause();
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        root = inflater.inflate(R.layout.player, container, false);

        int resId = getArguments().getInt("vid_id");
        vv = (VideoView) root.findViewById(R.id.vv);
        mc = new MediaController(getActivity());
        MainActivity ma = (MainActivity) getActivity();
        ma.getSupportActionBar().hide(); // actionbarı sakla

        Uri uri = Uri.parse("android.resource://com.yelizdemir93.zumbaworkoutapp/" +  resId);
        vv.setVideoURI(uri);
        vv.setMediaController(mc);
        mc.setAnchorView(vv);
        vv.start();

        return root;
    }
}
