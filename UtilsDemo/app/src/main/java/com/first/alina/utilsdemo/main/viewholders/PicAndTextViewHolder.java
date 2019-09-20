package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.PicAndTextBean;
import com.first.alina.utilsdemo.view.CusUnderLineSpan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_picandtext)
public class PicAndTextViewHolder extends ViewHolder<PicAndTextBean>{
    private Context context;
      private String text = "你你看见深V好几年都发不记得你方便你的#PLATE_MARK#奥飞娱乐#PLATE_MARK#放到,你你的加不加还是放到,你你的加不加还是放到，你你的加不加还是放到，你你的加不加#PLATE_MARK#科大讯飞#PLATE_MARK#还是放到，" +
            "你你的加#PLATE_MARK#国药#PLATE_MARK#不加还是放到，你你的加不加还是放到，#PLATE_MARK#腾讯#PLATE_MARK#你你的加不加还是放到";
     private String textChild="#PLATE_MARK#";
    private String textParent=text.replaceAll(textChild,"");
    private List<Integer> indexList=new ArrayList<>();
    private TextView textView;

    public PicAndTextViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        textView=itemView.findViewById(R.id.tv1);
    }

    @Override
    public void setContent(PicAndTextBean item, int position) {
        SpannableString spannableString=new SpannableString(textParent);
        int index=0;
        while (text.indexOf(textChild,index)!=-1){
            int childIndex=text.indexOf(textChild,index);
            indexList.add(childIndex);
            index=text.indexOf(textChild,index);
            text=text.replaceFirst(textChild,"");
        }
        for (int i=0;i<indexList.size();i=i+2){
            spannableString.setSpan(new CusUnderLineSpan(Color.RED,10,2),indexList.get(i),indexList.get(i+1),0);
        }
        textView.setText(spannableString);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(MainActivity.this,TextViewActivity.class));

            }
        });
    }
}
