package model;

public  class GoodFactory {

    public static IGood createGood(String goodName,GoodCategory goodCategory,Double goodPrice,GoodType goodType){
        if (goodCategory.equals(GoodCategory.IMPORTED)) return new ImportedGood(goodName,goodCategory,goodPrice,goodType);
        if (goodCategory.equals(GoodCategory.DOMESTIC)) return new Good(goodName,goodCategory,goodPrice,goodType);
        else return null;
    }
}
