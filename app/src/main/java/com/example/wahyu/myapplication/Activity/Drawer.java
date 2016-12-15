package com.example.wahyu.myapplication.Activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;

import com.example.wahyu.myapplication.R;
import com.example.wahyu.myapplication.fragments.CardFragment;
import com.example.wahyu.myapplication.fragments.NavigationDrawerFragment;
import com.example.wahyu.myapplication.fragments.SettingsFragment;
import com.example.wahyu.myapplication.fragments.TagihanFragment;
import com.example.wahyu.myapplication.fragments.WelcomeFragment;

public class Drawer extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private static final String TAG = "Drawer";

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                               .replace(R.id.container, new WelcomeFragment())
                               .commit();
        // Tambahakan
    }

  //  @Override
  //  public void onNavigationDrawerItemSelected(int position) {
  //      // update the main content by replacing fragments
  //      FragmentManager fragmentManager = getFragmentManager();
  //      fragmentManager.beginTransaction()
   //             .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
   //             .commit();
   // }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(!getString(R.string.action_settings).equals(item.getTitle())) {
            Log.d(TAG, "Menu Item : "+item.getTitle());
            return false;
        }

        // tambahkan action handler untuk button settings
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, new SettingsFragment())
                .commit();
        return true;
    }


  @Override
  public void onNavigationDrawerItemSelected(int position) {
      Fragment fr = null;
      switch (position) {
          case 0:
              fr = new TagihanFragment();
              break;
          case 1:
              fr = new CardFragment();
              break;
          default:
              fr = new WelcomeFragment();
              break;
      }
      FragmentManager fragmentManager = getFragmentManager();
      fragmentManager.beginTransaction()
              .replace(R.id.container, fr)
              .commit();
  }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.lblTagihan);
                break;
            case 2:
                mTitle = getString(R.string.lblCard);
                break;
            case 3:
                mTitle = getString(R.string.lbllogout);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
//    public static class PlaceholderFragment extends Fragment {
//        /**
//         * The fragment argument representing the section number for this
//         * fragment.
//         */
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        public PlaceholderFragment() {
//        }
//
//        /**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         */
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_drawer, container, false);
//            return rootView;
//        }
//
//        @Override
//        public void onAttach(Activity activity) {
//            super.onAttach(activity);
//            ((Drawer) activity).onSectionAttached(
//                    getArguments().getInt(ARG_SECTION_NUMBER));
//        }
//    }

}
