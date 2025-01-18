package com.postandpost_details.telebeler3.Service;

import com.postandpost_details.telebeler3.Model.Request.CreateTelebeRequest;
import com.postandpost_details.telebeler3.Model.Request.UpdateAgeRequest;
import com.postandpost_details.telebeler3.Model.Response.TelebeResponse;

public interface TelebeService {
    void saveTelebe (CreateTelebeRequest telebe);
    void updateTelebeAge (Long id, UpdateAgeRequest request);
    void deleteTelebe (Long id);
    TelebeResponse getTelebe (Long id);
}
