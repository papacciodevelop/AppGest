package com.example.appgest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WorkersAdapter extends RecyclerView.Adapter<WorkersAdapter.ViewHolder> {

    private ArrayList<Worker> mWorkers;
    private Context mContext;

    public WorkersAdapter(Context context, ArrayList<Worker> workers) {
        mContext = context;
        mWorkers = workers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_worker, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Worker worker = mWorkers.get(position);

        holder.nameTextView.setText(worker.getNombre());
        holder.shiftTextView.setText(worker.getHorario());
        holder.positionTextView.setText(worker.getPuesto());

        holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataWorker dataWorker = new dataWorker(view.getContext());
                dataWorker.deleteWorker(worker.getId());
                mWorkers.remove(worker);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mWorkers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView shiftTextView;
        public TextView positionTextView;
        public ImageView deleteImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_text_view);
            shiftTextView = itemView.findViewById(R.id.shift_text_view);
            positionTextView = itemView.findViewById(R.id.position_text_view);
            deleteImageView = itemView.findViewById(R.id.delete_button);
        }
    }
}
