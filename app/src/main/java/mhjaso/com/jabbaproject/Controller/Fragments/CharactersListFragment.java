package mhjaso.com.jabbaproject.Controller.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import mhjaso.com.jabbaproject.Controller.ShowCharacter;
import mhjaso.com.jabbaproject.Model.Character;
import mhjaso.com.jabbaproject.R;



public class CharactersListFragment extends ListFragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        final View rootView = inflater.inflate(R.layout.characters_fragment, container, false);

        ArrayList characters = charactersArray();
        bindCharactersToListView( characters );

        return rootView;
    }

    //region Characters

    private ArrayList<Character> charactersArray()
    {
        Character jabba = new Character("Jabba", "The Hutt");
        Character luke = new Character("Luke Skywalker", null);
        Character r2d2 = new Character(null, "R2-D2");
        Character greedo = new Character("Greedo", null);
        Character vader = new Character("Anakin Skywalker", "Lord Vader");

        ArrayList<Character> starWarsCharacters = new ArrayList();
        starWarsCharacters.add(jabba);
        starWarsCharacters.add(luke);
        starWarsCharacters.add(r2d2);
        starWarsCharacters.add(greedo);
        starWarsCharacters.add(vader);

        return starWarsCharacters;
    }

    private void bindCharactersToListView(ArrayList<Character> characters)
    {
        ArrayAdapter<Character> charactersAdapter = new ArrayAdapter<> ( getActivity(), android.R.layout.simple_list_item_1, characters );
        setListAdapter(charactersAdapter);
    }

    //endregion



    //region TableView

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        ArrayAdapter charactersAdapter = (ArrayAdapter) getListAdapter();
        Character selectedCharacter = (Character) charactersAdapter.getItem(position);
        //Character selectedCharacter = this.characters.get(position);
        performIntentToDetail(selectedCharacter);
    }

    //endregion


    //region Navigation

    private void performIntentToDetail(Character character)
    {
        Intent detailIntent = new Intent(getActivity(), ShowCharacter.class);
        detailIntent.putExtra(Character.StringKey, character);
        startActivity(detailIntent);
    }

    //endregion

}
