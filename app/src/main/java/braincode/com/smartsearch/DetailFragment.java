package braincode.com.smartsearch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
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
    @BindView(R.id.detail_atributtes)
    TextView detailDescriptionTv;
    @BindView(R.id.detail_localisation)
    TextView localizationTv;
    @BindView(R.id.detail_price)
    TextView priceTv;
    @BindView(R.id.detail_number)
    TextView detailNumberTv;

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

        detailDescriptionTv.setText(setAttributes(data.getAttributes()));

        localizationTv.setText("Miejscowość: " + data.getLocation().getCity());

        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(2);

        if (data.isAuction()) {
            StringBuilder stringBuilder = new StringBuilder()
                    .append("Licytacja: ")
                    .append(format.format(data.getPrices().getBid()));
            priceTv.setText(stringBuilder.toString());
        }

        if (data.isBuyNow()) {
            StringBuilder stringBuilder = new StringBuilder()
                    .append("Kup Teraz: ")
                    .append(format.format(data.getPrices().getBuyNow()));
            priceTv.setText(stringBuilder.toString());
        }

        return v;
    }

    private String setAttributes(List<Attribute> attributes) {
        StringBuilder builder = new StringBuilder();

        for (Attribute a : attributes) {
            String name = a.getName();
            List<String> values = a.getValues();
            builder.append(name + ": ");
            for (String v : values) {
                builder.append(v + ", ");
            }
            builder.append("\n");
        }

        return builder.toString();

    }
}
