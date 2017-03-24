package braincode.com.smartsearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Little on 2017-03-24.
 */

public class ShowResultsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = super.onCreateView(inflater, container, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.SearchResultList);
        recyclerView.setAdapter(new ResultListAdapter(null, getContext()));
        return v;
    }
}
