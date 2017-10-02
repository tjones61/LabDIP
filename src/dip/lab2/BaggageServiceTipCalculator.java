package dip.lab2;

/**
 * An example low-level class. Does this class definition follow the DIP? If
 * not, fix it.
 *
 * Any other best practice violations? Fix them too.
 *
 * @author your name goes here
 */
public class BaggageServiceTipCalculator implements TipCalc {

    private static final double GOOD_RATE = 0.20;
    private static final double FAIR_RATE = 0.15;
    private static final double POOR_RATE = 0.10;

    private static final String BASE_TIP_ENTRY_ERR
            = "error: base tip must be greater than or equal to zero";
    private static final String BAG_ENTRY_ERR
            = "bag count must be greater than or equal to zero";

    private double baseTipPerBag;
    private int bagCount;

    private ServiceQuality serviceQuality;

    public BaggageServiceTipCalculator(ServiceQuality quality, int bags) {
        this.setServiceRating(quality); // perform validation
        this.setBagCount(bags);

        baseTipPerBag = 1.00; // set default value
    }

    @Override
    public final double getTip() {
        double tip = 0.00; // always initialize local variables

        switch (serviceQuality) {
            case GOOD:
                tip = baseTipPerBag * bagCount * (1 + GOOD_RATE);
                break;
            case FAIR:
                tip = baseTipPerBag * bagCount * (1 + FAIR_RATE);
                break;
            case POOR:
                tip = baseTipPerBag * bagCount * (1 + POOR_RATE);
                break;
        }

        return tip;
    }

    public final void setServiceRating(ServiceQuality quality) {
        // No need to validate because enums provide type safety!
        serviceQuality = quality;
    }

    public final ServiceQuality getServiceQuality() {
        return serviceQuality;
    }

    public final int getBagCount() {
        return bagCount;
    }

    public final void setBagCount(int bagCount) {
        if (bagCount < 0) {
            throw new IllegalArgumentException(BAG_ENTRY_ERR);
        }
        this.bagCount = bagCount;
    }

    public final double getBaseTipPerBag() {
        return baseTipPerBag;
    }

    public final void setBaseTipPerBag(double baseTipPerBag) {
        if (baseTipPerBag < 0) {
            throw new IllegalArgumentException(BASE_TIP_ENTRY_ERR);
        }
        this.baseTipPerBag = baseTipPerBag;
    }

}
