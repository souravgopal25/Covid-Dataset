package com.example.covid_dataset.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_dataset.R;
import com.example.covid_dataset.model.Data;

import java.util.ArrayList;
import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.StateAdapterViewHolder> {
    private  Context context;
    private List<Data.StatewiseBean> mlist;
    private  ListItemClickListener mitemClickListener;

    public StateAdapter(Context context, ListItemClickListener mitemClickListener) {
        this.context = context;
        this.mlist = new ArrayList<>();
        this.mitemClickListener = mitemClickListener;
    }

    public void setMlist(List<Data.StatewiseBean> mlist) {
        this.mlist = mlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StateAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item, parent, false);
        return new StateAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateAdapterViewHolder holder, int position) {
        Data.StatewiseBean obj=mlist.get(position);
        holder.state.setText(obj.getState());
        holder.active.setText(obj.getActive());
        holder.deceased.setText(obj.getDeaths());
        holder.total.setText(obj.getConfirmed());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
    public interface ListItemClickListener{
        void onItemClick(int clickedindex);
    }

    public class StateAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView total,active,deceased,state;

        public StateAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            total=itemView.findViewById(R.id.total);
            active=itemView.findViewById(R.id.active);
            deceased=itemView.findViewById(R.id.deceased);
            state=itemView.findViewById(R.id.state);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clicked=getAdapterPosition();
            mitemClickListener.onItemClick(clicked);


        }
    }
}
