package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{

    public int compare(Media o1, Media o2) {
        int costComparison = Double.compare(o2.getCost(), o1.getCost());
        if (costComparison != 0) {
            return costComparison;
        }
        return o1.getTitle().compareTo(o2.getTitle());        
    }
}