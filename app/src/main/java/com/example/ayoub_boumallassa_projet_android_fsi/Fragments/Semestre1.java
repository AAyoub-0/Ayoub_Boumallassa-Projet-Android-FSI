package com.example.ayoub_boumallassa_projet_android_fsi.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Etudiant;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Note1;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Notes;
import com.example.ayoub_boumallassa_projet_android_fsi.R;
import com.example.ayoub_boumallassa_projet_android_fsi.RecycledView.RVAdapterNotes;
import com.example.ayoub_boumallassa_projet_android_fsi.SQLite.SQLiteDatabaseManager;

import java.util.ArrayList;


public class Semestre1 extends Fragment {

    private View view;
    private RecyclerView rv;
    private RVAdapterNotes adapter;
    private ArrayList<Notes> mesNotes = new ArrayList<>();
    private Note1 note1;
    private SQLiteDatabaseManager db;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_semestre1, container, false);

        rv = view.findViewById(R.id.notes_rv);
        db = new SQLiteDatabaseManager(getContext());

        db.open();
        note1 = db.readNote1();

        float moyenne = moyenneNote(note1.getNot_dos_not(), note1.getNot_ora_not(), note1.getNot_ent_not());
        float moyenne_dos = moyenneNote(note1.getNot_dos_not(), note1.getNot_dos_not(), note1.getNot_dos_not());
        float moyenne_ora = moyenneNote(note1.getNot_ora_not(), note1.getNot_ora_not(), note1.getNot_ora_not());
        float moyenne_ent = moyenneNote(note1.getNot_ent_not(), note1.getNot_ent_not(), note1.getNot_ent_not());

        Notes notes = new Notes("Bilan 1", moyenne, 0, 0, moyenne,
                note1.getNot_dos_not(), moyenne_dos, note1.getNot_dos_not(), moyenne_dos,
                note1.getNot_ora_not(), moyenne_ora, note1.getNot_ora_not(), moyenne_ora,
                note1.getNot_ent_not(), moyenne_ent, note1.getNot_ent_not(), moyenne_ent,
                note1.getRem_not_bil_1());
        mesNotes.add(notes);

        rv.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
        rv.setLayoutManager(manager);
        adapter = new RVAdapterNotes(view.getContext());
        adapter.setMesNotes(mesNotes);
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        System.out.println();
        for (Notes note : mesNotes){
            System.out.println(note.ToString());
        }

        return view;
    }

    private float moyenneNote(float not1, float not2, float not3){
        return (not1 + not2 + not3) / 3;
    }

    private float moyenneEleve(float[] notes){
        int nb_not = 0;
        float tot = 0;
        for (float note : notes){
            nb_not ++;
            tot += note;
        }
        return tot;
    }
}