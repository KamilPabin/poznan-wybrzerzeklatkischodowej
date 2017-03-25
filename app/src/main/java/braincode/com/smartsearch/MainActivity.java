package braincode.com.smartsearch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SearchFragment.onDataDownloaded {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.frame_layout, new SearchFragment())
                .commit();
    }

    @Override
    public void dataDownloaded(Bundle bundle) {
        Fragment frag = new ShowResultsFragment();
        frag.setArguments(bundle);
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout,frag,null)
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
}
