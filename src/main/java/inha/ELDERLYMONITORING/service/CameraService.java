package inha.ELDERLYMONITORING.service;

import inha.ELDERLYMONITORING.domain.Camera;
import inha.ELDERLYMONITORING.domain.Member;
import inha.ELDERLYMONITORING.repository.CameraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CameraService {
    private final CameraRepository cameraRepository;

    @Transactional
    public Long addCamera(Member member, String clientIp) {
        return cameraRepository
                .save(Camera.createCamera(clientIp, member))
                .getId();
    }

    public List<Camera> lists(Member member) {
        return cameraRepository.findCamerasByMember(member);
    }

}
