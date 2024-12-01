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

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public class ThaproResponse<DTO> implements ThaproBaseModel {

    private static final long serialVersionUID = -7331133585763668713L;
    private String message;
    private DTO data;
    private List<DTO> dataList = new ArrayList<>();
    //private ThaproPage pagination;

    public ThaproResponse(String message, DTO data) {
        this.message = message;
        this.data = data;
    }

    public ThaproResponse(String message, List<DTO> dataList) {
        this.message = message;
        this.dataList = dataList;
    }
}
