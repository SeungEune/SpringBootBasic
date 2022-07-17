package lee.SpringBootBasicProject.main.example.mapper;

import lee.SpringBootBasicProject.main.example.dto.ExampleType1Dto;
import lee.SpringBootBasicProject.main.example.vo.ExampleType1VO;

import java.util.List;
import java.util.stream.Collectors;

public class ExampleConvert {

    public ExampleType1Dto toDtoConvertClass(ExampleType1VO exampleType1VO){
        ExampleType1Dto exampleType1Dto = new ExampleType1Dto();

        exampleType1Dto.setCodeClcd(exampleType1VO.getCodeClcd());
        exampleType1Dto.setCodeClcdNm(exampleType1VO.getCodeClcdNm());
        exampleType1Dto.setCodeClcdDc(exampleType1VO.getCodeClcdDc());

        return exampleType1Dto;
    }

    public ExampleType1VO toEntityConvertClass(ExampleType1Dto exampleType1Dto){
        ExampleType1VO exampleType1VO = new ExampleType1VO();

        exampleType1VO.setCodeClcd(exampleType1Dto.getCodeClcd());
        exampleType1VO.setCodeClcdNm(exampleType1Dto.getCodeClcdNm());
        exampleType1VO.setCodeClcdDc(exampleType1Dto.getCodeClcdDc());

        return exampleType1VO;
    }

    public List<ExampleType1Dto> toDtoListConvertClass(List<ExampleType1VO> exampleType1VOList){
        return exampleType1VOList.stream().map(p -> toDtoConvertClass(p)).collect(Collectors.toList());
    }
}
