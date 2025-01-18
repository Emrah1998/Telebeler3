package com.postandpost_details.telebeler3.Controller;

import com.postandpost_details.telebeler3.Model.Request.CreateTelebeRequest;
import com.postandpost_details.telebeler3.Model.Request.UpdateAgeRequest;
import com.postandpost_details.telebeler3.Model.Response.TelebeResponse;
import com.postandpost_details.telebeler3.Service.TelebeServiceHandle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/telebeler3")
public class TelebeController {
    private final TelebeServiceHandle telebeService;

    @PostMapping
    public void saveTelebe(@RequestBody CreateTelebeRequest telebe){
        telebeService.saveTelebe(telebe);
    }

    @PatchMapping("/{id}/age")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTelebeAge(@PathVariable Long id,
                                @RequestBody UpdateAgeRequest request){
        telebeService.updateTelebeAge(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTelebe(@PathVariable Long id){
        telebeService.deleteTelebe(id);
    }

    @GetMapping("/{id}")
    public TelebeResponse getTelebe(@PathVariable Long id){
        return telebeService.getTelebe(id);
    }
}
