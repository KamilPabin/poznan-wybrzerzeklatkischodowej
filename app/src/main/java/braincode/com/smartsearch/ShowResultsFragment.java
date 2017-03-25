package braincode.com.smartsearch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import braincode.com.smartsearch.Model.Item;

/**
 * Created by Little on 2017-03-24.
 */

public class ShowResultsFragment extends Fragment {

    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = super.onCreateView(inflater, container, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.SearchResultList);

        List<Item> Data = (List<Item>)this.getArguments().get("Items");
        recyclerView.setAdapter(new ResultListAdapter(Data, context));
        return v;
    }
}
