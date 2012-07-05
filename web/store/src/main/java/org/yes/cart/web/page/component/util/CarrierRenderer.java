package org.yes.cart.web.page.component.util;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.yes.cart.domain.entity.Carrier;

/**
 * User: Igor Azarny iazarnmy@yahoo.com
 * Date: 15-Oct-2011
 * Time: 11:01:06 AM
 */
public class CarrierRenderer  extends ChoiceRenderer<Carrier> {

    /** {@inheritDoc} */
    @Override
    public Object getDisplayValue(final Carrier carrier) {
        return carrier.getName();
    }

    /** {@inheritDoc} */
    @Override
    public String getIdValue(final Carrier carrier, final int i) {
        return String.valueOf(carrier.getCarrierId());
    }

}