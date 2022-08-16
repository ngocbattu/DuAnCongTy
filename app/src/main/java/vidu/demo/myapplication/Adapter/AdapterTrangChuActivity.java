package vidu.demo.myapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vidu.demo.myapplication.FragMent.CalendarFragment;
import vidu.demo.myapplication.FragMent.DiscoverFragment;
import vidu.demo.myapplication.FragMent.HomeFragment;
import vidu.demo.myapplication.FragMent.ProfileFragment;

public class AdapterTrangChuActivity extends FragmentStateAdapter {

    public AdapterTrangChuActivity(@NonNull FragmentActivity fragmentActivity) {
        super (fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 :
                return new HomeFragment ();
            case 1:
                return new CalendarFragment ();
            case 2:
                return new DiscoverFragment ();
            case 3 :
                return new ProfileFragment ();
            default:
                return new HomeFragment ();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
