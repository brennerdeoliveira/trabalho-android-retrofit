package br.eti.urbano.mobile.androidretrofit2.resource;

import java.util.List;

import br.eti.urbano.mobile.androidretrofit2.model.Photo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoResource {

    @GET("photos")
    Call<List<Photo>> get();

}

