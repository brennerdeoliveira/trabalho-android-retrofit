package br.eti.urbano.mobile.androidretrofit2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.eti.urbano.mobile.androidretrofit2.R;
import br.eti.urbano.mobile.androidretrofit2.adapter.PhotoAdapter;
import br.eti.urbano.mobile.androidretrofit2.bootstrap.APIClient;
import br.eti.urbano.mobile.androidretrofit2.model.Photo;
import br.eti.urbano.mobile.androidretrofit2.resource.PhotoResource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoActivity extends AppCompatActivity {

    private PhotoResource photoResource;
    private List<Photo> photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        photoResource = APIClient.getClient().create(PhotoResource.class);

        Call<List<Photo>> get = photoResource.get();

        get.enqueue(new Callback<List<Photo>>() {

            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                photos = response.body();

                PhotoAdapter photoAdapter = new PhotoAdapter(photos);
                RecyclerView recyclerView = findViewById(R.id.recyclerViewPhoto);

                recyclerView.setLayoutManager(
                        new GridLayoutManager(getApplicationContext(), 4)
                );
                recyclerView.setAdapter(photoAdapter);
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
