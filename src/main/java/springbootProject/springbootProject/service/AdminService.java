package springbootProject.springbootProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springbootProject.springbootProject.domain.entity.Admin;
import springbootProject.springbootProject.domain.repository.AdminRepository;
import springbootProject.springbootProject.dto.AdminDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminDto adminLogin(AdminDto adminDto){

        List<Admin> adminList = adminRepository.findAll();

        for( Admin temp : adminList){
            if(temp.getUsername().equals(adminDto.getUsername()) && temp.getPassword().equals(adminDto.getPassword())){
                AdminDto dto = new AdminDto();
                dto.setId(temp.getId());
                dto.setUsername(temp.getUsername());
                dto.setPassword(temp.getPassword());
                dto.setName(temp.getName());
                return dto;
            }

        }

        return null;
    }
}
