package com.example.ayoub_boumallassa_projet_android_fsi.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Note2;
import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Notes;
import com.example.ayoub_boumallassa_projet_android_fsi.R;
import com.example.ayoub_boumallassa_projet_android_fsi.RecycledView.RVAdapterNotes;
import com.example.ayoub_boumallassa_projet_android_fsi.SQLite.SQLiteDatabaseManager;
import java.util.ArrayList;

public class Semestre2 extends Fragment {

    private View view;
    private RecyclerView rv;
    private RVAdapterNotes adapter;
    private ArrayList<Notes> mesNotes = new ArrayList<>();
    private Note2 note2;
    private SQLiteDatabaseManager db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_semestre2, container, false);

        rv = view.findViewById(R.id.notes_rv);
        db = new SQLiteDatabaseManager(getContext());

        db.open();
        note2 = db.readNote2();

        float moyenne = moyenneNote(note2.getNot_dos_not_2(), note2.getNot_ora_not_2(), note2.getNot_ent_not_2());
        float moyenne_dos = moyenneNote(note2.getNot_dos_not_2(), note2.getNot_dos_not_2(), note2.getNot_dos_not_2());
        float moyenne_ora = moyenneNote(note2.getNot_ora_not_2(), note2.getNot_ora_not_2(), note2.getNot_ora_not_2());
        float moyenne_ent = moyenneNote(note2.getNot_ent_not_2(), note2.getNot_ent_not_2(), note2.getNot_ent_not_2());

        Notes notes = new Notes("Bilan 2", moyenne, 0, 0, moyenne,
                note2.getNot_dos_not_2(), moyenne_dos, note2.getNot_dos_not_2(), moyenne_dos,
                note2.getNot_ora_not_2(), moyenne_ora, note2.getNot_ora_not_2(), moyenne_ora,
                note2.getNot_ent_not_2(), moyenne_ent, note2.getNot_ent_not_2(), moyenne_ent,
                note2.getRem_not_bil_2());
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
}