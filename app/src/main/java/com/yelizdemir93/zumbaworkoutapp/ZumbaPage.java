package com.yelizdemir93.zumbaworkoutapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Vector;

public class ZumbaPage extends Fragment {
    View root;
    ArrayList<Videos> vd = new ArrayList<>();
    LayoutInflater li;
    ListView list;
    BaseAdapter ba;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.zumba_page, container, false);
        getActivity().setTitle("Zumba Videos");

        li = LayoutInflater.from(getActivity());
        list = (ListView) root.findViewById(R.id.listView);

        vd.clear();
        vd.add(new Videos("La Gozadera",R.drawable.y1));
        vd.add(new Videos("Bailame",R.drawable.y2));
        vd.add(new Videos("La Bicicleta",R.drawable.zz1));
        vd.add(new Videos("Cheap Thrills",R.drawable.y5));
        vd.add(new Videos("Baylamme",R.drawable.y3));
        vd.add(new Videos("One love (Na Na Na)",R.drawable.z10));
        vd.add(new Videos("Robarte un beso",R.drawable.z9));
        vd.add(new Videos("bailalo",R.drawable.z8));
        vd.add(new Videos("Plakito",R.drawable.y4));
        vd.add(new Videos("Shaky Shaky",R.drawable.shagy));
        vd.add(new Videos("Shut Up And dance",R.drawable.z2));
        vd.add(new Videos("Firehouse",R.drawable.z1));
        vd.add(new Videos("Quien bailar",R.drawable.z3));
        vd.add(new Videos("Soy para ti",R.drawable.z5));
        vd.add(new Videos("Vive y baila",R.drawable.z4));
        vd.add(new Videos("Perro",R.drawable.z11));

        ba = new BaseAdapter() {
            @Override
            public int getCount() {
                return vd.size();
            }

            @Override
            public Object getItem(int i) {
                return vd.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                if (view == null)
                    view = li.inflate(R.layout.listrow, null);
                TextView title = (TextView) view.findViewById(R.id.tvVideoAd);
                ImageView image = (ImageView) view.findViewById(R.id.imageView);
                ImageButton button=(ImageButton) view.findViewById(R.id.imageButtonOynat);
                final Videos temp = vd.get(i);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        if (temp.name.contains("Gozadera"))
                        {
                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.gozadera);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);
                        }
                        if (temp.name.contains("Bicicleta"))
                        {
                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.bicicleta);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);
                        }
                        if (temp.name.contains("Shaky"))
                        {
                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.shaky);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);
                        }
                        if (temp.name.contains("Cheap"))
                        {
                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.cheap);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);
                        }
                        if (temp.name.contains("Bailame"))
                        {
                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.bailame);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);
                        }
                        if (temp.name.contains("Baylamme"))
                        {
                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.baylamme);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);
                        }
                        if (temp.name.contains("Plakito"))
                        {
                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.plakito);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);
                        }
                        if (temp.name.equals("bailalo"))
                        {
                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.bailalo);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);
                        }
                        else if (temp.name.contains("beso"))
                        {

                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.robarte);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);

                        }
                        else if (temp.name.contains("love"))
                        {
                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.one);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);
                        }
                        else if (temp.name.contains("dance"))
                        {
                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.shut);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);
                        }
                        else if (temp.name.contains("Quien"))
                        {
                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.quien);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);
                        }
                        else if (temp.name.equals("Firehouse"))
                        {
                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.firehouse);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);
                        }
                       else if (temp.name.contains("para"))
                        {
                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.soy);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);
                        }
                        else if (temp.name.contains("Vive"))
                        {
                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.vive);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);
                        }
                        else if (temp.name.equals("Perro"))
                        {
                            MainActivity ma = (MainActivity) getActivity();
                            VideoViewer v = new VideoViewer();
                            Bundle b = new Bundle();
                            b.putInt("vid_id", R.raw.perro);
                            v.setArguments(b);
                            ma.gotoFragment(v, true);
                        }
                    }
                });

                title.setText(temp.name);
                image.setImageResource(temp.img);

                return view;
            }
        };

        list.setAdapter(ba);

        return root;
    }

}
