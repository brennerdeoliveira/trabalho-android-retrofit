package br.eti.urbano.mobile.androidretrofit2.resource;

import java.util.List;

import br.eti.urbano.mobile.androidretrofit2.interfaces.GenericInterfaceOperations;
import br.eti.urbano.mobile.androidretrofit2.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by bruno on 28/09/18.
 */


public interface UserResource {

    @GET("user")
    Call<List<User>> get();

    @POST("user")
    Call<User> post(@Body User user);

    @PUT("user")
    Call<User> put(@Body User user);

    @DELETE("user")
    Call<Void> delete(@Body User user);
}
