package lee.SpringBootBasicProject.main.example.vo;

import lee.SpringBootBasicProject.main.example.dto.ExampleType1Dto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExampleType1VO {
    private String codeClcd;
    private String codeClcdNm;
    private String codeClcdDc;
    private String ordr;
    private String useYn;

    public ExampleType1Dto toDto(){
        ExampleType1Dto exampleType1Dto = new ExampleType1Dto();

        exampleType1Dto.setCodeClcd(this.codeClcd);
        exampleType1Dto.setCodeClcdNm(this.codeClcdNm);
        exampleType1Dto.setCodeClcdDc(this.codeClcdDc);

        return exampleType1Dto;
    }
}
