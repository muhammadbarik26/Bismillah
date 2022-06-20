package com.example.bismillah;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context context;
    private List<User> list;
    private Dialog dialog;

    public interface Dialog{
        void onClick(int pos);
    }
    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public UserAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvNama.setText(list.get(position).getNama());
        holder.tvNIK.setText(list.get(position).getNik());
        holder.tvPenumpang.setText(list.get(position).getJmlhpenumpang());
        holder.tvKelamin.setText(list.get(position).getKelamin());
        holder.tvAsal.setText(list.get(position).getAsal());
        holder.tvTujuan.setText(list.get(position).getTujuan());
        holder.tvMaskapai.setText(list.get(position).getMaskapai());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvNIK, tvPenumpang, tvKelamin, tvAsal, tvTujuan, tvMaskapai;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama   = itemView.findViewById(R.id.Nama);
            tvNIK   = itemView.findViewById(R.id.nik);
            tvPenumpang = itemView.findViewById(R.id.jmlPenumpang);
            tvKelamin = itemView.findViewById(R.id.spnkelamin);
            tvAsal = itemView.findViewById(R.id.spnasal);
            tvTujuan = itemView.findViewById(R.id.spntujuan);
            tvMaskapai = itemView.findViewById(R.id.spnmaskapai);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dialog != null) {
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });

        }
    }
}

