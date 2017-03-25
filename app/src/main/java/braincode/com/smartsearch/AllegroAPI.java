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
            "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGxlZ3JvX2FwaSJdLCJleHAiOjE0OTA0ODM4NjAsImp0aSI6ImRmNDBlY2E0LWY5NDEtNDA0NS05Y2Q0LTQ5MzQ1M2UwZTkxMSIsImNsaWVudF9pZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.q7t-9GQuuMYKLU9meZl74a7Vr1bC2VLzP19HgEUL5K9_WqkxLqui1kXlhIo9sXhcxW1YZoDR2Z4od_3uqpx22USdfyXQRp0APBuSSnITkixfD0D9dEh0WGa1HMS1eajWC2_QeLyUsG5jUkCT37zQur3CCZswDR4Ur5jFuF9bFGttCMoP06BwKs-JiCxY9HA5hrI9gNU9XSTZNQy7NVIXBZbDbZkXfGr7tFVQgd6_Atkec6BXQA_kvmeK51a2Hw6TL6T9fyAJrLcGH73IR9w8xB5u1vQbqJ7KAYQg6VWfcsdCc7Svg5eoz1ORW66j6bF3AaCAE7M8IOXL6e-jXJEznA",
            "User-Agent: hackaton2017 (Client-Id 656cbe47-b17d-46c2-bae1-3222c8777d5b) Platform",
            "Accept: application/vnd.allegro.public.v1+json"
    })
    @GET("v1/allegro/categories")
    Call<CategoriesList> getCategories();


    @GET("v1/allegro/categories")
    Callback<String> getSubCategories(@Path("category.id") int categoryId);


    @Headers({
            "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGxlZ3JvX2FwaSJdLCJleHAiOjE0OTA0ODM4NjAsImp0aSI6ImRmNDBlY2E0LWY5NDEtNDA0NS05Y2Q0LTQ5MzQ1M2UwZTkxMSIsImNsaWVudF9pZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.q7t-9GQuuMYKLU9meZl74a7Vr1bC2VLzP19HgEUL5K9_WqkxLqui1kXlhIo9sXhcxW1YZoDR2Z4od_3uqpx22USdfyXQRp0APBuSSnITkixfD0D9dEh0WGa1HMS1eajWC2_QeLyUsG5jUkCT37zQur3CCZswDR4Ur5jFuF9bFGttCMoP06BwKs-JiCxY9HA5hrI9gNU9XSTZNQy7NVIXBZbDbZkXfGr7tFVQgd6_Atkec6BXQA_kvmeK51a2Hw6TL6T9fyAJrLcGH73IR9w8xB5u1vQbqJ7KAYQg6VWfcsdCc7Svg5eoz1ORW66j6bF3AaCAE7M8IOXL6e-jXJEznA",
            "User-Agent: hackaton2017 (Client-Id 656cbe47-b17d-46c2-bae1-3222c8777d5b) Platform",
            "Accept: application/vnd.allegro.public.v1+json"
    })
    @GET("offers")
    Call<ItemsList> getItems(@QueryMap Map<String, String> options);

    @Headers({
            "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGxlZ3JvX2FwaSJdLCJleHAiOjE0OTA0ODM4NjAsImp0aSI6ImRmNDBlY2E0LWY5NDEtNDA0NS05Y2Q0LTQ5MzQ1M2UwZTkxMSIsImNsaWVudF9pZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.q7t-9GQuuMYKLU9meZl74a7Vr1bC2VLzP19HgEUL5K9_WqkxLqui1kXlhIo9sXhcxW1YZoDR2Z4od_3uqpx22USdfyXQRp0APBuSSnITkixfD0D9dEh0WGa1HMS1eajWC2_QeLyUsG5jUkCT37zQur3CCZswDR4Ur5jFuF9bFGttCMoP06BwKs-JiCxY9HA5hrI9gNU9XSTZNQy7NVIXBZbDbZkXfGr7tFVQgd6_Atkec6BXQA_kvmeK51a2Hw6TL6T9fyAJrLcGH73IR9w8xB5u1vQbqJ7KAYQg6VWfcsdCc7Svg5eoz1ORW66j6bF3AaCAE7M8IOXL6e-jXJEznA",
            "User-Agent: hackaton2017 (Client-Id 656cbe47-b17d-46c2-bae1-3222c8777d5b) Platform",
            "Accept: application/vnd.allegro.public.v1+json"
    })
    @GET("v1/allegro/offers/{id}")
    Call<ItemDetail> getItemsDetails(@Path("id") long id);

}
