package activies.rn.senai.br.events;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import activies.rn.senai.br.activities.ProdutoActivity;
import activies.rn.senai.br.activities.R;

public class EventClickButtonListaProdutoActivity implements View.OnClickListener {
    private FloatingActionButton button;
    private Context context;

    public EventClickButtonListaProdutoActivity(FloatingActionButton mBt, Context context) {
        this.button = mBt;
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        final int btNovoId = v.findViewById(R.id.activity_lista_produtos_bt_novo).getId();
        if (id == btNovoId) {
            context.startActivity(new Intent(v.getContext(),ProdutoActivity.class));
        }
    }

}
