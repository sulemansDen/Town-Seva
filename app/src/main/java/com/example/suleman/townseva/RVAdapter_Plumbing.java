package com.example.suleman.townseva;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by suleman on 3/6/16.
 */

public class RVAdapter_Plumbing extends RecyclerView.Adapter<RVAdapter_Plumbing.PersonViewHolder>  {

    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;
        Context context;
        PersonViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            context = itemView.getContext();
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            //Toast.makeText(context," " + position,Toast.LENGTH_SHORT).show();

            if(position==0)
            {
                Intent i = new Intent(context,LeaksnBlocks.class);
                context.startActivity(i);
            }
            if(position==1)
            {
                Intent i = new Intent(context,TapsnShowers.class);
                context.startActivity(i);
            }
            if(position==2)
            {
                Intent i = new Intent(context,ToiletFittings.class);
                context.startActivity(i);
            }
            if(position==3)
            {
                Intent i = new Intent(context,Accesories.class);
                context.startActivity(i);
            }
            if(position==4)
            {
                Intent i = new Intent(context,GeneralPlumbing.class);
                context.startActivity(i);
            }
        }
    }

    List<Card_Content> contents;

    RVAdapter_Plumbing(List<Card_Content> contents){
        this.contents = contents;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(contents.get(i).Title);
        personViewHolder.personAge.setText(contents.get(i).Desc);
        personViewHolder.personPhoto.setImageResource(contents.get(i).Item_photo);
        //YoYo.with(Techniques.ZoomInRight).playOn(personViewHolder.cv);
    }

    @Override
    public int getItemCount() {
        return contents.size();

    }
}
