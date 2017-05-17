package se.kth.ict.nextgenpos.view;

import se.kth.ict.nextgenpos.controller.Controller;
import se.kth.ict.nextgenpos.util.LogHandler;
import se.kth.ict.nextgenpos.model.ItemNotFoundException;

import java.io.IOException;

/**
 * A placeholder for the view.
 */
public class View {
    private Controller cont;
    private ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();
    private LogHandler logger;

    /**
     * Creates a new <code>View</code>.
     * @param cont           The controller of the application.
     */
    public View(Controller cont) throws IOException {
        this.cont = cont;
        this.logger = new LogHandler();
        cont.addSalesObserver(new SalesItemDisplay());
    }

    /**
     * Simulates a view. Makes some calls to the controller.
     */
    public void test() {

        cont.makeNewSale();
        enterItem(1);
        enterItem(3);
        /*System.out.println(">>>>> NOTE!!\n" +
                "A null pointer exception will follow since there is no handling" +
                " of non-existing item ids. When you have implemented exception" +
                " handling, there should be some informative printout instead of the" +
                " exception stack trace.");*/
        enterItem(10);
        enterItem(1);
        enterItem(11);

        }


        private void enterItem(int itemId) {
        try {
            int quantity = 1;
            System.out.println("");
            System.out.println("\nResult for item " + itemId + ": " + cont.enterItem(itemId, quantity));
            System.out.println("");
        }catch (ItemNotFoundException exc){
            handleException(exc.getMessage(), exc);
        }
    }

    /**
     * @param uiMsg the message which the user gets.
     * @param exc the message which sent to the log.
     */
    private void handleException(String uiMsg, Exception exc){
        errorMessageHandler.ShowErrorMessage(uiMsg);
        logger.logException(exc);
    }
}
