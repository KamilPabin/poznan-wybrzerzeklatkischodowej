package braincode.com.smartsearch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
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

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.resultlayout, container, false);
        mLayoutManager = new LinearLayoutManager(context);

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.SearchResultList);
        recyclerView.setLayoutManager(mLayoutManager);

        List<Item> Data = (List<Item>)this.getArguments().get("Items");
        recyclerView.setAdapter(new ResultListAdapter(Data, context));
        return v;
    }
}
