package mhjaso.com.jabbaproject.Controller;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import mhjaso.com.jabbaproject.Controller.Fragments.CharactersListFragment;
import mhjaso.com.jabbaproject.R;

;


public class ListCharacters extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characters_list_activity_layout);

        if (savedInstanceState != null) {
            return;
        }

        addCharactersFragmentToActivity(R.id.characters_fragment_container);
    }




    private void addCharactersFragmentToActivity(int fragmentContainerId)
    {
        if (findViewById(fragmentContainerId) != null)
        {
            CharactersListFragment charactersFragment = new CharactersListFragment();

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(fragmentContainerId, charactersFragment);
            fragmentTransaction.commit();
        }
    }


}
