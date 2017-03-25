package braincode.com.smartsearch;

import java.util.Map;

import braincode.com.smartsearch.Model.CategoriesList;
import braincode.com.smartsearch.Model.ItemDetail;
import braincode.com.smartsearch.Model.ItemsList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by kkoza on 25.03.2017.
 */

public interface AllegroAPI {

    @Headers({
            "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGxlZ3JvX2FwaSJdLCJleHAiOjE0OTA0OTY4NDEsImp0aSI6ImJjYjk5ZDk2LTQ1OTktNDgzYS1hZWNhLWM1ODMxNTI4YWJkOCIsImNsaWVudF9pZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.hwdrsVFvgneWpZtpM7USSU_IhoAFGsXCLzhEr8kD1YCthaCwDiZyYWw-TowQ9IvkHCHS9ZQWrQRyfPh-HXz0YrFtZdTqLHzB7GOZWvz9fJOCr9FHAjm3jcN2AyCCAE32EkBQF3FSru_gDjtSko0deQeEZS9qniK8k_MYzKktSmX8Ph_bKMpTODFBx7TSUMvlkEGm3ajb8OM873Z2iwBK8NKxYYgHUY1J4zuULZTztaC4zSl33cARP-AGHZNuNjUh_V7wkDqEWbFEGWoPIFp7J1ZdTrPbCMC7qqcfEKVtq-TPzRhn2_cj00v0su3MFQh8Pukk43-v0K1_3pHNgdrcSA",
            "User-Agent: hackaton2017 (Client-Id 656cbe47-b17d-46c2-bae1-3222c8777d5b) Platform",
            "Accept: application/vnd.allegro.public.v1+json"
    })
    @GET("v1/allegro/categories")
    Call<CategoriesList> getCategories();


    @GET("v1/allegro/categories")
    Callback<String> getSubCategories(@Path("category.id") int categoryId);


    @Headers({
            "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGxlZ3JvX2FwaSJdLCJleHAiOjE0OTA0OTY4NDEsImp0aSI6ImJjYjk5ZDk2LTQ1OTktNDgzYS1hZWNhLWM1ODMxNTI4YWJkOCIsImNsaWVudF9pZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.hwdrsVFvgneWpZtpM7USSU_IhoAFGsXCLzhEr8kD1YCthaCwDiZyYWw-TowQ9IvkHCHS9ZQWrQRyfPh-HXz0YrFtZdTqLHzB7GOZWvz9fJOCr9FHAjm3jcN2AyCCAE32EkBQF3FSru_gDjtSko0deQeEZS9qniK8k_MYzKktSmX8Ph_bKMpTODFBx7TSUMvlkEGm3ajb8OM873Z2iwBK8NKxYYgHUY1J4zuULZTztaC4zSl33cARP-AGHZNuNjUh_V7wkDqEWbFEGWoPIFp7J1ZdTrPbCMC7qqcfEKVtq-TPzRhn2_cj00v0su3MFQh8Pukk43-v0K1_3pHNgdrcSA",
            "User-Agent: hackaton2017 (Client-Id 656cbe47-b17d-46c2-bae1-3222c8777d5b) Platform",
            "Accept: application/vnd.allegro.public.v1+json"
    })
    @GET("offers")
    Call<ItemsList> getItems(@QueryMap Map<String, String> options);

    @Headers({
            "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGxlZ3JvX2FwaSJdLCJleHAiOjE0OTA0OTY4NDEsImp0aSI6ImJjYjk5ZDk2LTQ1OTktNDgzYS1hZWNhLWM1ODMxNTI4YWJkOCIsImNsaWVudF9pZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.hwdrsVFvgneWpZtpM7USSU_IhoAFGsXCLzhEr8kD1YCthaCwDiZyYWw-TowQ9IvkHCHS9ZQWrQRyfPh-HXz0YrFtZdTqLHzB7GOZWvz9fJOCr9FHAjm3jcN2AyCCAE32EkBQF3FSru_gDjtSko0deQeEZS9qniK8k_MYzKktSmX8Ph_bKMpTODFBx7TSUMvlkEGm3ajb8OM873Z2iwBK8NKxYYgHUY1J4zuULZTztaC4zSl33cARP-AGHZNuNjUh_V7wkDqEWbFEGWoPIFp7J1ZdTrPbCMC7qqcfEKVtq-TPzRhn2_cj00v0su3MFQh8Pukk43-v0K1_3pHNgdrcSA",
            "User-Agent: hackaton2017 (Client-Id 656cbe47-b17d-46c2-bae1-3222c8777d5b) Platform",
            "Accept: application/vnd.allegro.public.v1+json"
    })
    @GET("v1/allegro/offers/{id}")
    Call<ItemDetail> getItemsDetails(@Path("id") long id);

}
