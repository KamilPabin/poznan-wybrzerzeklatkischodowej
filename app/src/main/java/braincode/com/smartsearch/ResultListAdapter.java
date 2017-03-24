package braincode.com.smartsearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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

        holder.Title.setText( item.getTitle());
        holder.Description.setText( item.getDescription());
        holder.Price.setText( item.getPrice());

        

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
