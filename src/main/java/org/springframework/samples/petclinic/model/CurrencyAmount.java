package org.springframework.samples.petclinic.model;

import org.springframework.format.annotation.NumberFormat;

/**
 * Created by Adeel Ilyas on 6/7/2014.
 */
/*
 * Project Extension Name: Aspose for Spring Java (petclinic)
 *
 * @author: Adeel Ilyas
 * Company: Aspose Pte Ltd.
 *
 * Date: 4/6/2014
 *
 * Detail:
 * This Extension was written to showcase the usage of Aspose APIs for Java
 * (Aspose.Word, Aspose.PDF, Aspose.Cells,Aspose.Email, Aspose Barcode)
 * for Spring, Spring MVC Java Developers.
 */
public class CurrencyAmount {

    public CurrencyAmount(Double billAmount) {
        this.billAmount = billAmount;

    }

    @NumberFormat(style= NumberFormat.Style.CURRENCY)
    private Double billAmount;


    /**
     * Getter for property billAmount.
     *
     * @return Value of property billAmount.
     */
    public Double getBillAmount() {
        return this.billAmount;
    }

    /**
     * Setter for property billAmount.
     *
     * @param billAmount New value of property description.
     */
    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }
}
