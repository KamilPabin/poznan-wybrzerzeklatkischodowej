package braincode.com.smartsearch;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SearchFragment.onDataDownloaded,ResultListAdapter.onDetailsDownloading {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ColorDrawable drawable = new ColorDrawable(Color.parseColor("#FF8000"));
        getSupportActionBar().setBackgroundDrawable(drawable);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right,
                android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                transaction.add(R.id.frame_layout, new SearchFragment())
                .commit();
    }

    @Override
    public void dataDownloaded(Bundle bundle) {
        Fragment frag = new ShowResultsFragment();
        frag.setArguments(bundle);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right,
                android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                transaction.replace(R.id.frame_layout,frag,null)
                .addToBackStack(null)
                .commit();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        int fragmentInStack = fragmentManager.getBackStackEntryCount();

        if (fragmentInStack > 0){
            fragmentManager.popBackStack();
        }
        if (fragmentInStack == 1) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public void onDetailsDataLoaded(Bundle bundle) {
        Fragment frag = new DetailFragment();
        frag.setArguments(bundle);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right,
                android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                transaction.replace(R.id.frame_layout,frag,null)
                .addToBackStack(null)
                .commit();
    }
}
