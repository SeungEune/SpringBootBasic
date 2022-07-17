package lee.SpringBootBasicProject.main.example.dto;

import lee.SpringBootBasicProject.main.example.vo.ExampleType1VO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExampleType1Dto {
    private String codeClcd;
    private String codeClcdNm;
    private String codeClcdDc;

    public ExampleType1VO toEntity(){
        ExampleType1VO exampleType1VO = new ExampleType1VO();

        exampleType1VO.setCodeClcd(this.getCodeClcd());
        exampleType1VO.setCodeClcdNm(this.getCodeClcdNm());
        exampleType1VO.setCodeClcdDc(this.getCodeClcdDc());

        return exampleType1VO;
    }
}
