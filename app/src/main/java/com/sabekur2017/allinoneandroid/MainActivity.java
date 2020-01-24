package com.sabekur2017.allinoneandroid;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.sabekur2017.allinoneandroid.adapter.FragmentAdapter;
import com.sabekur2017.allinoneandroid.adapter.SectionedGridRecyclerViewAdapter;
import com.sabekur2017.allinoneandroid.adapter.SimpleAdapter;
import com.sabekur2017.allinoneandroid.fragments.HomeFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActionBar actionBar;
    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private SimpleAdapter mAdapter;
    private SectionedGridRecyclerViewAdapter sectionedGridRecyclerViewAdapter;
    //view pager a
    ViewPager viewPager;
    TabLayout tabLayout;
    ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initNavigationMenu();
        viewPager=findViewById(R.id.pager);
        tabLayout=findViewById(R.id.tabLayout);
        fragments =new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        FragmentAdapter fragmentAdapter=new FragmentAdapter(getSupportFragmentManager(), getApplicationContext(), fragments);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_home_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_home_black_24dp);

       /* //Your RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,4));

        //Your RecyclerView.Adapter
        mAdapter = new SimpleAdapter(this);
        // onclick in grid item




        //This is the code to provide a sectioned grid
        List<SectionedGridRecyclerViewAdapter.Section> sections =
                new ArrayList<SectionedGridRecyclerViewAdapter.Section>();
        List<SectionedGridRecyclerViewAdapter.Section> sectionList=new ArrayList<>();
        for(SectionedGridRecyclerViewAdapter.Section  section :sectionList){
            sectionList.add(new SectionedGridRecyclerViewAdapter.Section(section.getTitle()));
        }

        //Sections
        sections.add(new SectionedGridRecyclerViewAdapter.Section(0,"Section 1"));
        sections.add(new SectionedGridRecyclerViewAdapter.Section(5,"Section 2"));
        sections.add(new SectionedGridRecyclerViewAdapter.Section(12,"Section 3"));
        sections.add(new SectionedGridRecyclerViewAdapter.Section(14,"Section 4"));
        sections.add(new SectionedGridRecyclerViewAdapter.Section(20,"Section 5"));

        //Add your adapter to the sectionAdapter
        SectionedGridRecyclerViewAdapter.Section[] dummy = new SectionedGridRecyclerViewAdapter.Section[sections.size()];
        SectionedGridRecyclerViewAdapter mSectionedAdapter = new
                SectionedGridRecyclerViewAdapter(this,R.layout.section,R.id.section_text,mRecyclerView,mAdapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        //Apply this adapter to the RecyclerView
        mRecyclerView.setAdapter(mSectionedAdapter);*/

    }
    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("All Items");

    }
    private void initNavigationMenu() {
        final NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                updateCounter(nav_view);
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem item) {

               Toast.makeText(getApplicationContext(), item.getTitle() + " Selected", Toast.LENGTH_SHORT).show();
                actionBar.setTitle(item.getTitle());
                drawer.closeDrawers();
                return true;
            }
        });

        // open drawer at start
        drawer.openDrawer(GravityCompat.START);
        updateCounter(nav_view);
    }
    private void updateCounter(NavigationView nav) {
        Menu m = nav.getMenu();
        ((TextView) m.findItem(R.id.nav_all_inbox).getActionView().findViewById(R.id.text)).setText("75");
        ((TextView) m.findItem(R.id.nav_inbox).getActionView().findViewById(R.id.text)).setText("68");

        TextView badgePrioInbx = (TextView) m.findItem(R.id.nav_priority_inbox).getActionView().findViewById(R.id.text);
        badgePrioInbx.setText("3 new");
        badgePrioInbx.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        TextView badgeSocial = (TextView) m.findItem(R.id.nav_social).getActionView().findViewById(R.id.text);
        badgeSocial.setText("51 new");
        badgeSocial.setBackgroundColor(getResources().getColor(R.color.green_500));

        ((TextView) m.findItem(R.id.nav_spam).getActionView().findViewById(R.id.text)).setText("13");
    }
    private void initComponent(){

    }
}
