package com.exaltpawarikanda.msscbeerservice.enums;

/**
 * Created by Exalt Pawarikanda on 7/26/21
 */
public enum BeerStyle implements CharSequence {
    LAGER,PILSNER,ALE,STOUT,GOSE,IPA,PALE_ALE,PORTER;

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
