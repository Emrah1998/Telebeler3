package com.postandpost_details.telebeler3.Service;

import com.postandpost_details.telebeler3.Dao.Entity.TelebeEntity;
import com.postandpost_details.telebeler3.Dao.Repository.TelebeRepository;
import com.postandpost_details.telebeler3.Exception.NotFoundException;
import com.postandpost_details.telebeler3.Model.Enum.TelebeStatus;
import com.postandpost_details.telebeler3.Model.Request.CreateTelebeRequest;
import com.postandpost_details.telebeler3.Model.Request.UpdateAgeRequest;
import com.postandpost_details.telebeler3.Model.Response.TelebeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.postandpost_details.telebeler3.Exception.ExceptionConstant.STUDENT_NOT_FOUND_CODE;
import static com.postandpost_details.telebeler3.Exception.ExceptionConstant.STUDENT_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
@Slf4j
public class TelebeServiceHandle implements TelebeService {
    private final TelebeRepository telebeRepository;

    @Override
    public void saveTelebe(CreateTelebeRequest telebe) {
        telebeRepository.save(
                TelebeEntity.builder()
                        .name(telebe.getName())
                        .surname(telebe.getSurname())
                        .age(telebe.getAge())
                        .build()
        );
    }

    @Override
    public void updateTelebeAge(Long id, UpdateAgeRequest request) {

        var telebe = telebeRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        telebe.setAge(request.getAge());
        telebeRepository.save(telebe);
    }

    @Override
    public void deleteTelebe(Long id) {
        var telebe = fetchTelebeIfExist(id);
        telebe.setStatus(TelebeStatus.DELETED);
        telebeRepository.save(telebe);
    }

    @Override
    public TelebeResponse getTelebe(Long id) {
        var telebe = fetchTelebeIfExist(id);
        return new TelebeResponse(telebe.getName(), telebe.getSurname());
    }

    private TelebeEntity fetchTelebeIfExist(Long id) {
        return telebeRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("TelebeLog.fetchTelebeIfExist.error telebe with id: {} not found", id);
                   return new NotFoundException(String.format(STUDENT_NOT_FOUND_MESSAGE,id),
                                                              STUDENT_NOT_FOUND_CODE);
                });
    }
}
