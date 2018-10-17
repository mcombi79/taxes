package model;

/**
 * Factory for Good creations
 */
public  class GoodFactory {

    public static IGood createGood(String goodName,GoodCategory goodCategory,Double goodPrice,GoodType goodType){

        switch (goodCategory)
        {
            case DOMESTIC: return new Good(goodName,goodCategory,goodPrice,goodType);

            case IMPORTED: return new ImportedGood(goodName,goodCategory,goodPrice,goodType);

                default: return null;

        }

    }
}
