package vidu.demo.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

import vidu.demo.myapplication.Model.ImagePhoto;
import vidu.demo.myapplication.R;

public class AdapterPhoto extends PagerAdapter {
    private Context context;
    private List<ImagePhoto> list;

    public AdapterPhoto(Context context, List<ImagePhoto> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size ();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from (container.getContext ()).inflate (R.layout.item_photo,container,false);
        ImageView imageView = view.findViewById (R.id.image_chuyen_anh);

        ImagePhoto photo = list.get (position);
        Glide.with (context).load (photo.getIdimage ()).into (imageView);

        container.addView (view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView ((View) object);

    }
}
