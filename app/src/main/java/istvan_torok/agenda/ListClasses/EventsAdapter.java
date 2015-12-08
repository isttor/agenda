package istvan_torok.agenda.ListClasses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import istvan_torok.agenda.Entities.Event;
import istvan_torok.agenda.R;

/**
 * Created by Isti on 12/8/2015.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventCardHolder> {

    private List<Event> mItems = new ArrayList<Event>();
    private final LayoutInflater mInflater;

    public EventsAdapter(final Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public EventCardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = mInflater.inflate(R.layout.event_item_layout, parent, false);
        return new EventCardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventCardHolder holder, int position) {
        holder.map(mItems.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setItems(final List<Event> pEvents) {
        mItems = pEvents;
        notifyDataSetChanged();
    }
}
