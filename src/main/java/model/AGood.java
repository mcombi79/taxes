package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AGood {
    protected String name;
    protected GoodCategory category;
    protected Double price;
    protected GoodType goodType;
    protected Double tax;

    @Override
    public String toString() {
        return "1 "+name+ " at "+price;
    }
}
