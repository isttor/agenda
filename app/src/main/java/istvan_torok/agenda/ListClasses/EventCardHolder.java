package istvan_torok.agenda.ListClasses;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import istvan_torok.agenda.Entities.Event;
import istvan_torok.agenda.R;

/**
 * Created by Isti on 12/8/2015.
 */
public class EventCardHolder extends RecyclerView.ViewHolder {
    private TextView descriptionLabel;
    private TextView dateLabel;

    public EventCardHolder(View itemView) {
        super(itemView);

        descriptionLabel = (TextView) itemView.findViewById(R.id.descriptionLabel);
        dateLabel = (TextView) itemView.findViewById(R.id.dateLabel);
    }

    public void map(final Event item, final int position) {
        descriptionLabel.setText(item.getDescription());
        Date lDate = new Date(item.getDate());
        String lFormattedDate = new SimpleDateFormat("EEE, MMM d, yyyy").format(lDate);
        dateLabel.setText(lFormattedDate);
    }
}
