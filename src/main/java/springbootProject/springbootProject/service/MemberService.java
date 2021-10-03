package springbootProject.springbootProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springbootProject.springbootProject.domain.entity.Admin;
import springbootProject.springbootProject.domain.entity.Member;
import springbootProject.springbootProject.domain.repository.AdminRepository;
import springbootProject.springbootProject.domain.repository.MemberRepository;
import springbootProject.springbootProject.dto.AdminDto;
import springbootProject.springbootProject.dto.MemberDto;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;



    public Long joinUser(MemberDto memberDto) {
        return memberRepository.save(memberDto.toEntity()).getId();
    }

    public MemberDto userLogin(MemberDto memberDto){

        List<Member> memberList = memberRepository.findAll();

        for( Member temp : memberList){
            if(temp.getUsername().equals(memberDto.getUsername()) && temp.getPassword().equals(memberDto.getPassword())){
                MemberDto dto = new MemberDto();
                dto.setId(temp.getId());
                dto.setUsername(temp.getUsername());
                dto.setPassword(temp.getPassword());
                dto.setName(temp.getName());
                dto.setAddress(temp.getAddress());
                dto.setDate(temp.getDate());
                dto.setGender(temp.getGender());
                dto.setPhone(temp.getPhone());
                dto.setEmail(temp.getEmail());
                return dto;
            }

        }

        return null;
    }


}
