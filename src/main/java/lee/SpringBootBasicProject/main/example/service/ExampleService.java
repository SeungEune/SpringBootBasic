package lee.SpringBootBasicProject.main.example.service;

import lee.SpringBootBasicProject.main.example.dto.ExampleType2Dto;
import lee.SpringBootBasicProject.main.example.dto.ExampleType1Dto;

import java.util.List;

public interface ExampleService {

//-----------------DTO, VO class내 Convert Method가 있는 형식---------------------
    ExampleType1Dto exampleType1(ExampleType1Dto exampleType1Dto);

    List<ExampleType1Dto> exampleType1List(ExampleType1Dto exampleType1Dto);
//-----------------DTO, VO class내 Convert Method가 있는 형식---------------------



//-----------------ModelMapper 라이브러리를 사용하는 형식---------------------
    ExampleType2Dto exampleType2(ExampleType2Dto exampleType2Dto);

    List<ExampleType2Dto> exampleType2List(ExampleType2Dto exampleType2Dto);
//-----------------ModelMapper 라이브러리를 사용하는 형식---------------------



//-----------------Class를 따로 생성하여 convert Method 구현 형식---------------------
    ExampleType1Dto exampleType3(ExampleType1Dto exampleType1Dto);

    List<ExampleType1Dto> exampleType3List(ExampleType1Dto exampleType1Dto);
//-----------------Class를 따로 생성하여 convert Method 구현 형식---------------------
}
