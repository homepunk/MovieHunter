package homepunk.lesson.first.presenter;

import android.support.design.widget.FloatingActionButton;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import homepunk.lesson.first.adapter.TVListAdapter;
import homepunk.lesson.first.model.TVSeries;
import homepunk.lesson.first.ui.main.MainActivity;

public interface Presenter {

    interface NavDrawerPresenter {
        MainActivity view = null;

        void setUpNavDrawer();

        void onBackPressed();

        boolean onCreateOptionsMenu(Menu menu);

        public boolean onOptionsItemSelected(MenuItem item);

    }

    interface TabsPresenter {
        MainActivity view = null;

        void setUpTabs();

        void setUpTabIcons();
    }

    interface RecycleViewPresenter {
        void setUpRecycleView();

        void setUpPosters();

        TVListAdapter getAdapter();
    }

    interface DetailedActivityPresenter {
        int getDataFromIntent();

        void putDataFromIntentToBundle();

        void sendDataToFragment(int id);

        void sendDataToFragment();
    }

    interface DetailedFragmentPresenter {
        void getDetailedFromNetwork();

        void update(TVSeries tvSeries);

        void setDetailedInfo();

    }

    interface FabPresenter {

        void setMainFabClickListener(FloatingActionButton fab);

        void setFabsClickListeners(FloatingActionButton fab, FloatingActionButton fab1,
                                   FloatingActionButton fab2);
        void loadFabAnimation();
    }

    interface CustomShadedPresenter {
        void addView(RelativeLayout layout);

        int getMarginTop();

        int getMarginRight();
    }
}