package br.eti.urbano.mobile.androidretrofit2.resource;

import java.util.List;

import br.eti.urbano.mobile.androidretrofit2.model.Posts;
import br.eti.urbano.mobile.androidretrofit2.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsResource {

    @GET("posts")
    Call<List<Posts>> get();

}
