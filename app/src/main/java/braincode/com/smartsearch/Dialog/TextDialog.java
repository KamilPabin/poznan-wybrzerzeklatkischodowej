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
 * Created by kkoza on 24.03.2017.
 */

public class TextDialog extends AppCompatDialogFragment {

    private static final String BEST_MATCH_KEY = "best_match";

    public static TextDialog newInstance(ArrayList<String> bestMatches) {
        Bundle args = new Bundle();
        args.putStringArrayList(BEST_MATCH_KEY, bestMatches);

        TextDialog fragment = new TextDialog();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setCancelable(false);
        final Context context = getActivity();
        Resources r = context.getResources();

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        final ArrayList<String> bestMatches = (ArrayList<String>) getArguments().get(BEST_MATCH_KEY);

        builder .setTitle(R.string.speech_to_text)
                .setMessage(r.getString(R.string.did_you_say) + "\n" + bestMatches.get(0))
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((SearchFragment) getTargetFragment()).onTextToSpeechConfirmation(bestMatches);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

        return builder.show();
    }
}
