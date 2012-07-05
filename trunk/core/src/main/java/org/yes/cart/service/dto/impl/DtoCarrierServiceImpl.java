package org.yes.cart.service.dto.impl;

import com.inspiresoftware.lib.dto.geda.adapter.repository.AdaptersRepository;
import org.yes.cart.domain.dto.CarrierDTO;
import org.yes.cart.domain.dto.factory.DtoFactory;
import org.yes.cart.domain.dto.impl.CarrierDTOImpl;
import org.yes.cart.domain.entity.Carrier;
import org.yes.cart.service.domain.GenericService;
import org.yes.cart.service.dto.DtoCarrierService;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 09-May-2011
 * Time: 14:12:54
 */
public class DtoCarrierServiceImpl
        extends AbstractDtoServiceImpl<CarrierDTO, CarrierDTOImpl, Carrier>
        implements DtoCarrierService {

    /**
     * Construct service.
     *
     * @param dtoFactory               dto factory
     * @param carrierGenericService    generic service to use
     * @param AdaptersRepository convertor factory.
     */
    public DtoCarrierServiceImpl(final DtoFactory dtoFactory,
                                 final GenericService<Carrier> carrierGenericService,
                                 final AdaptersRepository AdaptersRepository) {
        super(dtoFactory, carrierGenericService, AdaptersRepository);
    }


    /**
     * Get the dto interface.
     *
     * @return dto interface.
     */
    public Class<CarrierDTO> getDtoIFace() {
        return CarrierDTO.class;
    }

    /**
     * Get the dto implementation class.
     *
     * @return dto implementation class.
     */
    public Class<CarrierDTOImpl> getDtoImpl() {
        return CarrierDTOImpl.class;
    }

    /**
     * Get the entity interface.
     *
     * @return entity interface.
     */
    public Class<Carrier> getEntityIFace() {
        return Carrier.class;
    }
}