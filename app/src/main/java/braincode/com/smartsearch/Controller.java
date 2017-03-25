package braincode.com.smartsearch;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import braincode.com.smartsearch.Model.CategoriesList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kkoza on 25.03.2017.
 */

public abstract class Controller implements Callback<CategoriesList> {
    private String baseURL = "https://api.natelefon.pl";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        AllegroAPI allegroAPI = retrofit.create(AllegroAPI.class);

        Call<CategoriesList> call = allegroAPI.getCategories();
        call.enqueue(this);

    }

    @Override
    public abstract void onResponse(Call<CategoriesList> call, Response<CategoriesList> response);

    @Override
    public abstract void onFailure(Call<CategoriesList> call, Throwable t);
}
