package braincode.com.smartsearch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import braincode.com.smartsearch.Model.Attribute;
import braincode.com.smartsearch.Model.ItemDetail;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Little on 2017-03-25.
 */

public class DetailFragment extends Fragment {

    @BindView(R.id.main_image)
    ImageView mainIv;
    @BindView(R.id.detail_title)
    TextView detailTitleTv;
    @BindView(R.id.detail_localisation)
    TextView localizationTv;
    @BindView(R.id.detail_price)
    TextView priceTv;
    @BindView(R.id.detail_number)
    TextView quantityTv;

    @BindView(R.id.list_view)
    ListView listView;

    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment_layout, container, false);
        ButterKnife.bind(this, v);
        ItemDetail data = (ItemDetail) getArguments().get("data");

        Glide.with(context)
                .load(data.getMainImage().getMedium())
                .dontTransform()
                .into(mainIv);

        detailTitleTv.setText(data.getName());
        ArrayList<Attribute> list = (ArrayList<Attribute>) data.getAttributes();
        MyAdapter myAdapter = new MyAdapter(context, R.layout.attribute_list_item, list);
        listView.setAdapter(myAdapter);


        localizationTv.setText("Lokalizacja: " + data.getLocation().getCity());

        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(2);

        if (data.isAuction()) {
            StringBuilder stringBuilder = new StringBuilder()
                    .append("Licytacja: ")
                    .append(format.format(data.getPrices().getBid()) + " szt");
            priceTv.setText(stringBuilder.toString());
        }

        if (data.isBuyNow()) {
            StringBuilder stringBuilder = new StringBuilder()
                    .append("Kup Teraz: ")
                    .append(format.format(data.getPrices().getBuyNow()));
            priceTv.setText(stringBuilder.toString());
        }

        quantityTv.setText("Ilość: " + data.getQuantities().getAvailable());


        return v;
    }

    private String setAttributes(List<Attribute> attributes) {
        StringBuilder builder = new StringBuilder();

        for (Attribute a : attributes) {
            String name = a.getName();

            List<String> values = a.getValues();
            builder.append(name + ": ");
            for (String v : values) {
                if (name.equals("Rozmiar")) {
                    v = v.replace(",", ".");
                }
                builder.append(v + ", ");
            }
            builder.append("\n");
        }

        return builder.toString();

    }

    private class MyAdapter extends ArrayAdapter<Attribute> {
        Context context;
        ArrayList<Attribute> list;
        LayoutInflater inflater;

        public MyAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<Attribute> list) {
            super(context, resource, list);
            this.context = context;
            this.list = list;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                v = inflater.inflate(R.layout.attribute_list_item, null);
            }

            ((TextView) v.findViewById(R.id.attr_title)).setText(list.get(position).getName());
            ((TextView) v.findViewById(R.id.attr_values)).setText(getText(list.get(position)));

            return v;
        }

        private String getText(Attribute a) {

            StringBuilder builder = new StringBuilder();

                String name = a.getName();

                List<String> values = a.getValues();
                for (int i = 0; i < values.size(); i++) {
                    String v = values.get(i);
                    if (name.equals("Rozmiar")) {
                        v = v.replace(",", ".");
                    }
                    if (i == values.size()-1) {
                        builder.append(v);
                    } else
                    builder.append(v + ", ");
                }
                builder.append("\n");

            return builder.toString();
        }
    }
}
