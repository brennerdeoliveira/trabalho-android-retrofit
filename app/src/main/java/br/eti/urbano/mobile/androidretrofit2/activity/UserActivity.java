package br.eti.urbano.mobile.androidretrofit2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import br.eti.urbano.mobile.androidretrofit2.R;
import br.eti.urbano.mobile.androidretrofit2.adapter.PostsAdapter;
import br.eti.urbano.mobile.androidretrofit2.bootstrap.APIClient;
import br.eti.urbano.mobile.androidretrofit2.model.Posts;
import br.eti.urbano.mobile.androidretrofit2.model.User;
import br.eti.urbano.mobile.androidretrofit2.resource.PostsResource;
import br.eti.urbano.mobile.androidretrofit2.resource.UserResource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

//    UserResource apiUserResouce;
    PostsResource apiPostsResource;

    EditText txtId;
    EditText txtUserName;
    EditText txtData;
    ListView listViewPosts;
    List<Posts> listPosts;
    List<HashMap<String,String>> colecao =
            new ArrayList<HashMap<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //tem o contexto da aplicação (application)
        //PASSO 4
        apiPostsResource = APIClient.getClient().create(PostsResource.class);

        Call<List<Posts>> get = apiPostsResource.get();

        get.enqueue(new Callback<List<Posts>>() {

            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                listViewPosts = findViewById(R.id.listViewPosts);

                listPosts = response.body();

//                listPosts.forEach(p ->{
//                    //Criar dados para adapter
//                    Posts posts = new Posts(p.getUserId(), p.getId(), p.getTitle());
//                    listPosts.add(posts);
//
//                    HashMap<String,String> mapPosts = new HashMap<String,String>();
//                    mapPosts.put("userId", String.valueOf(p.getUserId()));
//                    mapPosts.put("id",String.valueOf(p.getId()));
//                    mapPosts.put("title", p.getTitle());
//
//                    colecao.add(mapPosts);
//                });

//                Pessoa pessoa = new Pessoa(nome, email, telefone, senha);
//
//                lista.add(pessoa);
//
//                //SAIDA
//
//                minhaLista = findViewById(R.id.minhaLista);
//
//                //SAIDA
//
//                minhaLista = findViewById(R.id.minhaLista);
//

                PostsAdapter postsAdapter = new PostsAdapter(getApplicationContext(), listPosts);
                listViewPosts.setAdapter(postsAdapter);

//                String[] from = {"id","username"};
//                int[] to = {R.id.txtId,R.id.txtUserName};
//
//                SimpleAdapter simpleAdapter =
//                        new SimpleAdapter(
//                                getApplicationContext(),
//                                colecao,
//                                R.layout.user,
//                                from,
//                                to);
//
//                listViewUser.setAdapter(simpleAdapter);
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

}
