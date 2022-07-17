package lee.SpringBootBasicProject.main.example.mapper;

import lee.SpringBootBasicProject.main.example.dto.ExampleType1Dto;
import lee.SpringBootBasicProject.main.example.dto.ExampleType2Dto;
import lee.SpringBootBasicProject.main.example.vo.ExampleType1VO;
import lee.SpringBootBasicProject.main.example.vo.ExampleType2VO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExampleMapper {

//TEST 테이블 생성 쿼리!!
//
//    create table bs_cmmn_code
//    (
//        code_clcd    varchar(10) not null
//        constraint bs_cmmn_code_pk primary key,
//        code_clcd_nm varchar(60) not null,
//        code_clcd_dc varchar(200),
//        ordr         numeric(5),
//        use_yn       varchar(1) default 'Y'::character varying
//    );
//
//    INSERT INTO public.bs_cmmn_code (code_clcd, code_clcd_nm, code_clcd_dc, ordr, use_yn) VALUES ('code1', '탑승자관리코드', '탑승자 기준별 코드화', 4, 'Y');
//    INSERT INTO public.bs_cmmn_code (code_clcd, code_clcd_nm, code_clcd_dc, ordr, use_yn) VALUES ('code2', '배차관리코드', '배차 기준별 코드화', 2, 'Y');
//    INSERT INTO public.bs_cmmn_code (code_clcd, code_clcd_nm, code_clcd_dc, ordr, use_yn) VALUES ('code3', '운행일지관리코드', '운행일지 기준별 코드화', 5, 'Y');
//    INSERT INTO public.bs_cmmn_code (code_clcd, code_clcd_nm, code_clcd_dc, ordr, use_yn) VALUES ('code4', '차량관리코드', '차량 기준별 코드화', 1, 'Y');
//    INSERT INTO public.bs_cmmn_code (code_clcd, code_clcd_nm, code_clcd_dc, ordr, use_yn) VALUES ('code5', '노선관리코드', '노선 기준별 코드화', 3, 'N');



//-----------------DTO, VO class내 Convert Method가 있는 형식---------------------
    ExampleType1VO selectExampleType1(String codeClcd);

    List<ExampleType1VO> selectExampleType1List(ExampleType1Dto exampleType1Dto);
//-----------------DTO, VO class내 Convert Method가 있는 형식---------------------



//-----------------ModelMapper 라이브러리를 사용하는 형식---------------------
    ExampleType2VO selectExampleType2(String codeClde);

    List<ExampleType2VO> selectExampleType2List(ExampleType2Dto exampleType2Dto);
//-----------------ModelMapper 라이브러리를 사용하는 형식---------------------
}
