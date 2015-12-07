package istvan_torok.agenda.Entities;

/**
 * Created by Isti on 12/7/2015.
 */
public class Event {

    private long id;
    private String description;
    private long date;

    public Event() {}

    public Event(long pID) {
        this.id = pID;
    }

    public Event(String pDescription, Integer pDate) {
        this.description = pDescription;
        this.date = pDate;
    }

    public Event(Event pEvent){
        this(pEvent.id);
        this.description = pEvent.description;
        this.date = pEvent.date;
    }

    public String getDescription() {
        return description;
    }

    public long getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "[Event: " + this.description + "]";
    }
}
