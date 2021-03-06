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

package org.yes.cart.impl {
import mx.collections.ArrayCollection;

[Bindable]
[RemoteClass(alias="org.yes.cart.domain.dto.impl.ProductDTOImpl")]


public class ProductDTOImpl {

    public var productId:Number;

    public var code : String;

    public var tag : String;

    public var availablefrom:Date ;

    public var availableto:Date ;

    public var availability:Number;

    public var brandDTO:BrandDTOImpl;

    public var productTypeDTO:ProductTypeDTOImpl;

    public var productCategoryDTOs:ArrayCollection; //of ProductCategoryDTOImpl

    public var uri:String;

    public var title:String;

    public var metakeywords:String;

    public var metadescription:String;

    public var displayTitles:Object;

    public var displayMetakeywords:Object;

    public var displayMetadescriptions:Object;

    public var name:String;

    public var displayNames:Object;

    public var description:String ;

    public var featured:Boolean;

    public var attributes:ArrayCollection; // of AttrValueProductDTO

    public var minOrderQuantity:Number;

    public var maxOrderQuantity:Number;

    public var stepOrderQuantity:Number;

    public function ProductDTOImpl() {
    }

    /**
     * Get the org.yes.cart.ui.product rank for given org.yes.cart.ui.category id
     * @param categoryId given org.yes.cart.ui.category id
     * @return rank if found, -1 otherwise
     */
    public function getRank(categoryId:Number):Number {
        if (productCategoryDTOs  != null) {
            for each (var pcDto:ProductCategoryDTOImpl in productCategoryDTOs) {
                if (pcDto.categoryId == categoryId) {
                    return pcDto.rank;
                }
            }
        }
        return -1;
    }

    /**
     * Get the org.yes.cart.ui.product rank for given org.yes.cart.ui.category id
     * @param categoryId given org.yes.cart.ui.category id
     * @return rank if found, -1 otherwise
     */
    public function getProductCategoryDTO(categoryId:Number):ProductCategoryDTOImpl {
        if (productCategoryDTOs  != null) {
            for each (var pcDto:ProductCategoryDTOImpl in productCategoryDTOs) {
                if (pcDto.categoryId == categoryId) {
                    return pcDto;
                }
            }
        }
        return null;
    }


    public function toString():String {
        return "ProductDTOImpl{productId=" + String(productId)
                + ",code=" + String(code)
                + ",availablefrom=" + String(availablefrom)
                + ",availableto=" + String(availableto)
                + ",availability=" + String(availability)
                + ",brandDTO=" + String(brandDTO)
                + ",productTypeDTO=" + String(productTypeDTO)
                + ",productCategoryDTOs=" + String(productCategoryDTOs)
                + ",name=" + String(name)
                + ",description=" + String(description)
                + ",featured=" + String(featured) + "}";
    }

    public function get minOrderQuantityS():String {
        if (isNaN(minOrderQuantity) || minOrderQuantity <= 0) {
            return "";
        }
        return String(minOrderQuantity);
    }

    public function set minOrderQuantityS(value:String):void {
        var _num:Number = new Number(value);
        if (isNaN(_num)) {
            minOrderQuantity = 0;
        } else {
            minOrderQuantity = _num;
        }
    }

    public function get maxOrderQuantityS():String {
        if (isNaN(maxOrderQuantity) || maxOrderQuantity <= 0) {
            return "";
        }
        return String(maxOrderQuantity);
    }

    public function set maxOrderQuantityS(value:String):void {
        var _num:Number = new Number(value);
        if (isNaN(_num)) {
            maxOrderQuantity = 0;
        } else {
            maxOrderQuantity = _num;
        }
    }

    public function get stepOrderQuantityS():String {
        if (isNaN(stepOrderQuantity) || stepOrderQuantity <= 0) {
            return "";
        }
        return String(stepOrderQuantity);
    }

    public function set stepOrderQuantityS(value:String):void {
        var _num:Number = new Number(value);
        if (isNaN(_num)) {
            stepOrderQuantity = 0;
        } else {
            stepOrderQuantity = _num;
        }
    }
}
}