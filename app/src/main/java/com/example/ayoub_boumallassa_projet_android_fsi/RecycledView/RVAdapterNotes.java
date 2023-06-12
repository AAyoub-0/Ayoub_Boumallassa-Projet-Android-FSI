package com.example.ayoub_boumallassa_projet_android_fsi.RecycledView;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ayoub_boumallassa_projet_android_fsi.R;

import java.util.ArrayList;

import com.example.ayoub_boumallassa_projet_android_fsi.Entities.Notes;

public class RVAdapterNotes extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<Notes> mesNotes = new ArrayList<>();

    public RVAdapterNotes(Context context) {
        this.context = context;
    }

    public void setMesNotes(ArrayList<Notes> mesNotes){
        this.mesNotes = mesNotes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.rv_items_notes, parent, false);
        return new RVNotesItems(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RVNotesItems vh = (RVNotesItems) holder;
        Notes note = mesNotes.get(position);
        vh.lib.setText(note.lib_note);
        vh.not_ele.setText(String.format("%.2f", note.note_eleve) + " /20");
        vh.not_cla.setText(String.format("%.2f", note.moy_class) + " /20");
        vh.not_min.setText(String.valueOf(note.min));
        vh.not_max.setText(String.format("%.2f", note.max));
        vh.not_rem.setText(note.remarque);

        vh.note_eleve_dos.setText(String.format("%.2f", note.not_eleve_dos) + " /20");
        vh.note_classe_dos.setText(String.format("%.2f", note.not_classe_dos) + " /20");
        vh.note_min_dos.setText(String.format("%.2f", note.not_min_dos) + " /20");
        vh.note_max_dos.setText(String.format("%.2f", note.not_max_dos) + " /20");

        vh.note_eleve_ora.setText(String.format("%.2f", note.not_eleve_ora) + " /20");
        vh.note_classe_ora.setText(String.format("%.2f", note.not_classe_ora) + " /20");
        vh.note_min_ora.setText(String.format("%.2f", note.not_min_ora) + " /20");
        vh.note_max_ora.setText(String.format("%.2f", note.not_max_ora) + " /20");

        vh.note_eleve_ent.setText(String.format("%.2f", note.not_eleve_ent) + " /20");
        vh.note_classe_ent.setText(String.format("%.2f", note.not_classe_ent) + " /20");
        vh.note_min_ent.setText(String.format("%.2f", note.not_min_ent) + " /20");
        vh.note_max_ent.setText(String.format("%.2f", note.not_max_ent) + " /20");

        vh.not_plus.setOnClickListener(v -> {
            if (vh.layout.getVisibility() == View.GONE){
                vh.layout.setVisibility(View.VISIBLE);
                vh.not_plus.setTextColor(Color.BLACK);
            }else{
                vh.layout.setVisibility(View.GONE);
                vh.not_plus.setTextColor(Color.parseColor("#cacaca"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.mesNotes.size();
    }

    // class initialise la vue qui se répète
    public static class RVNotesItems extends RecyclerView.ViewHolder{

        public TextView lib, not_ele, not_cla, not_min, not_max, not_rem, not_plus,
                note_eleve_dos, note_classe_dos, note_min_dos, note_max_dos,
                note_eleve_ora, note_classe_ora, note_min_ora, note_max_ora,
                note_eleve_ent, note_classe_ent, note_min_ent, note_max_ent;

        private LinearLayout layout;

        public RVNotesItems(@NonNull View itemView) {
            super(itemView);

            this.lib = itemView.findViewById(R.id.note_lib);
            this.not_ele = itemView.findViewById(R.id.note_eleve);
            this.not_cla = itemView.findViewById(R.id.note_classe);
            this.not_min = itemView.findViewById(R.id.note_min);
            this.not_max = itemView.findViewById(R.id.note_max);
            this.not_rem = itemView.findViewById(R.id.not_rem);
            this.not_plus = itemView.findViewById(R.id.not_plus);

            this.note_eleve_dos = itemView.findViewById(R.id.note_eleve_dos);
            this.note_classe_dos = itemView.findViewById(R.id.note_classe_dos);
            this.note_min_dos = itemView.findViewById(R.id.note_min_dos);
            this.note_max_dos = itemView.findViewById(R.id.note_max_dos);

            this.note_eleve_ora = itemView.findViewById(R.id.note_eleve_ora);
            this.note_classe_ora = itemView.findViewById(R.id.note_classe_ora);
            this.note_min_ora = itemView.findViewById(R.id.note_min_ora);
            this.note_max_ora = itemView.findViewById(R.id.note_max_ora);

            this.note_eleve_ent = itemView.findViewById(R.id.note_eleve_ent);
            this.note_classe_ent = itemView.findViewById(R.id.note_classe_ent);
            this.note_min_ent = itemView.findViewById(R.id.note_min_ent);
            this.note_max_ent = itemView.findViewById(R.id.note_max_ent);

            this.layout = itemView.findViewById(R.id.layout_plus);
        }
    }


}
