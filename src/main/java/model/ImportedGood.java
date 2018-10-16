package model;

public class ImportedGood implements IGood {
    @Override
    public Double applyTaxes() {
        return 0.0;
    }

    @Override
    public Double getItemPriceWithTaxes() {
        return 0.0;
    }
}
