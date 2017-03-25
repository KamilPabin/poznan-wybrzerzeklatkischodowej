package braincode.com.smartsearch;

import braincode.com.smartsearch.Model.CategoriesList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by kkoza on 25.03.2017.
 */

public interface AllegroAPI {

    @Headers({
            "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGxlZ3JvX2FwaSJdLCJleHAiOjE0OTA0Mzg0NzksImp0aSI6IjllZmI5MzM5LWE5ODAtNDdjOS05N2I2LWI0YzhkZTA3NTBlMiIsImNsaWVudF9pZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.wZlGR-vzyzK5d5SRlx2QebJgvz1S8Fl1NsTPHq4hIABHyuWQ8fUvddFk6qtyfWIMKzyDPYAqxuyZ9XnQmB8SCxnqaEWxD8GB6-Pq0LTD7qAWl-MSdxzOiJ-EPCh-3cJFfM1E-goUWbj6uUnYqjzCe4FvBkdJwCnHqC_aarjx90bngGKqWlvelwP8_W_03Mk-I7uLofShRSOUls_wY3nxVUDgqmQ5ml27fIwgMW_OQNwtsaiOrrWcItrGaZ8Q_LuxChiMrKNPrqTahGZFBrOSsYxjcZWi4xZRdrHWi4-0ucn_ieTkpdAqweDyz7JNLFbqTjpdakHoUeLXHOei3Vjwkg",
            "User-Agent: hackaton2017 (Client-Id 656cbe47-b17d-46c2-bae1-3222c8777d5b) Platform",
            "Accept: application/vnd.allegro.public.v1+json"
    })
    @GET("v1/allegro/categories")
    Call<CategoriesList> getCategories();





}
