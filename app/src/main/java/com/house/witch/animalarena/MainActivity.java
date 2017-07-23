package com.house.witch.animalarena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public static final String VICTORIOUS_ANIMAL = "victorious animal";
    private ArrayList<Animal> animals;
    private FightProcessor fightProcessor;
    private Spinner animal1;
    private Spinner animal2;
    private Button fightButton;
    private AnimalDatabaseHelper animalDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalDb = new AnimalDatabaseHelper(this);

        animals = new ArrayList<Animal>();
        animals.add(new Animal("Panda"));
        animals.add(new Animal("Grizzly Bear"));

        fightProcessor = new FightProcessor();

        animal1 = (Spinner)findViewById(R.id.animal1);
        animal2 = (Spinner)findViewById(R.id.animal2);
        fightButton = (Button) findViewById(R.id.fight);

        animal1.setAdapter(new ArrayAdapter<Animal>(this, android.R.layout.simple_spinner_dropdown_item, animals));
        animal2.setAdapter(new ArrayAdapter<Animal>(this, android.R.layout.simple_spinner_dropdown_item, animals));

        fightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showFightResult(v);
            }
        });
    }

    public Animal getFightResult() {
        return fightProcessor.processFight(
                (Animal)animal1.getSelectedItem(),
                (Animal)animal2.getSelectedItem()
        );
    }

    public void showFightResult(View view) {
        Intent intent = new Intent(this, DisplayVictorActivity.class);
        intent.putExtra(VICTORIOUS_ANIMAL, getFightResult());
        startActivity(intent);
    }
}
