package br.eti.urbano.mobile.androidretrofit2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.eti.urbano.mobile.androidretrofit2.R;

public class PhotoHolder extends RecyclerView.ViewHolder {

    TextView albumId;
    TextView id;
    TextView title;
    ImageView thumbnail;

    public PhotoHolder(@NonNull View itemView) {
        super(itemView);
//        albumId = (TextView) itemView.findViewById(R.id.textViewAlbumId);
//        id = (TextView) itemView.findViewById(R.id.textViewId);
//        title = (TextView) itemView.findViewById(R.id.textViewTitle);
        thumbnail = (ImageView) itemView.findViewById(R.id.imageViewThumbnail);
    }

}
