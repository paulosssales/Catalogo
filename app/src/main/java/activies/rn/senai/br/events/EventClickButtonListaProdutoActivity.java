package activies.rn.senai.br.events;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import activies.rn.senai.br.activities.ProdutoActivity;
import activies.rn.senai.br.activities.R;

public class EventClickButtonListaProdutoActivity implements View.OnClickListener {
    private FloatingActionButton button;
    Activity activity;

    public EventClickButtonListaProdutoActivity(FloatingActionButton mBt, Activity activity) {
        this.button = mBt;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
            final int id = button.getId();
            final int btNovoId = activity.findViewById(R.id.activity_lista_produtos_bt_novo).getId();
            if (id == btNovoId) {
                activity.startActivity(new Intent(v.getContext(),ProdutoActivity.class));
            }
    }

}
