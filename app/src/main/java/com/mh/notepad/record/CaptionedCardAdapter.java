package com.mh.notepad.record;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mh.notepad.AplicationData;
import com.mh.notepad.R;

import java.util.List;


public class CaptionedCardAdapter extends RecyclerView.Adapter<CaptionedCardAdapter.ViewHolder> {


    private String[] captions;
    private String[] body;
    private Listener listener;
    private List<Record> records;
    private RecordActivity recordActivity;

    interface Listener {
        void onClick(int position);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        TextView theme;
        TextView text;
        Button edit, delete;

        public ViewHolder(CardView cardView) {
            super(cardView);
            cardView = cardView;
            this.theme = (TextView) cardView.findViewById(R.id.theme_record);
            this.text = (TextView) cardView.findViewById(R.id.text_record);
            this.edit = (Button) cardView.findViewById(R.id.edit_record);
            this.delete = (Button) cardView.findViewById(R.id.edit_delete);
        }
    }

    public CaptionedCardAdapter(RecordActivity recordActivity, List<Record> records) {
        this.recordActivity = recordActivity;
        this.records = records;
    }


    @Override
    public int getItemCount() {
        return records.size();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public CaptionedCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Record record = records.get(position);

        TextView theme = holder.theme;
        TextView text = holder.text;
        Button edit = holder.edit;
        Button delete = holder.delete;

        theme.setText(record.getTheme());
        text.setText(record.getText());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent(recordActivity, CreatingRecordActivity.class);
                intent.putExtra("id", record.getId());
                recordActivity.startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
               new RecordDAO().removeRecord(AplicationData.user.getLogin(),record.getId());
               recordActivity.recreate();
            }
        });
//


    }
}
