package com.infs3202.wfd.whatsfordinner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by s4285131 on 25/05/2018.
 */

public class IngrSelectAdapter extends RecyclerView.Adapter<IngrSelectAdapter.ViewHolder>{
    private List<String> mDataset;
    private Context mContext;

    public IngrSelectAdapter(Context context, List<String> list){
        mDataset = list;
        mContext = context;
    }

    /**
     * Creates new views (invoked by layout manager)
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create a new view
        View v = LayoutInflater.from(mContext).inflate(R.layout.ingredient_item_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.mTextView.setText((String)mDataset.get(position));

        holder.mTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String ingredient = mDataset.get(position);
                Toast.makeText(mContext,ingredient, Toast.LENGTH_SHORT).show();
            }
        });

        holder.mRemoveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String itemLabel = mDataset.get(position);
                mDataset.remove(position);

                notifyItemRemoved(position);

                notifyItemRangeChanged(position, mDataset.size());

                Toast.makeText(mContext, "Removed: " + itemLabel, Toast.LENGTH_SHORT).show();

            }
        });

    }

    /**
     * returns the size of the dataset (invoked by the layout manager)
     * @return
     */
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    /**
     * Class for viewholder objects (the things displayed in the recycler list)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public Button mRemoveButton;
        public LinearLayout mLinearLayout;


        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.ingredient);
            mRemoveButton = (Button) v.findViewById(R.id.delete_btn);
            mLinearLayout = (LinearLayout) v.findViewById(R.id.layout);
        }
    }



}
