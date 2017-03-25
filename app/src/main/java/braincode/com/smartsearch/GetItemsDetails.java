package braincode.com.smartsearch;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import braincode.com.smartsearch.Model.ItemDetail;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kkoza on 25.03.2017.
 */

public abstract class GetItemsDetails implements Callback<ItemDetail> {

    private String offersDetailsURL = "https://api.natelefon.pl";

    public void getOffers(long id) {
        Gson gson = new GsonBuilder()
        .setLenient()
        .create();

        Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(offersDetailsURL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();

        AllegroAPI allegroAPI = retrofit.create(AllegroAPI.class);

        Call<ItemDetail> call = allegroAPI.getItemsDetails(id);
        call.enqueue(this);
        }

        @Override
        public abstract void onResponse(Call<ItemDetail> call, Response<ItemDetail> response);

        @Override
        public abstract void onFailure(Call<ItemDetail> call, Throwable t);

}
