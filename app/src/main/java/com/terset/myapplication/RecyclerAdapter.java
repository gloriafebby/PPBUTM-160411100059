package com.terset.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerViewHolder> {

    private final Context context;
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    Integer [] imageDrawable={R.drawable.coffee_americano,R.drawable.arabica_kopi,R.drawable.robusta_kopi};
    String [] name;
    String [] harga;
    LayoutInflater inflater;
    public RecyclerAdapter(Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
        name = context.getResources().getStringArray(R.array.jMenu);
        harga = context.getResources().getStringArray(R.array.hMenu);
        sp = context.getSharedPreferences("jumPesanan", Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.item_list, parent, false);

        RecyclerViewHolder viewHolder=new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tv1.setText(name[position]);
        holder.tv1.setOnClickListener(clickListener);
        holder.tv2.setText("Rp. "+harga[position]);
        holder.tv2.setOnClickListener(clickListener);
        holder.imageView.setImageResource(imageDrawable[position]);
        holder.imageView.setOnClickListener(clickListener);
        holder.tv1.setTag(holder);
        holder.tv2.setTag(holder);
        holder.imageView.setTag(holder);
    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();

            int position = vholder.getPosition();
            Intent intent = new Intent(context,detailmenu.class);
            intent.putExtra("indek",Integer.toString(position));
            context.startActivity(intent);
            //((Activity)context).finish();
            //Toast.makeText(context, "Menu ini berada di posisi " + position, Toast.LENGTH_LONG).show();
        }
    };
    @Override
    public int getItemCount() {
        return name.length;
    }
}