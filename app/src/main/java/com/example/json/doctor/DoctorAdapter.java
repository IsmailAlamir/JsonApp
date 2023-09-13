package com.example.json.doctor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.json.R;

import java.util.ArrayList;
import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {
    // create the list to take the data to bind it to the view holder
    public List<Doctor> doctors= new ArrayList<>();


    // create a public constructor to be used in the activity (to set the data to the adapter)
    public DoctorAdapter(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_doctor,parent,false);

        //        DoctorViewHolder doctorViewHolder = new DoctorViewHolder(view);
        return  new DoctorViewHolder(view);
    }

    // this method will bind the data from the adapter to the view holder that we create
    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {

        holder.doctor=doctors.get(position);
        TextView name= holder.itemView.findViewById(R.id.doc);
        TextView spec= holder.itemView.findViewById(R.id.spec);

        name.setText(holder.doctor.name);
        spec.setText(holder.doctor.specialization);

    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }


    // create the view holder class (wrap the data and the view)
    //note : we create a static inner class inorder to create a view holder without create instances
    public static class DoctorViewHolder extends RecyclerView.ViewHolder{
        // create a model object
        public Doctor doctor;

        // create the view object
        View itemView;

        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;

        }



    }
}
