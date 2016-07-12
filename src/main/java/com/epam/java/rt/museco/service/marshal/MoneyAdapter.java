package com.epam.java.rt.museco.service.marshal;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Municipal Service Company
 */
public final class MoneyAdapter extends XmlAdapter<String, Money> {

    public Money unmarshal(String v) throws Exception {
        StringBuilder moneyValue = new StringBuilder(v);
        int i = moneyValue.indexOf("|");
        return Money.of(CurrencyUnit.of(moneyValue.substring(0, i)), Double.valueOf(moneyValue.substring(i + 1)));
    }

    public String marshal(Money v) throws Exception {
        return v.getCurrencyUnit().toString().concat("|").concat(v.getAmount().toString());
    }
}
