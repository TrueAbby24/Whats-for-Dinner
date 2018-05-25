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

/**
 * Created by s4285131 on 25/05/2018.
 */

public class IngrResultAdapter extends RecyclerView.Adapter<IngrResultAdapter.ViewHolder> {
    private List<String> mDataset;
    private Context mContext;

    public IngrResultAdapter(Context context, List<String> list) {
        mDataset = list;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.recipe_mini_layout, parent, false);
        IngrResultAdapter.ViewHolder vh = new IngrResultAdapter.ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(IngrResultAdapter.ViewHolder holder, int position) {
        holder.mTitle.setText((String)mDataset.get(position));

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
            mConstraintLayout = (ConstraintLayout) v.findViewById(R.id.layout);
        }
    }
}
