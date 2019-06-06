package activies.rn.senai.br.events;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EventTextChanged implements TextWatcher {
    private TextView textView;
    private EditText editText;

    public EventTextChanged(TextView textView, EditText editText) {
        this.textView = textView;
        this.editText = editText;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public EditText getEditText() {
        return editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if (s.length() > 0) {
            clickAnimacaoInsertLabelTitle(getTextView(), getEditText());
        } else {
            clickAnimacaoResetLabelTitle(getTextView(), getEditText());
        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    private void clickAnimacaoResetLabelTitle(TextView mTv, EditText mEd) {
        mTv.setVisibility(View.INVISIBLE);
        mEd.setHint(mTv.getText().toString());
    }

    private void clickAnimacaoInsertLabelTitle(TextView mTv, EditText mEd) {
        mTv.setVisibility(View.VISIBLE);
        mEd.setHint("");
    }
}
