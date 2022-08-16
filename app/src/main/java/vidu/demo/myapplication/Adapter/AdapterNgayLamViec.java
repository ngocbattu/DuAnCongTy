package vidu.demo.myapplication.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vidu.demo.myapplication.Model.NgayCongViec;
import vidu.demo.myapplication.R;

public class AdapterNgayLamViec extends RecyclerView.Adapter<AdapterNgayLamViec.ViewHodelNgayLamViec>{

    private Context context;
    private List<NgayCongViec> list;

    public AdapterNgayLamViec(Context context, List<NgayCongViec> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHodelNgayLamViec onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (context).inflate (R.layout.item_recy_view_ngay_lam_viec,null);
        return new ViewHodelNgayLamViec (view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodelNgayLamViec holder, int position) {
        NgayCongViec congViec = list.get (position);
        holder.txt_so_ngay.setText ("0" + congViec.getSoNgay ()+"");
        holder.txt_ten_ngay.setText (congViec.getTenNgay ());
        holder.txt_trang_thai.setText (congViec.getTrangThai ());
    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    class ViewHodelNgayLamViec extends RecyclerView.ViewHolder{
        TextView txt_so_ngay , txt_ten_ngay , txt_trang_thai;
        public ViewHodelNgayLamViec(@NonNull View itemView) {
            super (itemView);
            txt_so_ngay = itemView.findViewById (R.id.txt_so_ngay);
            txt_ten_ngay = itemView.findViewById (R.id.txt_ten_ngay);
            txt_trang_thai = itemView.findViewById (R.id.txt_trang_thai);
        }
    }
}
