package com.example.bookMyRide.trnasformer;

import com.example.bookMyRide.dto.request.CabRequest;
import com.example.bookMyRide.dto.response.CabResponse;
import com.example.bookMyRide.model.Cab;
import com.example.bookMyRide.model.Enum.CabStatus;

public class CabTransformer {

    public static Cab cabRequestToCab(CabRequest cabRequest) {

        return new Cab.CabBuilder()
                .cabName(cabRequest.getCabName())
                .cabNo(cabRequest.getCabNo())
                .cabStatus(CabStatus.AVAILABLE)
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab) {

        return  new CabResponse.CabResponseBuilder()
                .cabName(cab.getCabName())
                .cabNo(cab.getCabNo())
                .cabStatus(cab.getCabStatus())
                .build();
    }
}
