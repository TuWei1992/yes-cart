/*
 * Copyright 2009 Igor Azarnyi, Denys Pavlov
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.yes.cart.service.customer.impl;

import org.apache.commons.lang.StringUtils;
import org.yes.cart.domain.entity.Address;
import org.yes.cart.domain.entity.Customer;
import org.yes.cart.service.customer.CustomerNameFormatter;

import java.text.MessageFormat;

/**
 * User: denispavlov
 * Date: 06/03/2015
 * Time: 20:45
 */
public class DefaultCustomerNameFormatterImpl implements CustomerNameFormatter {


    private final String nameTemplate;

    public DefaultCustomerNameFormatterImpl(final String nameTemplate) {
        this.nameTemplate = nameTemplate;
    }

    @Override
    public String formatName(final Address address) {
        return formatNameInternal(address, nameTemplate);
    }

    @Override
    public String formatName(final Address address, final String format) {
        if (StringUtils.isBlank(format)) {
            return formatNameInternal(address, nameTemplate);
        }
        return formatNameInternal(address, format);
    }

    private String formatNameInternal(final Address address, final String format) {
        if (address != null) {

            return MessageFormat.format(
                    format,
                    StringUtils.defaultString(address.getFirstname()),
                    StringUtils.defaultString(address.getMiddlename()),
                    StringUtils.defaultString(address.getLastname())
            );
        }
        return StringUtils.EMPTY;
    }

    @Override
    public String formatName(final Customer customer) {
        return formatNameInternal(customer, nameTemplate);
    }

    @Override
    public String formatName(final Customer customer, final String format) {
        return formatNameInternal(customer, format);
    }


    private String formatNameInternal(final Customer customer, final String format) {
        if (customer != null) {

            return MessageFormat.format(
                    format,
                    StringUtils.defaultString(customer.getFirstname()),
                    StringUtils.defaultString(customer.getMiddlename()),
                    StringUtils.defaultString(customer.getLastname())
            );
        }
        return StringUtils.EMPTY;
    }


}
