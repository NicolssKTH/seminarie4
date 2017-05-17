package se.kth.ict.nextgenpos.model;

/**
 * Created by nicla on 2017-05-17.
 *
 *
 * A listener interface for receiving notifications about
 * items added in the product catalog. The class that is interested in such
 * notifications implements this interface, and the object
 * created with that class is registered with
 * <code>addItemObserver</code>. When an item is registered, that
 * object’s <code>newItem</code> method is invoked.
 */

public interface SalesObserver {
    /**
     *
     * @param lineItem the item.
     * @throws ItemNotFoundException
     */
    void newItem(SalesLineItem lineItem) throws ItemNotFoundException;
}
