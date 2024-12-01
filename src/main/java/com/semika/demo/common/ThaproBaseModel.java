/*
 * ====================================================================
 * Copyright  (c) : 2021 by Kaleris. All rights reserved.
 * ====================================================================
 *
 * The copyright to the computer software herein is the property of Kaleris
 * The software may be used and/or copied only
 * with the written permission of Kaleris or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.semika.demo.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface ThaproBaseModel extends Serializable {

}
