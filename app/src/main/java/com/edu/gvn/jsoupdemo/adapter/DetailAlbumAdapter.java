package com.edu.gvn.jsoupdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edu.gvn.jsoupdemo.R;
import com.edu.gvn.jsoupdemo.model.online.DetailAlbumModel;

import java.util.ArrayList;

/**
 * Created by hnc on 23/09/2016.
 */

public class DetailAlbumAdapter extends RecyclerView.Adapter<DetailAlbumAdapter.ViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<DetailAlbumModel> mDetailAlbumData;

    public DetailAlbumAdapter(Context context, ArrayList<DetailAlbumModel> mDetailAlbumData) {
        this.mContext = context;
        this.mDetailAlbumData = mDetailAlbumData;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_detail_album, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtOrder.setText(mDetailAlbumData.get(position).getmOrder());
        holder.txtNameSong.setText(mDetailAlbumData.get(position).getmSongName());
    }

    @Override
    public int getItemCount() {
        return mDetailAlbumData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtOrder, txtNameSong;

        public ViewHolder(View itemView) {
            super(itemView);
            txtOrder = (TextView) itemView.findViewById(R.id.fragment_detail_album_order);
            txtNameSong = (TextView) itemView.findViewById(R.id.fragment_detail_album_song_name);
        }
    }
}