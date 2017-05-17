package se.kth.ict.nextgenpos.view;

import java.util.ArrayList;
import java.util.List;
import se.kth.ict.nextgenpos.model.ItemNotFoundException;
import se.kth.ict.nextgenpos.model.SalesLineItem;
import se.kth.ict.nextgenpos.model.SalesObserver;

/**
 * Created by nicla on 2017-05-17.
 *
 * this is the class that represent a display showing the item registered.
 */
public class SalesItemDisplay implements SalesObserver{

    private ArrayList<SalesLineItem> noOfItemsRegistered = new ArrayList<>();

    /**
     *  Request to add new item in a list and ask for printout.
     *
     * @param lineItem the item.
     * @throws ItemNotFoundException if the item id doesn't exsist.
     */

    @Override
        public void newItem(SalesLineItem lineItem) throws ItemNotFoundException{
        addNewItem(lineItem);
        printCurrentState(noOfItemsRegistered);
    }

    /**
     * Adds a new item in a salesLineItem list.
     * @param lineItem  the specifide item.
     * @throws ItemNotFoundException    if the item id doesn't exist.
     */
    private void addNewItem(SalesLineItem lineItem) throws ItemNotFoundException{
        boolean listUppdated = false;
        for (int i = 0; i < noOfItemsRegistered.size(); i++){
            if (lineItem.getSpec().getProductId() == noOfItemsRegistered.get(i).getSpec().getProductId()){
                noOfItemsRegistered.set(i, new SalesLineItem(lineItem.getSpec(), noOfItemsRegistered.get(i).getQuantity() + 1));
                listUppdated = true;
            }
        }
        if (listUppdated == false){
            noOfItemsRegistered.add(lineItem);
        }
    }

    /**
     *  Print the current catalog list.
     * @param noOfItemsRegistered   the items in the list.
     * @throws ItemNotFoundException if the item dont exist in the catalog.
     */
    public void printCurrentState(List<SalesLineItem> noOfItemsRegistered) throws ItemNotFoundException{
        System.out.println("### The item registered in the product catalog: ###");
        for (int i = 0; i < noOfItemsRegistered.size(); i++){
            System.out.println("Quantity: " + noOfItemsRegistered.get(i).getQuantity() + "\t Product ID: " + noOfItemsRegistered.get(i).getSpec().getProductId() +
                    "\t Product name: " + noOfItemsRegistered.get(i).getSpec().getName());
        }
    }

}
