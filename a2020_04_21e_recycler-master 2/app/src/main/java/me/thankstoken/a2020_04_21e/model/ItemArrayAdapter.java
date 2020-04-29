package me.thankstoken.a2020_04_21e.model;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

import me.thankstoken.a2020_04_21e.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder> {


    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private int listItemLayout;
    private ArrayList<Radio> radioList;
    // Constructor of the class
    public ItemArrayAdapter(int layoutId, ArrayList<Radio> radioList) {
        listItemLayout = layoutId;
        this.radioList = radioList;
    }

    @Override
    public int getItemCount() {
        return radioList == null ? 0 : radioList.size();
    }

    // specify the row layout file and click for each row
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView item = holder.item;
        ImageView picture = holder.image;
        item.setText(radioList.get(listPosition).getName());
        picture.setImageResource(radioList.get(listPosition).getImage());
    }

    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public int numberOfClicks = 0;
        public TextView item;
        public ImageView image;
        public Button button;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            item = (TextView) itemView.findViewById(R.id.row_item);
            image = (ImageView) itemView.findViewById(R.id.dog_pic);
            button = (Button) itemView.findViewById(R.id.rbutton);
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + item.getText());
            if(button.isClickable()){
                numberOfClicks = numberOfClicks + 1;
                button.setText("Pause");
            }
            else if (numberOfClicks % 2 == 0){
                button.setText("Play");
            }


        }
    }
}