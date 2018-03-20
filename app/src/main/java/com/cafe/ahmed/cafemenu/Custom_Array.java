package com.cafe.ahmed.cafemenu;

/**
 * Created by ahmed on 3/4/2018.
 */

public class Custom_Array {
    String textKind;
    String textPrice;
    String TotalPrice;
    int image;
    String quantity;
    String textKind1;
    boolean b;

    public Custom_Array(String mTextKind1, String mTextKind, String mTextPrice, int mImage, String mQuantity, String mTotalPrice) {
        textPrice = mTextPrice;
        textKind = mTextKind;
        image = mImage;
        quantity = mQuantity;
        TotalPrice = mTotalPrice;
        textKind1 = mTextKind1;
    }

    public Custom_Array() {

    }

    String gettxetKind() {
        return textKind;
    }

    String getTextPrice() {
        return textPrice;
    }

    int getImage() {
        return image;
    }

    String getQuantityIncrease() {

        int quan = Integer.parseInt(quantity);
        quan++;
        quantity = String.valueOf(quan);
        return quantity;

    }

    String getQuantitydicrease() {
        if (Integer.parseInt(quantity) > 0) {
            int quan = Integer.parseInt(quantity) - 1;

            quantity = String.valueOf(quan);
        }

        return quantity;
    }

    String getTotalPrice() {
        int text_price = Integer.parseInt(textPrice);
        int text_quantity = Integer.parseInt(quantity);
        int total_price = text_price * text_quantity;
        TotalPrice = String.valueOf(total_price);
        return TotalPrice;
    }

    String getTextKind1() {
        return textKind1;
    }

boolean getchecked(boolean check){ check=b;
    return b;
}
}


