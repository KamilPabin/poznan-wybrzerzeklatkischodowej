package braincode.com.smartsearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import braincode.com.smartsearch.Model.Item;
import braincode.com.smartsearch.Model.Prices;


/**
 * Created by Little on 2017-03-24.
 */

public class ResultListAdapter extends RecyclerView.Adapter<ResultListAdapter.ViewHolder> {

    private List<Item> itemList;
    private Context mContext;

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

        Item item = itemList.get(position);
        Prices.BuyNow buyNow = item.getPrices().getBuyNow();

        holder.Title.setText(item.getName());
        holder.Description.setText("");
        holder.Price.setText(String.valueOf(buyNow.getAmount()));

        Glide
                .with(mContext)
                .load(item.getImages().get(0).getUrl())
                .dontTransform()
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.Thumbnail);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
