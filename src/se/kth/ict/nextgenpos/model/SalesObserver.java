package se.kth.ict.nextgenpos.model;

/**
 * Created by nicla on 2017-05-17.
 */
public interface SalesObserver {
    /**
     *
     * @param lineItem the item.
     * @throws ItemNotFoundException
     */
    void newItem(SalesLineItem lineItem) throws ItemNotFoundException;
}
