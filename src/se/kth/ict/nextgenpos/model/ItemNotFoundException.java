package se.kth.ict.nextgenpos.model;

/**
 * Created by nicla on 2017-05-16.
 *
 * Thrown when entering a product that does not exist.
 */
public class ItemNotFoundException extends Exception {

    /**
     * Create a new instance with a message specifying for which item that not exist.
     *
     * @param message the message that explain what went wrong.
     */
    public ItemNotFoundException(String message){
        super(message);
    }


}
