package inha.ELDERLYMONITORING.repository;

import inha.ELDERLYMONITORING.domain.Camera;
import inha.ELDERLYMONITORING.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CameraRepository extends JpaRepository<Camera, Long> {

    List<Camera> findCamerasByMember(Member member);

}
