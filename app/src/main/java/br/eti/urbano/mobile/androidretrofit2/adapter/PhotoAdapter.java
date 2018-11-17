package br.eti.urbano.mobile.androidretrofit2.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;

import br.eti.urbano.mobile.androidretrofit2.R;
import br.eti.urbano.mobile.androidretrofit2.model.Photo;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {

    //    Context context;
    List<Photo> photos;

    public PhotoAdapter(List<Photo> photos) {
        this.photos = photos;
    }

    @NonNull
    @Override
    public PhotoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PhotoHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_photos, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoHolder photoHolder, int i) {
        Photo photo = photos.get(i);
//        try {
            new DownloadImageTask(photoHolder.thumbnail).execute(photo.getThumbnailUrl());
//            InputStream in = new java.net.URL(photo.getThumbnailUrl()).openStream();
//            Bitmap bitmap = BitmapFactory.decodeStream(in);
//            photoHolder.thumbnail.setImageBitmap(bitmap);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        photoHolder.title.setText(String.format(Locale.getDefault(), "%s",
//                photos.get(i).getTitle()
//        ));

//        holder.moreButton.setOnClickListener(view -> updateItem(position));
//        holder.deleteButton.setOnClickListener(view -> removerItem(position));
    }

    @Override
    public int getItemCount() {
        return photos != null ? photos.size() : 0;
    }
//
//    public PhotoAdapter(final Context applicationContext, final List<Photo> photos) {
//        this.context = applicationContext;
//        this.photos = photos;
//    }
//
//    @Override
//    public int getCount() {
//        return this.photos != null ? this.photos.size() : 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return this.photos.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context)
//                    .inflate(R.layout.list_photos, parent, false);
//        }
//
//        Photo photo = (Photo) getItem(position);
//
//        ((TextView) convertView.findViewById(R.id.textViewAlbumId)).setText(String.valueOf(photo.getAlbumId()));
//        ((TextView) convertView.findViewById(R.id.textViewId)).setText(String.valueOf(photo.getId()));
//        ((TextView) convertView.findViewById(R.id.textViewTitle)).setText(String.valueOf(photo.getTitle()));
//
//        return convertView;
//    }

}
