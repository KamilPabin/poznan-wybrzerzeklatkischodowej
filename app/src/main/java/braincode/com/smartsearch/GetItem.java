package braincode.com.smartsearch;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

import braincode.com.smartsearch.Model.ItemsList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kkoza on 25.03.2017.
 */

public abstract class GetItem implements Callback<ItemsList> {

    private String offersDetailsURL = "https://allegroapi.io";

    public void getOffers(Map<String, String> options) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(offersDetailsURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        AllegroAPI allegroAPI = retrofit.create(AllegroAPI.class);

        Call<ItemsList> call = allegroAPI.getItems(options);
        call.enqueue(this);
    }

    @Override
    public abstract void onResponse(Call<ItemsList> call, Response<ItemsList> response);

    @Override
    public abstract void onFailure(Call<ItemsList> call, Throwable t);
}