package mhjaso.com.jabbaproject.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import mhjaso.com.jabbaproject.Model.Character;
import mhjaso.com.jabbaproject.R;


public class ShowCharacter extends ActionBarActivity
{
    //region Attributes
        mhjaso.com.jabbaproject.Model.Character mCharacter = new Character("Jabba", "The Hutt");

    //endregion


    //region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_detail_layout);

        Intent intent = getIntent();
        if (intent != null) {
            Character character = (Character)intent.getSerializableExtra(Character.StringKey);
            syncModelWithView(character);
        }

    }


    protected void syncModelWithView(Character character)
    {
        if (character != null)
        {
            setCharacterNameOnTextView(character.getFullName());
            setCharacterPictureOnImageView("");
        }

    }

    //endregion





    //region Views

    protected void setCharacterNameOnTextView(String name)
    {
        TextView nameView = (TextView) findViewById(R.id.name);
        StringBuilder fullName = new StringBuilder();
        fullName.append("I am ").append(name);
        nameView.setText(fullName.toString());
    }

    protected void setCharacterPictureOnImageView(String photoName)
    {
        int photoId = getResources().getIdentifier(photoName, "id", "com.mhjaso.jabbaproject");
        ImageView picture = (ImageView) findViewById(R.id.picture);
        picture.setImageResource(photoId);
    }

    //endregion

}
