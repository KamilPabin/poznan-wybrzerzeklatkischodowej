package braincode.com.smartsearch;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import braincode.com.smartsearch.Dialog.ListDialog;
import braincode.com.smartsearch.Dialog.TextDialog;
import braincode.com.smartsearch.Model.CategoriesList;
import braincode.com.smartsearch.Model.Category;
import braincode.com.smartsearch.Model.Item;
import braincode.com.smartsearch.Model.ItemsList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class SearchFragment extends Fragment {

    public interface onDataDownloaded {
        void dataDownloaded(Bundle bundle);
    }

    private static final int SPEECH_REQUEST_CODE = 0;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.editText)
    EditText inputEt;

    @BindView(R.id.search_button)
    Button searchBtn;

    private Controller controller;

    private GetItem getItem;

    private MainActivity mContext;

    private List<String> results;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = (MainActivity)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);

        controller = new Controller() {
            @Override
            public void onResponse(Call<CategoriesList> call, Response<CategoriesList> response) {
                if (response.isSuccessful()) {
                    CategoriesList categoriesList = response.body();
                    List<Category> list = categoriesList.getCategories();
                    for (Category category : list) {
                        System.out.println(category.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<CategoriesList> call, Throwable t) {
                t.printStackTrace();
            }
        };

        getItem = new GetItem() {
            @Override
            public void onResponse(Call<ItemsList> call, Response<ItemsList> response) {

                if (response.isSuccessful()) {

                    List<Item> list = response.body().list;

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Items",(Serializable)list);
                    mContext.dataDownloaded(bundle);
                } else {

                    Log.d("TAG", response.message());
                    Log.d("TAG", response.toString());
                }
            }

            @Override
            public void onFailure(Call<ItemsList> call, Throwable t) {
                t.printStackTrace();
            }
        };

        return view;
    }

    // Create an intent that can getCategories the Speech Recognizer activity
    @OnClick(R.id.fab)
    public void displaySpeechRecognizer() {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    //Callback from intent. Get text from intent content
    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);

            for (String s : results) {
                Log.d("spokenText", s);
            }

            //best match index: 0
            TextDialog textDialog = TextDialog.newInstance(results.get(0));
            textDialog.setTargetFragment(this, 0);
            textDialog.show(getFragmentManager(), "TAG");
        }
    }

    public void onTextToSpeechConfirmation(String bestMatch) {
        inputEt.setText(bestMatch);
    }

    @OnClick(R.id.fragment_layout)
    public void hideSoftKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @OnClick(R.id.search_button)
    public void find() {
        Log.d("Tag", "klik");

        RequestParser requestParser = new RequestParser();
        requestParser.parseQuery(inputEt.getText().toString());


        Map<String, String> options = requestParser.query.params;
        options.put("phrase", requestParser.query.phrase);
        options.put("country.code", "PL");

        getItem.getOffers(options);
    }

    public void buildListFragment() {
        ListDialog listDialog = ListDialog.newInstance((ArrayList<String>) results);
        listDialog.setTargetFragment(this, 0);
        listDialog.show(getFragmentManager(), "TAG");

    }

}
