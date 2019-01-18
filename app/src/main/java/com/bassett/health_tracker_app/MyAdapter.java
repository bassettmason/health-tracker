package com.bassett.health_tracker_app;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Exercise> values;

    public class ViewHolder extends RecyclerView.ViewHolder {
        // need to change date to date eventually
        public TextView titleText;
        public TextView descriptionText;
        public TextView dateText;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            titleText = v.findViewById(R.id.titleTextView);
            descriptionText = v.findViewById(R.id.descriptionTextView);
            dateText = v.findViewById(R.id.dateTextView);
        }
    }

    public void add(int position, Exercise exercise) {
        values.add(position, exercise);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public MyAdapter(List<Exercise> myData) {
        values = myData;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.recycler_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Exercise exercise = values.get(position);
        holder.titleText.setText(exercise.title + ", " + exercise.quantity );
        holder.descriptionText.setText("Diary Entry: " + exercise.description);
        holder.dateText.setText(exercise.timestamp);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
