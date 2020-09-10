package com.masudin.crudretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masudin.crudretrofit.R;
import com.masudin.crudretrofit.model.Mahasiswa;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Mahasiswa> mahasiswas;

    public RecyclerAdapter(Context context, ArrayList<Mahasiswa> mahasiswas) {
        this.context = context;
        this.mahasiswas = mahasiswas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Mahasiswa mahasiswa = mahasiswas.get(position);
        holder.tvNim.setText(mahasiswa.getNim());
        holder.tvNama.setText(mahasiswa.getNama());
        holder.tvKelas.setText(mahasiswa.getKelas());
        holder.tvSesi.setText(mahasiswa.getSesi());
    }

    @Override
    public int getItemCount() {
        return mahasiswas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNim;
        TextView tvNama;
        TextView tvKelas;
        TextView tvSesi;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNim = itemView.findViewById(R.id.nim);
            tvNama = itemView.findViewById(R.id.nama);
            tvKelas = itemView.findViewById(R.id.kelas);
            tvSesi = itemView.findViewById(R.id.sesi);
        }
    }
}
