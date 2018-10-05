package com.altimetrik.donorschoose.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.altimetrik.donorschoose.R;
import com.altimetrik.donorschoose.data.Proposal;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by José Guadalupe Mandujano on 10/5/18.
 */
class DonorsRecyclerAdapter extends RecyclerView.Adapter<DonorsRecyclerAdapter.ViewHolder> {
    private final Context context;
    private final List<Proposal> proposals;
    private final LayoutInflater layoutInflater;

    public DonorsRecyclerAdapter(Context context, List<Proposal> proposals) {

        this.context = context;
        this.proposals = proposals;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.proposal_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Proposal item = proposals.get(i);
        viewHolder.title.setText(item.getTitle());
        viewHolder.description.setText(item.getShortDescription());
        viewHolder.teacher.setText(item.getTeacherId());
        viewHolder.address.setText(item.getSchoolName());
        try {
            Glide.with(context).load(item.getImageURL()).into(viewHolder.img);
            viewHolder.progressBar.setProgress((int) Double.parseDouble(item.getPercentFunded()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return proposals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView title;
        public final TextView address;
        public final TextView teacher;
        public final TextView description;
        public final ImageView img;
        public final ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
            description = itemView.findViewById(R.id.txtDescription);
            teacher = itemView.findViewById(R.id.txtTeacher);
            address = itemView.findViewById(R.id.txtLocation);
            img = itemView.findViewById(R.id.imgIcon);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }
}
