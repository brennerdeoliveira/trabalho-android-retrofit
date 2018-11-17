package br.eti.urbano.mobile.androidretrofit2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

import br.eti.urbano.mobile.androidretrofit2.R;
import br.eti.urbano.mobile.androidretrofit2.adapter.PostsAdapter;
import br.eti.urbano.mobile.androidretrofit2.bootstrap.APIClient;
import br.eti.urbano.mobile.androidretrofit2.model.Posts;
import br.eti.urbano.mobile.androidretrofit2.resource.PostsResource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    private PostsResource apiPostsResource;
    private ListView listViewPosts;
    private List<Posts> listPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        apiPostsResource = APIClient.getClient().create(PostsResource.class);

        Call<List<Posts>> get = apiPostsResource.get();

        get.enqueue(new Callback<List<Posts>>() {

            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                listViewPosts = findViewById(R.id.listViewPosts);

                listPosts = response.body();

                PostsAdapter postsAdapter = new PostsAdapter(getApplicationContext(), listPosts);
                listViewPosts.setAdapter(postsAdapter);

            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

}
