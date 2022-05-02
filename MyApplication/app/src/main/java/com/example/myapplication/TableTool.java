package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TableTool {
    private final LayoutInflater inflater;
    private final TableTool schedule;

    public TableTool(Context context, TableTool schedule) {
        this.schedule = schedule;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View day = inflater.inflate(R.layout.recyclerview_day_item, parent, false);
        return new ViewHolder(day);
    }

    @Override
    public void onBindViewHolder(@NonNull TableTool.ViewHolder holder, int position) {
        TableDay day = schedule.days.get(position);
        if (day.Filial) {
            holder.filial.setText("Нахимовский");
        }

        for (int i = 0; i < TablePage.ElementCount - 1; i++) {
            android.view.View row = inflater.inflate(R.layout.tablerow_pair, null, false);
            TextView pairNumber = (TextView) row.findViewById(R.id.number_tv);
            pairNumber.setText(Integer.toString(i + 1));
            for (MainActivity pair : day.pairs) {
                if (pair.pairNumber == i) {
                    if (pair.predmetNumber != null) {
                        TextView pairDiscipline = (TextView) row.findViewById(R.id.discipline_tv);
                        pairDiscipline.setText(pair.predmetNumber.name);
                        TextView pairTeacher = (TextView) row.findViewById(R.id.teacher_tv);
                        pairTeacher.setText(pair.predmetNumber.teacher);
                    }
                }
            }

            holder.table.addView(row);
        }

    }

    @Override
    public int getItemCount() {return schedule.days.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TableLayout table;
        final TextView filial;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            filial = itemView.findViewById(R.id.is_filial_tv);
            table = itemView.findViewById(R.id.schedule_day_tl);
        }
    }
}

