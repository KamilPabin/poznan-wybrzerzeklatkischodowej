package braincode.com.smartsearch.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;

import java.util.ArrayList;

import braincode.com.smartsearch.R;
import braincode.com.smartsearch.SearchFragment;

/**
 * Created by kkoza on 25.03.2017.
 */

public class ListDialog extends AppCompatDialogFragment {

    private static final String BEST_MATCH_KEY = "best_match";

    public static ListDialog newInstance(ArrayList<String> bestMatches) {
        Bundle args = new Bundle();
        args.putStringArrayList(BEST_MATCH_KEY, bestMatches);

        ListDialog fragment = new ListDialog();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setCancelable(false);
        final Context context = getActivity();
        Resources r = context.getResources();

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        final ArrayList<String> list = (ArrayList<String>) getArguments().get(BEST_MATCH_KEY);
        CharSequence[] cs = list.toArray(new CharSequence[list.size()]);

        builder .setTitle(R.string.speech_to_text)
                .setSingleChoiceItems(cs, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((SearchFragment) getTargetFragment()).onTextToSpeechConfirmation(list.get(which));
                    }
                })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((SearchFragment) getTargetFragment()).onTextToSpeechConfirmation("");
                    }
                });

        return builder.show();
    }
}
