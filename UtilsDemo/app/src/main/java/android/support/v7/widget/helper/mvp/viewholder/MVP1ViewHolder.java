package android.support.v7.widget.helper.mvp.viewholder;

import android.content.Intent;
import android.support.v7.widget.helper.mvp.bean.MVP1Bean;
import android.support.v7.widget.helper.mvp.test.TestActivity;
import android.view.View;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;

/**
 * Created by alina on 2019/3/26.
 */
@BindLayout(R.layout.viewholer_mvp1)
public class MVP1ViewHolder extends ViewHolder<MVP1Bean> {
    private TextView textView;

    public MVP1ViewHolder(View itemView) {
        super(itemView);
        textView = getView(R.id.mvp_tv2);
    }

    @Override
    public void setContent(final MVP1Bean item, int position) {
        textView.setText(item.name);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.getContext().startActivity(new Intent(textView.getContext(), TestActivity.class));
            }
        });
    }
}
