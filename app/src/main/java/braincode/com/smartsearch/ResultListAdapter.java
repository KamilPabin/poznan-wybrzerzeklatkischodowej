package braincode.com.smartsearch;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;

import braincode.com.smartsearch.Model.Item;
import braincode.com.smartsearch.Model.ItemDetail;
import braincode.com.smartsearch.Model.Prices;
import retrofit2.Call;
import retrofit2.Response;


/**
 * Created by Little on 2017-03-24.
 */

public class ResultListAdapter extends RecyclerView.Adapter<ResultListAdapter.ViewHolder> {

    private List<Item> itemList;
    private Context mContext;

    public interface onDetailsDownloading {
        public void onDetailsDataLoaded(Bundle bundle);
    }

    public ResultListAdapter(List<Item> items, Context context) {
        this.itemList = items;
        this.mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView Thumbnail;
        public TextView Title;
        public TextView Description;
        public TextView Price;

        public ViewHolder (View itemView) {
            super(itemView);
            Thumbnail = (ImageView) itemView.findViewById(R.id.Thumbnail);
            Title = (TextView) itemView.findViewById(R.id.Title);
            Description = (TextView) itemView.findViewById( R.id.Desc);
            Price = (TextView) itemView.findViewById(R.id.Price);
        }
    }

    @Override
    public ResultListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.list_view_item, parent, false);
        ViewHolder viewHolder = new ViewHolder( contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ResultListAdapter.ViewHolder holder, int position) {
        final Item item = itemList.get(position);
        Log.d("tag", "position " + position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetItemsDetails getItemsDetails = new GetItemsDetails() {
                    @Override
                    public void onResponse(Call<ItemDetail> call, Response<ItemDetail> response) {
                        if (response.isSuccessful()) {
                            ItemDetail detail = response.body();
                            Bundle data = new Bundle();
                            data.putSerializable("data",(Serializable)detail);
                            ((onDetailsDownloading)mContext).onDetailsDataLoaded(data);
                                System.out.println(detail.toString());
                        } else {
                            Log.d("TAG", response.message());
                            Log.d("TAG", response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ItemDetail> call, Throwable t) {
                        t.printStackTrace();

                    }
                };
                Log.d("ID", item.getId() + "" );
                getItemsDetails.getOffers(item.getId());
            }
        });



        Prices.BuyNow buyNow = item.getPrices().getBuyNow();
        Prices.WithDelivery withDelivery = item.getPrices().getWithDelivery();

        holder.Title.setText(item.getName());
        holder.Description.setText("");

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        if (buyNow != null) {
            holder.Price.setText(String.valueOf(numberFormat.format(buyNow.getAmount())) + " " + mContext
            .getResources().getString(R.string.zl));
        } else if (withDelivery != null) {
            holder.Price.setText(String.valueOf(numberFormat.format(withDelivery.getAmount()))
            + " " + mContext.getResources().getString(R.string.zl));
        }
        Glide
                .with(mContext)
                .load(item.getImages().get(0).getUrl())
                .dontTransform()
                .into(holder.Thumbnail);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
