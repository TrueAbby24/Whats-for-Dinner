package com.infs3202.wfd.whatsfordinner;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import Main.RecipeClient;

/**
 * Created by s4285131 on 25/05/2018.
 */

public class KitchenAdapter extends RecyclerView.Adapter<KitchenAdapter.ViewHolder> {
    private List<RecipeClient> mDataset;
    //                recipeData.getCookingTime();
//                recipeData.getTitle();
//                recipeData.getServingSize();
//                recipeData.getCalories();
    private Context mContext;

    public KitchenAdapter(Context context, List<RecipeClient> list) {
        mDataset = list;
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.recipe_mini_layout, parent, false);
        KitchenAdapter.ViewHolder vh = new KitchenAdapter.ViewHolder(v);

        return vh;
    }


    @Override
    public void onBindViewHolder(KitchenAdapter.ViewHolder holder, int position) {
        holder.mTitle.setText((String)mDataset.get(position).getTitle());

    }




    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    /**
     * Class for viewholder objects (the things displayed in the recycler list)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImage;
        public TextView mTitle;
        public TextView mBlurb;
        public ConstraintLayout mConstraintLayout;


        public ViewHolder(View v) {
            super(v);
            mImage = (ImageView) v.findViewById(R.id.miniImage);
            mTitle = (TextView) v.findViewById(R.id.miniTitle);
            mBlurb = (TextView) v.findViewById(R.id.miniBlurb);
            mConstraintLayout = (ConstraintLayout) v.findViewById(R.id.kitchenLayout);
        }
    }
}
