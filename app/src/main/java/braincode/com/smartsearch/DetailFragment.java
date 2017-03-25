package braincode.com.smartsearch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import braincode.com.smartsearch.Model.Item;
import braincode.com.smartsearch.Model.ItemDetail;

/**
 * Created by Little on 2017-03-25.
 */

public class DetailFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment_layout,container);
        ItemDetail data = (ItemDetail) getArguments().get("data");
        return v;
    }
}
