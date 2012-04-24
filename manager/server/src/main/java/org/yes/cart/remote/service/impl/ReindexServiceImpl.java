package org.yes.cart.remote.service.impl;

import flex.messaging.FlexContext;
import flex.messaging.FlexRemoteCredentials;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.yes.cart.remote.service.ReindexService;
import org.yes.cart.service.domain.ProductService;
import org.yes.cart.web.service.ws.BackdoorService;
import org.yes.cart.web.service.ws.client.BackdoorServiceClientFactory;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 15-May-2011
 * Time: 17:22:15
 */
public class ReindexServiceImpl implements ReindexService {


    /**
     * Reindex all products
     *
     * @param credentials current credentials
     * @return quantity product in created index.
     */
    public int reindexAllProducts(String credentials) {
        return getBackdoorService(credentials).reindexAllProducts();
    }

    /**
     * Reindex product by given sku code.
     *
     * @param credentials current credentials
     * @param pk          product primary key
     * @return quantity product in created index.
     */
    public int reindexProduct(String credentials, long pk) {
        return getBackdoorService(credentials).reindexProduct(pk);
    }


    private BackdoorServiceClientFactory backdoorServiceClientFactory = null;

    private synchronized BackdoorServiceClientFactory getBackdoorServiceClientFactory() {

        if (backdoorServiceClientFactory == null) {
            backdoorServiceClientFactory = new BackdoorServiceClientFactory();
        }

        return backdoorServiceClientFactory;

    }

    /**
     * Bad idea, but i have no chance with new spring security, to get the credentials, because it erased from authentificated session.
     *
     * @param password
     * @return
     */
    private BackdoorService getBackdoorService(final String password) {

        String userName = ((UsernamePasswordAuthenticationToken) FlexContext.getUserPrincipal()).getName();
        //String password = (String) ((UsernamePasswordAuthenticationToken) FlexContext.getUserPrincipal()).getCredentials();

        return getBackdoorServiceClientFactory().getBackdoorService(
                userName,
                password,
                "http://localhost:8080/yes-shop/services/backdoor");

    }

}